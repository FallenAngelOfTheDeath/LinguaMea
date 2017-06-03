package com.example.ninebit.linguamea.fragment.dictionaries;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.preference.PreferenceManagerFix;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ninebit.linguamea.R;
import com.example.ninebit.linguamea.activity.EditorActivity;
import com.example.ninebit.linguamea.activity.PreferenceActivity;
import com.example.ninebit.linguamea.adapter.recyclerview.CustomDictionaryAdapter;
import com.example.ninebit.linguamea.database.schemes.CustomDictionaryDBSchema;
import com.example.ninebit.linguamea.interfaces.ClickListener;
import com.example.ninebit.linguamea.model.CustomDictionaryModel;
import com.example.ninebit.linguamea.model.Singleton;
import com.example.ninebit.linguamea.utils.ToolbarActionMode;

import java.util.ArrayList;
import java.util.List;

public class CustomDictionaryFragment extends Fragment implements ClickListener, View.OnClickListener {

    private RecyclerView mRecyclerView;
    private CustomDictionaryAdapter mAdapter;
    private ArrayList<CustomDictionaryModel> mListItems;
    private CustomDictionaryAdapter.ViewHolder mViewHolder;
    private ActionMode mActionMode;
    private String LOGTAG = "OIDF";
    private boolean searchByTranslationPreference;



    public CustomDictionaryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_oi_dictionary, container, false);
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab_add);
        fab.setOnClickListener(this);

        populateRecyclerView(view);
        updateUI();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences sharedPreferencesCompat = PreferenceManagerFix.getDefaultSharedPreferences(getActivity());
        searchByTranslationPreference = sharedPreferencesCompat.getBoolean("search_by_translation", false);
        updateUI();
    }

    private void populateRecyclerView(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_oi_dictionary);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mListItems = new ArrayList<>();
        mAdapter = new CustomDictionaryAdapter(mListItems, getActivity(), this);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void updateUI(){
        Singleton singleton = Singleton.getInstance(getActivity());
        List<CustomDictionaryModel> words = singleton.getWordList();
        if (mAdapter == null) {
            mAdapter = new CustomDictionaryAdapter(mListItems, getActivity(), this);
            mRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.setItems(words);
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
//            case R.id.floating_button_oi:
//                addWord();
//                break;
        }
    }

    @Override
    public void onItemClicked(View view, int position) {
        if (mActionMode != null){
            itemSelect(position);
        }else{
            openInformation(position);
        }
        Log.i(LOGTAG, "onItemClicked");
    }

    @Override
    public boolean onItemLongClicked(View view, int position) {
        itemSelect(position);
        Log.i(LOGTAG, "onItemLongClicked");
        return true;
    }

    @Override
    public void onOptionsClicked(View view, int position) {
        popupMenu(position, view);
        Log.i(LOGTAG, "onOptionsClicked");
    }

    public void itemSelect(int position) {
        mAdapter.toggleSelection(position);//Toggle the selection
        boolean hasCheckedItems = mAdapter.getSelectedCount() > 0;
        if (hasCheckedItems && mActionMode == null) {
            mActionMode = ((AppCompatActivity) getActivity()).startSupportActionMode(new ToolbarActionMode(mAdapter, this));
        }else if (!hasCheckedItems && mActionMode != null) {
            mActionMode.finish();
        }
        if (mActionMode != null)
            mActionMode.setTitle(String.valueOf(mAdapter
                    .getSelectedCount()) + " selected");
    }

    public void setNullToActionMode() {
        if (mActionMode != null)
            mActionMode = null;
    }

    public void popupMenu (final int position, final View view){
        final CustomDictionaryModel itemList = mAdapter.getItemList(position);
        final PopupMenu popupMenu = new PopupMenu(getActivity(), view);
        popupMenu.inflate(R.menu.item_popup_menu);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.popup_menu_learned:
                        mAdapter.changeLearnedStatus(itemList, position);
                        Singleton.getInstance(getActivity()).updateWord(itemList);
                        Toast.makeText(getActivity(), R.string.learned_status, Toast.LENGTH_LONG).show();
                        Log.i(LOGTAG, "popup menu/change learned status");
                        break;
                    case R.id.popup_menu_edit:
                        Toast.makeText(getActivity(), "popup menu/editor", Toast.LENGTH_LONG).show();
                        Log.i(LOGTAG, "popup menu/editor");
                        break;
                    case R.id.popup_menu_delete:
                        //mAdapter.deleteItem(position, mRecyclerView);
                        Toast.makeText(getActivity(), R.string.word_deleted, Toast.LENGTH_LONG).show();
                        Log.i(LOGTAG, "popup menu/word has been deleted");

                        Snackbar snackbar = Snackbar
                                .make(mRecyclerView, getActivity().getString(R.string.removed_from_device), Snackbar.LENGTH_INDEFINITE)
                                .setAction(R.string.undo, new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        mAdapter.undoOfDeletingItem(position, itemList, mRecyclerView);
                                        Singleton.getInstance(getActivity()).saveWord(itemList);
                                    }
                                });
                        snackbar.setDuration(30000);
                        snackbar.show();
                        mAdapter.removeItem(position, mRecyclerView);

                        Singleton.getInstance(getActivity()).deleteWord(itemList);

                        break;
                    case R.id.popup_menu_move_to:
                        Toast.makeText(getActivity(), "popup menu/move to", Toast.LENGTH_LONG).show();
                        Log.i(LOGTAG, "popup menu/move to");
                        break;
                    case R.id.popup_menu_share:
                        Toast.makeText(getActivity(), "popup menu/share", Toast.LENGTH_LONG).show();
                        Log.i(LOGTAG, "popup menu/share");
                        break;
                    case R.id.popup_menu_more_info_about_this:
                        openInformation(position);
                        Log.i(LOGTAG, "popup menu/more about this");
                        break;
                }
                return true;
            }

        });
        popupMenu.show();
    }

    public void searchInDictionary (String where, String text){
        Singleton.getInstance(getActivity()).getSearchResult(where, text);
        Log.i("MyLog", "Search string: " + text);
        if (text.isEmpty()){
            updateUI();
        }else {
            searchUpdateUI(where, text);
        }
    }

    private void searchUpdateUI(String where, String s){
        Singleton singleton = Singleton.getInstance(getActivity());
        List<CustomDictionaryModel> words = singleton.getSearchResult(where, s);
        if (mAdapter == null) {
            mAdapter = new CustomDictionaryAdapter(mListItems, getActivity(), null);
            mRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.setItems(words);
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.clearFocus();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                String searchByTranslationPreferenceStr = String.valueOf(searchByTranslationPreference);
                switch (searchByTranslationPreferenceStr){
                    case "true":
                        Log.i("MyLog", "Search boolean: " + searchByTranslationPreferenceStr);
                        searchInDictionary(CustomDictionaryDBSchema.CustomDictionaryTable.Columns.TRANSLATION, newText);
                        break;
                    case "false":
                        Log.i("MyLog", "Search boolean: " + searchByTranslationPreferenceStr);
                        searchInDictionary(CustomDictionaryDBSchema.CustomDictionaryTable.Columns.WORD, newText);
                        break;
                }
                return true;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_settings:
                Intent intent = new Intent(getActivity(), PreferenceActivity.class);
                startActivity(intent);
                break;
            case R.id.action_refresh:
                mAdapter.notifyDataSetChanged();
                mRecyclerView.scrollToPosition(0);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void addWord () {
        Intent intent = new Intent(getActivity(), EditorActivity.class);
        startActivity(intent);
    }

    public void openInformation(int position){
        final CustomDictionaryModel itemList = mAdapter.getItemList(position);
        Intent intent = EditorActivity.newIntent(getActivity(), itemList.getUUID(), false);
        getActivity().startActivity(intent);
        Log.i(LOGTAG, "extra (linID put Extra): " + itemList.getUUID().toString());
    }

}

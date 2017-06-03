package com.example.ninebit.linguamea.fragment.dictionaries;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.ninebit.linguamea.MainActivity;
import com.example.ninebit.linguamea.R;
import com.example.ninebit.linguamea.activity.EditorActivity;
import com.example.ninebit.linguamea.activity.PreferenceActivity;
import com.example.ninebit.linguamea.adapter.RecyclerViewAdapter;
import com.example.ninebit.linguamea.database.schemes.CustomDictionaryDBSchema;
import com.example.ninebit.linguamea.model.CustomDictionaryModel;
import com.example.ninebit.linguamea.model.Singleton;
import com.example.ninebit.linguamea.utils.ItemClickSupport;
import com.example.ninebit.linguamea.utils.ToolbarActionModeCallback;

import java.util.ArrayList;
import java.util.List;

public class OIDictionaryFragment extends Fragment{

    private RecyclerView recyclerView;
    private RecyclerViewAdapter.ViewHolder mViewHolder;
    private RecyclerViewAdapter adapter;
    private ArrayList<CustomDictionaryModel> listItems;
    private List<CustomDictionaryModel> itemList;
    private ArrayList<CustomDictionaryModel> selectedListItems;
    private boolean searchByTranslationPreference;
    public ActionMode mActionMode;
    private MainActivity mMainActivity;
    private String LOGTAG = "CDFEvent";

    public OIDictionaryFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_custom_dictionary, container, false);
        //FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.floating_button_add_custom_dictionary);
        //fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                addWord();
//            }
//        });
        //populateRecyclerView(view);
        //implementRecyclerViewClickListeners();
        //updateUI();
        return view;
    }

    private void implementRecyclerViewClickListeners() {
        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View view) {
                Log.i(LOGTAG, "on;41Click");
            }
        });

//        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new RecyclerClickListener() {
//            @Override
//            public void onClick(View view, int position) {
//                Log.i(LOGTAG, "onClick");
//                //If ActionMode not null select item
//                if (mActionMode != null){
//                    onListItemSelect(position);
//                }else{
//                   // adapter.getMoreInformation(position);
//                }
//            }
//            @Override
//            public void onLongClick(View view, int position) {
//                Log.i(LOGTAG, "onLongClick");
//                onListItemSelect(position);
//            }
//
//            @Override
//            public void onOptionsClick(View view, RecyclerViewAdapter.ViewHolder viewHolder, int position) {
//
//            }
//        }));

    }



    //List item select method
    public void onListItemSelect(int position) {
        adapter.toggleSelection(position);//Toggle the selection

        boolean hasCheckedItems = adapter.getSelectedCount() > 0;//Check if any items are already selected or not

        if (hasCheckedItems && mActionMode == null) {
            // there are some selected items, start the actionMode
            mActionMode = ((AppCompatActivity) getActivity()).startSupportActionMode(new ToolbarActionModeCallback(getActivity(), adapter, OIDictionaryFragment.this, listItems));
        }else if (!hasCheckedItems && mActionMode != null) {
            // there no selected items, finish the actionMode
            mActionMode.finish();
        }
        if (mActionMode != null)
            //set action mode title on item selection
            mActionMode.setTitle(String.valueOf(adapter
                    .getSelectedCount()) + " selected");
    }

    //Set action mode null after use
    public void setNullToActionMode() {
        if (mActionMode != null)
            mActionMode = null;
    }

    private void populateRecyclerView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_custom_dictionary);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        listItems = new ArrayList<>();
        adapter = new RecyclerViewAdapter(listItems, getActivity());
        recyclerView.setAdapter(adapter);
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
                adapter.notifyDataSetChanged();
                recyclerView.scrollToPosition(0);
                break;
        }
        return super.onOptionsItemSelected(item);
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

//    @Override
//    public void onResume() {
//        super.onResume();
//        //get preferences
//        SharedPreferences sharedPreferencesCompat = PreferenceManagerFix.getDefaultSharedPreferences(getActivity());
//        searchByTranslationPreference = sharedPreferencesCompat.getBoolean("search_by_translation", false);
//        //update ui after action
//        updateUI();
//    }

    private void addWord () {
        Intent intent = new Intent(getActivity(), EditorActivity.class);
        startActivity(intent);
    }

    private void updateUI(){
        Singleton singleton = Singleton.getInstance(getActivity());
        List<CustomDictionaryModel> words = singleton.getWordList();
            if (adapter == null) {
                adapter = new RecyclerViewAdapter(listItems, getActivity());
                recyclerView.setAdapter(adapter);
            } else {
                adapter.setWords(words);
                adapter.notifyDataSetChanged();
            }
    }

    private void searchUpdateUI(String where, String s){
        Singleton singleton = Singleton.getInstance(getActivity());
        List<CustomDictionaryModel> words = singleton.getSearchResult(where, s);
        if (adapter == null) {
            adapter = new RecyclerViewAdapter(listItems, getActivity());
            recyclerView.setAdapter(adapter);
        } else {
            adapter.setWords(words);
            adapter.notifyDataSetChanged();
        }
    }
}

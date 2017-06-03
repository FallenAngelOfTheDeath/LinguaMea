package com.example.ninebit.linguamea.fragment.dictionaries;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ninebit.linguamea.R;
import com.example.ninebit.linguamea.adapter.recyclerview.MainDictionaryAdapter;
import com.example.ninebit.linguamea.database.schemes.MainDictionaryDBScheme;
import com.example.ninebit.linguamea.interfaces.ClickListener;
import com.example.ninebit.linguamea.model.MainDictionaryModel;
import com.example.ninebit.linguamea.model.Singleton;

import java.util.ArrayList;
import java.util.List;

public class MainDictionaryFragment extends Fragment implements View.OnClickListener, View.OnLongClickListener {

    private String LOG_TAG = "MAIN_DICTIONARY";

    private RecyclerView recyclerView;
    private ArrayList<MainDictionaryModel> listItems;
    private MainDictionaryAdapter adapter;
    private ActionMode mActionMode;
    private Context mContext;
    private ClickListener mClickListener;

    public MainDictionaryFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_dictionary, container, false);
        populateRecyclerView(view);
        updateUI();

//        Singleton singleton = Singleton.getInstance(getActivity());
//        List<DictionaryModel> words = singleton.getMItemsList(MainDictionaryDBScheme.WordTable.NAME, null, null, null, null, null, null);
//        List<DictionaryModel> forms = singleton.getFormItemsList(MainDictionaryDBScheme.FormTable.NAME,null, null, null, null, null, null);

        return view;
    }

    private void populateRecyclerView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_maim_dictionary);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        listItems = new ArrayList<>();
        adapter = new MainDictionaryAdapter(listItems, getActivity(), mClickListener);
        recyclerView.setAdapter(adapter);
    }

    private void updateUI(){
        Singleton singleton = Singleton.getInstance(getActivity());
        List<MainDictionaryModel> words = singleton.getMainItemsList(MainDictionaryDBScheme.MainDictionaryTable.NAME, null, null, null, null, null, MainDictionaryDBScheme.MainDictionaryTable.Columns.WORD);
        if (adapter == null) {
            adapter = new MainDictionaryAdapter(listItems, getActivity(), null);
            recyclerView.setAdapter(adapter);
        } else {
            adapter.setItems(words);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }
}

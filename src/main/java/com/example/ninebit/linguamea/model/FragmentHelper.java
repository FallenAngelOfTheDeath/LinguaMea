package com.example.ninebit.linguamea.model;

import android.support.v4.app.Fragment;

/**
 * Created by NineB on 4/18/2017.
 *///new MainDictionaryAdapter(listItems, getActivity(), null);

public abstract class FragmentHelper<T> extends Fragment {

//    private RecyclerView mRecyclerView;
//    private ClickListener mClickListener;
//    private ArrayList<T> mListItems;
//    private Adapter adapter;
//
//    public FragmentHelper(Adapter adapter) {
//       this.adapter = adapter;
//
//    }
//
//
//    protected abstract Adapter mRVAdapter();
//    protected abstract RecyclerViewAdapter mRVAdapter2();
//    //protected abstract Adapter mAdapter();
//
//    public FragmentHelper(ArrayList<T> mListItems) {
//        this.mListItems = mListItems;
//    }
//
//
//    public void updateUI(){
//        Singleton singleton = Singleton.getInstance(getActivity());
//        List<MainDictionaryModel> words = singleton.getMainItemsList(MainDictionaryDBScheme.MainDictionaryTable.NAME, null, null, null, null, null, MainDictionaryDBScheme.MainDictionaryTable.Columns.WORD);
//        if (adapter == null) {
//            adapter = mRVAdapter();
//            mRecyclerView.setAdapter(adapter);
//        } else {
//            mRVAdapter2();
//            //adapter.setItems(words);
//            adapter.notifyDataSetChanged();
//        }
//    }
//
//    private void populateRecyclerView(View view) {
//        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_maim_dictionary);
//        mRecyclerView.setHasFixedSize(true);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        mListItems = new ArrayList<>();
//        adapter = mRVAdapter();
//        mRecyclerView.setAdapter(adapter);
//
//    }


}

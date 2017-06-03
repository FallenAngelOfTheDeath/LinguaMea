package com.example.ninebit.linguamea.utils;

import android.content.Context;
import android.support.v7.view.ActionMode;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ninebit.linguamea.R;
import com.example.ninebit.linguamea.adapter.recyclerview.CustomDictionaryAdapter;
import com.example.ninebit.linguamea.fragment.dictionaries.CustomDictionaryFragment;
import com.example.ninebit.linguamea.model.CustomDictionaryModel;

import java.util.ArrayList;

public class ToolbarActionMode implements ActionMode.Callback {

    private Context context;
    private CustomDictionaryAdapter mRecyclerViewAdapter;
    private CustomDictionaryFragment mCustomDictionaryFragment;
    private ArrayList<CustomDictionaryModel> mMessageModels;
    private SparseBooleanArray mSparseBooleanArray;
    private String LOG_TAG = "ToolbarActionMode";

    //ArrayList<MyModel> mMessageModels,  Context contextr,MainDictionaryFragment infofragment
    public ToolbarActionMode(CustomDictionaryAdapter mRecyclerViewAdapter, CustomDictionaryFragment infofragment) {
       // this.context = context;
        this.mRecyclerViewAdapter = mRecyclerViewAdapter;
        this.mCustomDictionaryFragment = infofragment;
        //this.mMessageModels = mMessageModels;
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        mode.getMenuInflater().inflate(R.menu.action_mode_menu, menu);//Inflate the menu over action mode
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        menu.findItem(R.id.action_delete).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        menu.findItem(R.id.action_copy).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return true;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_delete:

                mode.finish();
                break;
            case R.id.action_copy:

                mode.finish();
                break;
        }
        return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {
        mRecyclerViewAdapter.removeSelection();
        mCustomDictionaryFragment.setNullToActionMode();
        Log.i(LOG_TAG, "onDestroyActionMode");
    }
}

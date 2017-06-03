package com.example.ninebit.linguamea.utils;

import android.content.Context;
import android.support.v7.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ninebit.linguamea.R;
import com.example.ninebit.linguamea.adapter.RecyclerViewAdapter;
import com.example.ninebit.linguamea.fragment.dictionaries.OIDictionaryFragment;
import com.example.ninebit.linguamea.model.CustomDictionaryModel;

import java.util.ArrayList;

public class ToolbarActionModeCallback implements ActionMode.Callback {

    private Context context;
    private RecyclerViewAdapter mRecyclerViewAdapter;
    private OIDictionaryFragment mOIDictionaryFragment;
    private ArrayList<CustomDictionaryModel> mMessageModels;


    public ToolbarActionModeCallback(Context context, RecyclerViewAdapter mRecyclerViewAdapter, OIDictionaryFragment infofragment, ArrayList<CustomDictionaryModel> mMessageModels) {
        this.context = context;
        this.mRecyclerViewAdapter = mRecyclerViewAdapter;
        this.mOIDictionaryFragment = infofragment;
        this.mMessageModels = mMessageModels;
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        mode.getMenuInflater().inflate(R.menu.action_mode_menu, menu);//Inflate the menu over action mode
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        //menu.findItem(R.id.action_search).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        menu.findItem(R.id.action_delete).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        menu.findItem(R.id.action_copy).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        // mSearchView.requestFocus();

        return true;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_delete:
                mRecyclerViewAdapter.deleteRows();
                mode.finish();
                break;
            case R.id.action_copy:
                mRecyclerViewAdapter.changeLearnedStatusAtSelected();
                mode.finish();
                break;
        }
        return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {
            mRecyclerViewAdapter.removeSelection();
            mOIDictionaryFragment.setNullToActionMode();
    }
}

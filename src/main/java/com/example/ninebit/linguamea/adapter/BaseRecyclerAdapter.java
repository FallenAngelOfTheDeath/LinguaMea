package com.example.ninebit.linguamea.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.example.ninebit.linguamea.R;
import com.example.ninebit.linguamea.model.CustomDictionaryModel;
import com.example.ninebit.linguamea.model.Singleton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NineB on 4/8/2017.
 */

public abstract class BaseRecyclerAdapter<T, VH extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter<VH> {

    protected List<T> mItems = new ArrayList<>();
    protected SparseBooleanArray mSelectedItemsIds;
    protected Context mContext;
    protected LayoutInflater inflater;

    public BaseRecyclerAdapter(List<T> mItems, Context mContext) {
        this.mItems = mItems;
        this.mContext = mContext;
        mSelectedItemsIds = new SparseBooleanArray();
        inflater = LayoutInflater.from(mContext);
    }

    public List<T> getDataSource() {
        return mItems;
    }


    public void updateListViewData(List<T> lists) {
        mItems.clear();
        if (lists != null) {
            mItems.addAll(lists);
            notifyDataSetChanged();
        }
    }



    ///_______________________________________UTILS_______________________________________
    public void addData(List<T> newItems) {
        if (newItems != null) {
            mItems.addAll(newItems);
            notifyDataSetChanged();
        }
    }

    public void setWords (List<T> words) {
        mItems = words;
    }


    public T getItem(int position) {
        position = Math.max(0, position);
        return mItems.get(position);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    ///_______________________________________HOLDER_______________________________________

     @Override
    public void onBindViewHolder(final VH holder, final int position) {
        final T item = getItem(position);
        bindItemData(holder, item, position);
    }

    protected abstract void bindItemData(VH viewHolder, T data, int position);

//    public RecyclerView.ViewHolder dff(final VH holder){
//        return holder;
//    }

    ////_____________________________________LISTENERS______________________________________




    ////______________________________________ACTIONS_______________________________________
    //Delete
    protected void deleteItem(int position) {
        mItems.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,mItems.size());
        Toast.makeText(mContext, R.string.word_deleted, Toast.LENGTH_LONG).show();
    }

    //Learned__DB
    protected   void learnedStatus (CustomDictionaryModel itemList, Boolean bool, int position){
        itemList.setLearned(bool);
        Singleton.getInstance(mContext).updateWord(itemList);
        notifyItemChanged(position);
    }



    ////__________________________________MULTI_SELECTION___________________________________

    //Put or delete selected position into SparseBooleanArray
    public void selectView(int position, boolean value) {
        if (value) {
            mSelectedItemsIds.put(position, value);
            notifyItemChanged(position);
        } else {
            mSelectedItemsIds.delete(position);
            notifyItemChanged(position);
        }
    }

    //Toggle selection methods
    public void toggleSelection(int position) {
        selectView(position, !mSelectedItemsIds.get(position));
        Log.i("MyLog", "Toggle Selection");
    }

    //Remove selected selections
    public void removeSelection() {
        mSelectedItemsIds.clear();
        notifyDataSetChanged();
    }

    //Get total selected count
    public int getSelectedCount() {
        return mSelectedItemsIds.size();
    }

    //Return all selected ids
    public SparseBooleanArray getSelectedIds() {
        return mSelectedItemsIds;
    }

}

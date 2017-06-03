package com.example.ninebit.linguamea.adapter.recyclerview;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;

import com.example.ninebit.linguamea.R;
import com.example.ninebit.linguamea.interfaces.ClickListener;
import com.example.ninebit.linguamea.model.CustomDictionaryModel;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAbstractAdapter<T, VH extends RecyclerView.ViewHolder>
		extends RecyclerView.Adapter<VH> {

	protected List<T> mListItems = new ArrayList<>();
	protected Context mContext;
	protected LayoutInflater inflater;
	protected SparseBooleanArray mSelectedItems;
	protected ClickListener clickListener;
	public boolean checkOfUndo;

	public BaseAbstractAdapter(List<T> mListItems, Context mContext, ClickListener clickListener) {
		this.mListItems = mListItems;
		this.mContext = mContext;
		this.clickListener = clickListener;
		mSelectedItems = new SparseBooleanArray();
	}

	public boolean isCheckOfUndo() {
		return checkOfUndo;
	}

	public void setCheckOfUndo(boolean checkOfUndo) {
		this.checkOfUndo = checkOfUndo;
	}

	/*
	*
	* Base
	*
	*/

	@Override
	public int getItemCount() {
		return mListItems.size();
	}

	public void setItems (List<T> words) {
		mListItems = words;
	}

	public T getItemList (int position){
		final T itemList = mListItems.get(position);
		return itemList;
	}

	public void deleteItem (final int position, final RecyclerView mRecyclerView){
		final T itemList = mListItems.get(position);
		Snackbar snackbar = Snackbar
				.make(mRecyclerView, mContext.getString(R.string.removed_from_device), Snackbar.LENGTH_LONG)
				.setAction(R.string.undo, new View.OnClickListener() {
					@Override
					public void onClick(View v) {

					}
				});
		snackbar.show();
	}



	public void removeItem (final int position, final RecyclerView mRecyclerView){
		mListItems.remove(position);
		notifyItemRemoved(position);
		notifyItemRangeChanged(position,mListItems.size());
		mRecyclerView.scrollToPosition(position);
	}

	public void undoOfDeletingItem(final int position, final T itemList, final RecyclerView mRecyclerView){
		mListItems.add(position,itemList);
		notifyItemInserted(position);
		mRecyclerView.scrollToPosition(position);
		setCheckOfUndo(true);
	}



	public void changeLearnedStatus (CustomDictionaryModel itemList, int position){
		Boolean status = itemList.getLearned();
		if (status == true){
			itemList.setLearned(false);
		} else {
			itemList.setLearned(true);
		}
		notifyItemChanged(position);
	}
//
//	/*
//	*
//	* Multi selection
//	*
//	*/
	public boolean isSelected(int position) {
		return getSelectedItems().contains(position);
	}

	public void toggleSelection(int position) {
		if (mSelectedItems.get(position, false)) {
			mSelectedItems.delete(position);
		} else {
			mSelectedItems.put(position, true);
		}
		notifyItemChanged(position);
	}

	public void clearSelection() {
		List<Integer> selection = getSelectedItems();
		mSelectedItems.clear();
		for (Integer i : selection) {
			notifyItemChanged(i);
		}
	}

	public void removeSelection() {
		mSelectedItems.clear();
		notifyDataSetChanged();
	}

	public int getSelectedCount() {
		return mSelectedItems.size();
	}

	public List<Integer> getSelectedItems() {
		List<Integer> items = new ArrayList<>(mSelectedItems.size());
		for (int i = 0; i < mSelectedItems.size(); ++i) {
			items.add(mSelectedItems.keyAt(i));
		}
		return items;
	}
}

//package com.example.ninebit.linguamea.adapter.OI;
//
//		import android.support.v7.widget.RecyclerView;
//		import android.util.SparseBooleanArray;
//
//		import java.util.ArrayList;
//		import java.util.List;
//
//public abstract class SelectableAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
//
//	private SparseBooleanArray selectedItems;
//
//	public SelectableAdapter() {
//		selectedItems = new SparseBooleanArray();
//	}
//
//	public boolean isSelected(int position) {
//		return getSelectedItems().contains(position);
//	}
//
//	public void toggleSelection(int position) {
//		if (selectedItems.get(position, false)) {
//			selectedItems.delete(position);
//		} else {
//			selectedItems.put(position, true);
//		}
//		notifyItemChanged(position);
//	}
//
//	public void clearSelection() {
//		List<Integer> selection = getSelectedItems();
//		selectedItems.clear();
//		for (Integer i : selection) {
//			notifyItemChanged(i);
//		}
//	}
//
//	public int getSelectedItemCount() {
//		return selectedItems.size();
//	}
//
//	public List<Integer> getSelectedItems() {
//		List<Integer> items = new ArrayList<>(selectedItems.size());
//		for (int i = 0; i < selectedItems.size(); ++i) {
//			items.add(selectedItems.keyAt(i));
//		}
//		return items;
//	}
//}
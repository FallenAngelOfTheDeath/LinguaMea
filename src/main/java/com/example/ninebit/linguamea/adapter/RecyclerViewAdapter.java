package com.example.ninebit.linguamea.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ninebit.linguamea.R;
import com.example.ninebit.linguamea.activity.EditorActivity;
import com.example.ninebit.linguamea.model.CustomDictionaryModel;
import com.example.ninebit.linguamea.model.Singleton;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<CustomDictionaryModel> listItems;
    private Context mContext;
    private SparseBooleanArray mSelectedItemsIds;

    public RecyclerViewAdapter(List<CustomDictionaryModel> listItems, Context mContext) {
        this.listItems = listItems;
        this.mContext = mContext;
        mSelectedItemsIds = new SparseBooleanArray();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final CustomDictionaryModel itemList = listItems.get(position);

        holder.mUUID.setText(itemList.getUUID().toString());
        holder.mWord.setText(itemList.getWord());
        holder.mTranslation.setText(itemList.getTranslation());

        /** Change background color of the selected items in list view  **/
        holder.mWord
                .setTextColor(mSelectedItemsIds.get(position) ? mContext.getResources().getColor(R.color.selected_item_color)
                        : Color.BLACK);
        holder.mTranslation
                .setTextColor(mSelectedItemsIds.get(position) ? mContext.getResources().getColor(R.color.selected_item_color)
                        : mContext.getResources().getColor(R.color.translation_color));

        holder.mOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupMenu(holder, position);
            }
        });

        if (itemList.getLearned() == true){
            holder.mCardView.setBackgroundColor(mContext.getResources().getColor(R.color.learned_color_main));
        }else{
            holder.mCardView.setBackgroundColor(Color.WHITE);
        }
    }

    public void changeLearnedStatusAtSelected (){
        SparseBooleanArray selected = getSelectedIds();//Get selected ids
        //Loop all selected ids
        for (int item = (selected.size() - 1); item >= 0; item--) {
            if (selected.valueAt(item)) {
                final CustomDictionaryModel itemList = listItems.get(selected.keyAt(item));
                String learnedStatus = itemList.getLearned().toString();
                switch (learnedStatus){
                    case "true":
                        Log.i("MyLog", "learned status: " + learnedStatus  + " changed to false");
                        learnedStatus(itemList, false, item);
                        break;
                    case "false":
                        Log.i("MyLog", "learned status: " + learnedStatus + " changed to true");
                        learnedStatus(itemList, true, item);
                        break;
                }

            }
        }
    }

    //Delete selected rows
    public void deleteRows() {
        SparseBooleanArray selected = getSelectedIds();//Get selected ids
        //Loop all selected ids
        for (int item = (selected.size() - 1); item >= 0; item--) {
            if (selected.valueAt(item)) {
                final CustomDictionaryModel itemList = listItems.get(selected.keyAt(item));
                listItems.remove(selected.keyAt(item));
                notifyItemRangeChanged(item,listItems.size());
                Singleton.getInstance(mContext).deleteWord(itemList);
                Log.i("MyLog", "Word from itemList: " + item);
                removeSelection();
            }
        }
        Toast.makeText(mContext, selected.size() + " item deleted.", Toast.LENGTH_SHORT).show();//Show Toast
    }

    public void getMoreInformation(int position){
        final CustomDictionaryModel itemList = listItems.get(position);
        Intent intent = EditorActivity.newIntent(mContext, itemList.getUUID(), false);
        mContext.startActivity(intent);
        Log.i("LogIdFromIntent", "extra (linID put Extra): " + itemList.getUUID().toString());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public void setWords (List<CustomDictionaryModel> words) {
        listItems = words;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mWord, mTranslation, mUUID;
        public ImageView mOptions;
        public CardView mCardView;

        public ViewHolder(View itemView) {
            super(itemView);
            mUUID = (TextView) itemView.findViewById(R.id.item_uuid_text_view);
            mWord = (TextView) itemView.findViewById(R.id.item_word_text_view);
            mTranslation = (TextView) itemView.findViewById(R.id.item_translation_text_view);
            mOptions = (ImageView) itemView.findViewById(R.id.item_options_menu);
            mCardView = (CardView) itemView.findViewById(R.id.item_card_view);
        }
    }

    private void popupMenu (ViewHolder holder, final int position){
        final CustomDictionaryModel itemList = listItems.get(position);
        final PopupMenu popupMenu = new PopupMenu(mContext, holder.mOptions);
        popupMenu.inflate(R.menu.item_popup_menu);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.popup_menu_learned:
                        String learnedStatus = itemList.getLearned().toString();
                        switch (learnedStatus){
                            case "true":
                                Log.i("MyLog", "learned status: " + learnedStatus  + " changed to false");
                                learnedStatus(itemList, false, position);
                                break;
                            case "false":
                                Log.i("MyLog", "learned status: " + learnedStatus + " changed to true");
                                learnedStatus(itemList, true, position);
                                break;
                        }
                        Toast.makeText(mContext, "I know this", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.popup_menu_edit:
                        Intent intent = EditorActivity.newIntent(mContext, itemList.getUUID(), true);
                        mContext.startActivity(intent);
                        Log.i("LogIdFromIntent", "extra (linID put Extra): " + itemList.getUUID().toString());
                        break;
                    case R.id.popup_menu_delete:
                        listItems.remove(position);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position,listItems.size());
                        Singleton.getInstance(mContext).deleteWord(itemList);
                        Toast.makeText(mContext, R.string.word_deleted, Toast.LENGTH_LONG).show();
                        break;
                    case R.id.popup_menu_move_to:
                        Toast.makeText(mContext, "I move this", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.popup_menu_share:
                        Toast.makeText(mContext, "I share this", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.popup_menu_more_info_about_this:
                        getMoreInformation(position);
                        break;

                }
                return false;
            }
        });
        popupMenu.show();
    }

    private  void learnedStatus (CustomDictionaryModel itemList, Boolean bool, int position){
        itemList.setLearned(bool);
        Singleton.getInstance(mContext).updateWord(itemList);
        notifyItemChanged(position);
    }

    //Toggle selection methods
    public void toggleSelection(int position) {
        selectView(position, !mSelectedItemsIds.get(position));
        Log.i("MyLog", "Toggle Selection");
    }

    //Put or delete selected position into SparseBooleanArray
    public void selectView(int position, boolean value) {
        if (value){
            mSelectedItemsIds.put(position, value);
            Log.i("MyLog", "Put selected item");
            notifyItemChanged(position);
        } else {
            mSelectedItemsIds.delete(position);
            Log.i("MyLog", "Remove selected item");
            notifyItemChanged(position);
        }
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

package com.example.ninebit.linguamea.adapter.recyclerview;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ninebit.linguamea.R;
import com.example.ninebit.linguamea.interfaces.ClickListener;
import com.example.ninebit.linguamea.model.CustomDictionaryModel;

import java.util.List;

/**
 * Created by NineB on 4/16/2017.
 */

public class CustomDictionaryAdapter extends BaseAbstractAdapter<CustomDictionaryModel,CustomDictionaryAdapter.ViewHolder> {

    public CustomDictionaryAdapter(List<CustomDictionaryModel> mListItems, Context mContext, ClickListener clickListener) {
        super(mListItems, mContext, clickListener);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(view, clickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final CustomDictionaryModel itemList = mListItems.get(position);
        holder.mUUID.setText(itemList.getUUID().toString());
        holder.mWord.setText(itemList.getWord());
        holder.mTranslation.setText(itemList.getTranslation());

        holder.mWord
                .setTextColor(mSelectedItems.get(position) ? mContext.getResources().getColor(R.color.selected_item_color)
                        : Color.BLACK);
        holder.mTranslation
                .setTextColor(mSelectedItems.get(position) ? mContext.getResources().getColor(R.color.selected_item_color)
                        : mContext.getResources().getColor(R.color.translation_color));
        holder.mUUID
                    .setTextColor(mSelectedItems.get(position) ? mContext.getResources().getColor(R.color.selected_item_color)
                            : mContext.getResources().getColor(R.color.translation_color));



        if (itemList.getLearned() == true){
            holder.mCardView.setBackgroundColor(mContext.getResources().getColor(R.color.learned_color_main));
        }else{
            holder.mCardView.setBackgroundColor(Color.WHITE);
        }

    }

    public static class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {

        public TextView mWord, mTranslation, mUUID;
        public ImageView mOptions;
        public CardView mCardView;

        private ClickListener listener;

        public ViewHolder(View itemView, ClickListener listener) {
            super(itemView);

            this.listener = listener;

            mUUID = (TextView) itemView.findViewById(R.id.item_uuid_text_view);
            mWord = (TextView) itemView.findViewById(R.id.item_word_text_view);
            mTranslation = (TextView) itemView.findViewById(R.id.item_translation_text_view);
            mOptions = (ImageView) itemView.findViewById(R.id.item_options_menu);
            mCardView = (CardView) itemView.findViewById(R.id.item_card_view);

            mCardView.setOnClickListener(this);
            mCardView.setOnLongClickListener(this);
            mOptions.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.item_options_menu:
                    if (listener != null) {
                        listener.onOptionsClicked(v, getAdapterPosition ());
                    }
                    break;
                case R.id.item_card_view:
                    if (listener != null) {
                        listener.onItemClicked(v, getAdapterPosition ());
                    }
                    break;
            }
        }

        @Override
        public boolean onLongClick(View v) {
            if (listener != null) {
                return listener.onItemLongClicked(v, getAdapterPosition ());
            }
            return true;
        }
    }
}


package com.example.ninebit.linguamea.adapter.recyclerview;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ninebit.linguamea.R;
import com.example.ninebit.linguamea.interfaces.ClickListener;
import com.example.ninebit.linguamea.model.MainDictionaryModel;

import java.util.List;

/**
 * Created by NineB on 4/18/2017.
 */

public class MainDictionaryAdapter extends BaseAbstractAdapter <MainDictionaryModel, MainDictionaryAdapter.ViewHolder> {

    private String LOGTAG = "MDAdapter";

    public MainDictionaryAdapter(List<MainDictionaryModel> mListItems, Context mContext, ClickListener clickListener) {
        super(mListItems, mContext, clickListener);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_dictionary_recycler_view_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(view, clickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final MainDictionaryModel itemList = mListItems.get(position);
        holder.mWord.setText(itemList.getWord());
//        holder.mForms.setText(itemList.getFormUUID().toString());
//        holder.mTranslation.setText(itemList.getTranslationUUID().toString());

    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        private TextView mWord, mTranslation, mForms;
        private ImageView mOptions, mFavorite;
        private CardView mCardView;

        private ClickListener listener;

        public ViewHolder(View itemView, ClickListener clickListener) {
            super(itemView);
            this.listener = listener;

            mWord = (TextView) itemView.findViewById(R.id.item_md_word_text_view);
            mTranslation = (TextView) itemView.findViewById(R.id.item_md_translation_text_view);
            mForms = (TextView) itemView.findViewById(R.id.item_md_forms_text_view);

            mOptions = (ImageView) itemView.findViewById(R.id.item_md_options_menu);
            mFavorite = (ImageView) itemView.findViewById(R.id.item_md_favorite);

            mCardView = (CardView) itemView.findViewById(R.id.item_md_card_view);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.item_md_options_menu:
                    if (listener != null) {
                        Log.i(LOGTAG,"onOptionsClick");
                    }
                    break;
                case R.id.item_md_card_view:
                    if (listener != null) {
                        Log.i(LOGTAG,"onClick");
                    }
                    break;
            }
        }

        @Override
        public boolean onLongClick(View v) {
            Log.i(LOGTAG,"onLongClick");
            return true;
        }


    }
}

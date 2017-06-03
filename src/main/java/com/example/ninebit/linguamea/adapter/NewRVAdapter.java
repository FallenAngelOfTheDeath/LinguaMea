//package com.example.ninebit.linguamea.adapter;
//
//
//
//import android.content.Context;
//import android.support.v7.widget.CardView;
//import android.support.v7.widget.RecyclerView;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.example.ninebit.linguamea.R;
//import com.example.ninebit.linguamea.adapter.base.BaseRVAdapter;
//import com.example.ninebit.linguamea.model.MyModel;
//
//import java.util.List;
//
///**
// * Created by NineB on 4/16/2017.
// */
//
//public  class NewRVAdapter extends BaseRVAdapter<MyModel, NewRVAdapter.VHolder> {
//
//    private VHolder.ClickListener clickListener;
//
//    public NewRVAdapter(List<MyModel> mItems, Context mContext, VHolder.ClickListener clickListener) {
//        super(mItems, mContext);
//        this.clickListener = clickListener;
//    }
//
//    @Override
//    protected void bindItemData(NewRVAdapter.VHolder viewHolder, MyModel data, int position) {
//        viewHolder.mWord.setText(data.getWord());
//        viewHolder.mTranslation.setText(data.getTranslation());
//        viewHolder.mUUID.setText(data.getUUID().toString());
//    }
//
//    @Override
//    public NewRVAdapter.VHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        return null;
//    }
//
//    public static class VHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
//
//        private TextView mWord, mTranslation, mUUID;
//        private ImageView mOptions;
//        private CardView mCardView;
//        private ClickListener listener;
//
//        public VHolder(View itemView) {
//            super(itemView);
//
//            mUUID = (TextView) itemView.findViewById(R.id.item_uuid_text_view);
//            mWord = (TextView) itemView.findViewById(R.id.item_word_text_view);
//            mTranslation = (TextView) itemView.findViewById(R.id.item_translation_text_view);
//            mOptions = (ImageView) itemView.findViewById(R.id.item_options_menu);
//            mCardView = (CardView) itemView.findViewById(R.id.item_card_view);
//
//            mOptions.setOnClickListener(this);
//
//            itemView.setOnClickListener(this);
//            itemView.setOnLongClickListener (this);
//        }
//
//        @Override
//        public void onClick(View v) {
//            if (listener != null) {
//                listener.onItemClicked(getAdapterPosition ());
//            }
//        }
//
//        @Override
//        public boolean onLongClick(View v) {
//            if (listener != null) {
//                return listener.onItemLongClicked(getAdapterPosition ());
//            }
//            return false;
//        }
//
//        public interface ClickListener {
//            public void onItemClicked(int position);
//            public boolean onItemLongClicked(int position);
//        }
//    }
//}

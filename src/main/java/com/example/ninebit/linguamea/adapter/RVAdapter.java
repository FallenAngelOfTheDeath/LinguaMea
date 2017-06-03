//package com.example.ninebit.linguamea.adapter;
//
//import android.content.Context;
//import android.content.Intent;
//import android.graphics.Color;
//import android.support.v7.widget.CardView;
//import android.support.v7.widget.PopupMenu;
//import android.support.v7.widget.RecyclerView;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.MenuItem;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.example.ninebit.linguamea.R;
//import com.example.ninebit.linguamea.activity.EditorActivity;
//import com.example.ninebit.linguamea.fragment.dictionaries.MainDictionaryFragment;
//import com.example.ninebit.linguamea.model.MyModel;
//import com.example.ninebit.linguamea.model.Singleton;
//
//import java.util.List;
//
//public class RVAdapter extends BaseRecyclerAdapter<MyModel, RVAdapter.DHolder> {
//
//    private MainDictionaryFragment mMainDictionaryFragment;
//
//    public RVAdapter(List<MyModel> mItems, Context mContext) {
//        super(mItems, mContext);
//    }
//
//    @Override
//    protected void bindItemData(final DHolder viewHolder, MyModel item, final int position) {
//        final MyModel itemList = mItems.get(position);
//
//        viewHolder.mWord.setText(item.getWord());
//        viewHolder.mTranslation.setText(item.getTranslation());
//        viewHolder.mUUID.setText(item.getUUID().toString());
//
//        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getMoreInformation(position);
//            }
//        });
//        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//
//
//                mMainDictionaryFragment.startActioMode();
//
//                Log.i("MyLog", "item view onLongClick");
//                return true;
//            }
//        });
//        viewHolder.mOptions.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                popupMenu(viewHolder, position);
//            }
//        });
//
//        viewHolder.mWord
//                .setTextColor(mSelectedItemsIds.get(position) ? mContext.getResources().getColor(R.color.selected_item_color)
//                        : Color.BLACK);
//
//        if (itemList.getLearned() == true){
//            viewHolder.mCardView.setBackgroundColor(mContext.getResources().getColor(R.color.learned_color_main));
//        }else{
//            viewHolder.mCardView.setBackgroundColor(Color.WHITE);
//        }
//    }
//
//    public void popupMenu (RVAdapter.DHolder holder, final int position){
//        final MyModel itemList = mItems.get(position);
//        final PopupMenu popupMenu = new PopupMenu(mContext, holder.mOptions);
//        popupMenu.inflate(R.menu.item_popup_menu);
//        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                switch (item.getItemId()){
//                    case R.id.popup_menu_learned:
//                        String learnedStatus = itemList.getLearned().toString();
//                        switch (learnedStatus){
//                            case "true":
//                                Log.i("MyLog", "learned status: " + learnedStatus  + " changed to false");
//                                learnedStatus(itemList, false, position);
//                                break;
//                            case "false":
//                                Log.i("MyLog", "learned status: " + learnedStatus + " changed to true");
//                                learnedStatus(itemList, true, position);
//                                break;
//                        }
//                        Toast.makeText(mContext, "I know this", Toast.LENGTH_LONG).show();
//                        break;
//                    case R.id.popup_menu_edit:
//                        Intent intent = EditorActivity.newIntent(mContext, itemList.getUUID(), true);
//                        mContext.startActivity(intent);
//                        Log.i("LogIdFromIntent", "extra (linID put Extra): ");
//                        break;
//                    case R.id.popup_menu_delete:
//                        deleteItem(position);
//                        Singleton.getInstance(mContext).deleteWord(itemList);
//                        Toast.makeText(mContext, R.string.word_deleted, Toast.LENGTH_LONG).show();
//                        break;
//                    case R.id.popup_menu_move_to:
//                        Toast.makeText(mContext, "I move this", Toast.LENGTH_LONG).show();
//                        break;
//                    case R.id.popup_menu_share:
//                        Toast.makeText(mContext, "I share this", Toast.LENGTH_LONG).show();
//                        break;
//                    case R.id.popup_menu_more_info_about_this:
//                        getMoreInformation(position);
//                        break;
//
//                }
//                return false;
//            }
//        });
//        popupMenu.show();
//    }
//
//    public void getMoreInformation(int position){
//        final MyModel itemList = mItems.get(position);
//        Intent intent = EditorActivity.newIntent(mContext, itemList.getUUID(), false);
//        mContext.startActivity(intent);
//        Log.i("LogIdFromIntent", "extra (linID put Extra): " + itemList.getUUID().toString());
//    }
//
//    @Override
//    public DHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View contentView = LayoutInflater.from(mContext).inflate(R.layout.item_recycler_view, parent, false);
//        DHolder viewholder = new DHolder(contentView);
//        return viewholder;
//    }
//
//    public class DHolder extends RecyclerView.ViewHolder {
//
//        public TextView mWord, mTranslation, mUUID;
//        public ImageView mOptions;
//        public CardView mCardView;
//
//        public DHolder(View itemView) {
//            super(itemView);
//            mUUID = (TextView) itemView.findViewById(R.id.item_uuid_text_view);
//            mWord = (TextView) itemView.findViewById(R.id.item_word_text_view);
//            mTranslation = (TextView) itemView.findViewById(R.id.item_translation_text_view);
//            mOptions = (ImageView) itemView.findViewById(R.id.item_options_menu);
//            mCardView = (CardView) itemView.findViewById(R.id.item_card_view);
//        }
//    }
//}

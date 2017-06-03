package com.example.ninebit.linguamea.fragment;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ninebit.linguamea.R;
import com.example.ninebit.linguamea.activity.EditorActivity;
import com.example.ninebit.linguamea.model.CustomDictionaryModel;
import com.example.ninebit.linguamea.model.Singleton;

import java.util.UUID;

public class EditorFragment extends Fragment {

    private EditText mWordField, mTranslationField;
    private TextView mIdTextView;
    private CustomDictionaryModel mModel;
    private CheckBox mLearnedCheckBox;
    private String LOGTAG = "EditorFragment";

    public EditorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.editor, container, false);

        mWordField = (EditText) view.findViewById(R.id.word_edit_text);
        mTranslationField = (EditText) view.findViewById(R.id.translation_edit_text);
        mIdTextView = (TextView) view.findViewById(R.id.item_uuid_text_view);
        mLearnedCheckBox = (CheckBox) view.findViewById(R.id.learned_check_box);

        setHasOptionsMenu(true);

        idFromIntent();

        return view;
    }


    private void idFromIntent () {

        UUID linmeaId = (UUID) getActivity().getIntent().getSerializableExtra(EditorActivity.EXTRA_LINMEA_ID);
        if (linmeaId == null){
            Log.i(LOGTAG, "New word");
        }else{
            mModel = Singleton.getInstance(getActivity()).getWord(linmeaId);
            setEditor();
            Boolean editorModID = (Boolean) getActivity().getIntent().getSerializableExtra(EditorActivity.EXTRA_EDITOR_ID);
            if (editorModID == false){
                mWordField.setEnabled(false);
                mWordField.setTextColor(getActivity().getResources().getColor(R.color.text_color_main));
                mWordField.getBackground().mutate().setColorFilter(getActivity().getResources().getColor(R.color.colorPrimaryDark), PorterDuff.Mode.SRC_ATOP);
                mTranslationField.setEnabled(false);
                mTranslationField.setTextColor(getActivity().getResources().getColor(R.color.text_color_main));
            }
        }

    }

    private void setEditor(){
        mWordField.setText(mModel.getWord());
        mTranslationField.setText(mModel.getTranslation());
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_editor, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_editor_done:
                UUID linmeaId = (UUID) getActivity().getIntent().getSerializableExtra(EditorActivity.EXTRA_LINMEA_ID);
                if (linmeaId == null){
                    Log.i(LOGTAG, "options / new word");
                    mModel = new CustomDictionaryModel();
                    //saveWord();
                    if (mWordField .getText().length() == 0){
                        Toast.makeText(getActivity(), R.string.empty_word_field, Toast.LENGTH_SHORT).show();
                        Log.i(LOGTAG, "word field is empty");
                    } else {
                        setWord();
                        Log.i(LOGTAG, "method setWord");
                        Singleton.getInstance(getActivity()).saveWord(mModel);
                        getActivity().finish();
                    }
                }else{
                    Log.i(LOGTAG, "options / word editor");
                    //saveWord();
                    if (mWordField .getText().length() == 0){
                        Toast.makeText(getActivity(), R.string.empty_word_field, Toast.LENGTH_SHORT).show();
                        Log.i(LOGTAG, "word field is empty");
                    } else {
                        setWord();
                        Log.i(LOGTAG, "method setWord");
                        Singleton.getInstance(getActivity()).updateWord(mModel);
                        getActivity().finish();
                    }
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

//    private void saveWord(){
//        if (mWordField .getText().length() == 0){
//            Toast.makeText(getActivity(), R.string.empty_word_field, Toast.LENGTH_SHORT).show();
//            Log.i(LOGTAG, "word field is empty");
//        } else {
//            setWord();
//            Log.i(LOGTAG, "method setWord");
//            getActivity().finish();
//        }
//    }

    private void setWord(){
        mModel.setWord(mWordField.getText().toString());
        mModel.setTranslation(mTranslationField.getText().toString());
        if(mLearnedCheckBox.isChecked()){
            mModel.setLearned(true);
        }else {
            mModel.setLearned(false);
        }
        Log.i("MyLog", "______________________________________________________________________________________________ " );
        Log.i("MyLog", "Check a word: " + mModel.getWord().toString());
        Log.i("MyLog", "Check a translation: " + mModel.getTranslation().toString());
        Log.i("MyLog", "Check a uuid: " + mModel.getUUID().toString());
        Log.i("MyLog", "Check a learned: " + mModel.getLearned().toString());
        Log.i("MyLog", "______________________________________________________________________________________________ " );
        Toast.makeText(getActivity(), R.string.word_saved, Toast.LENGTH_SHORT).show();
    }


}

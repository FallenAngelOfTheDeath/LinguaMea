package com.example.ninebit.linguamea.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ninebit.linguamea.R;
import com.example.ninebit.linguamea.model.CustomDictionaryModel;
import com.example.ninebit.linguamea.model.Singleton;

import java.util.UUID;

public class Editor extends AppCompatActivity {

    private EditText mWordField, mTranslationField;
    private TextView mIdField;
    private CustomDictionaryModel mModel;
    private CheckBox mLearnedCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editor);
        mWordField = (EditText) findViewById(R.id.word_edit_text);
        mTranslationField = (EditText) findViewById(R.id.translation_edit_text);
        mIdField = (TextView) findViewById(R.id.item_uuid_text_view);
        mLearnedCheckBox = (CheckBox) findViewById(R.id.learned_check_box);

        GUI();
        idFromIntent();
    }

    private void idFromIntent () {

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            UUID linmeaId = (UUID) UUID.fromString(extras.getString("id"));
            Log.i("LogIdFromIntent", "extras: " + extras);
            Log.i("LogIdFromIntent", "Lin: " + linmeaId);
        }else{
            Log.i("LogIdFromIntent", "extras id null, add mod");
        }
    }

    private void setEditor(){
       // mIdField.setText(mModel.getUUID().toString());
        mWordField.setText(mModel.getWord());
        mTranslationField.setText(mModel.getTranslation());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_editor_done:
                mModel = new CustomDictionaryModel();
                saveWord();
                Singleton.getInstance(this).saveWord(mModel);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void saveWord(){
        if (mWordField .getText().length() == 0){
            Toast.makeText(this, R.string.empty_word_field, Toast.LENGTH_SHORT).show();
        } else {
                setWord();
        }
    }

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
        Log.i("MyLog", "Check a id: " + mModel.getUUID().toString());
        Log.i("MyLog", "Check a id: " + mModel.getLearned().toString());
        Log.i("MyLog", "______________________________________________________________________________________________ " );
        Toast.makeText(this, R.string.word_saved, Toast.LENGTH_SHORT).show();
    }

     public void GUI (){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }


}

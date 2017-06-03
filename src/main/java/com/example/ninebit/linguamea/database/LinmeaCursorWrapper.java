package com.example.ninebit.linguamea.database;

import android.database.Cursor;
import android.database.CursorWrapper;
import android.util.Log;

import com.example.ninebit.linguamea.database.schemes.CustomDictionaryDBSchema.CustomDictionaryTable;
import com.example.ninebit.linguamea.database.schemes.MainDictionaryDBScheme.FormTable;
import com.example.ninebit.linguamea.database.schemes.MainDictionaryDBScheme.MainDictionaryTable;
import com.example.ninebit.linguamea.database.schemes.MainDictionaryDBScheme.WordTable;
import com.example.ninebit.linguamea.model.CustomDictionaryModel;
import com.example.ninebit.linguamea.model.DictionaryModel;
import com.example.ninebit.linguamea.model.MainDictionaryModel;

import java.util.UUID;



public class LinmeaCursorWrapper extends CursorWrapper{

    private String LOGTAG = "LinmeaCursorWrapper";

    public LinmeaCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public CustomDictionaryModel getWord() {
        String uuidString = getString(getColumnIndex(CustomDictionaryTable.Columns.UUID));
        String mWord = getString(getColumnIndex(CustomDictionaryTable.Columns.WORD));
        String mTranslation = getString(getColumnIndex(CustomDictionaryTable.Columns.TRANSLATION));
        String mDescription = getString(getColumnIndex(CustomDictionaryTable.Columns.DESCRIPTION));
        int mLearned = getInt(getColumnIndex(CustomDictionaryTable.Columns.LEARNED));
        int mFavorite = getInt(getColumnIndex(CustomDictionaryTable.Columns.FAVORITE));

        CustomDictionaryModel word = new CustomDictionaryModel(UUID.fromString(uuidString));
        word.setWord(mWord);
        word.setTranslation(mTranslation);
        word.setDescription(mDescription);
        word.setLearned(mLearned != 0);
        word.setFavorite(mFavorite != 0);
        return word;
    }

    public MainDictionaryModel getMainWord() {
        String uuidString = getString(getColumnIndex(MainDictionaryTable.Columns.UUID));
        String mWord = getString(getColumnIndex(MainDictionaryTable.Columns.WORD));
//        String mTranslation = getString(getColumnIndex(MainDictionaryTable.Columns.TRANSLATION));
//        String mDescription = getString(getColumnIndex(MainDictionaryTable.Columns.DESCRIPTION));
        int mLearned = getInt(getColumnIndex(MainDictionaryTable.Columns.LEARNED));
        int mFavorite = getInt(getColumnIndex(MainDictionaryTable.Columns.FAVORITE));

        Log.d(LOGTAG, uuidString + " " + mWord);

        MainDictionaryModel word = new MainDictionaryModel(UUID.fromString(uuidString));
        word.setWord(mWord);
//        //word.setTranslationUUID(mTranslation);
//        //word.setDescription(mDescription);
        word.setLearned(mLearned != 0);
        word.setFavorite(mFavorite != 0);
        return word;
    }

    public DictionaryModel getMDictionaryTable(){

        int mId = getInt(getColumnIndex(WordTable.Columns.ID));
        String mWordString = getString(getColumnIndex(WordTable.Columns.NAME));

        int mSynonymIDLink = getInt(getColumnIndex(WordTable.Columns.SYNONYM_ID_LINK));
        int mCategoryIDLink = getInt(getColumnIndex(WordTable.Columns.CATEGORY_ID_LINK));
        int mTranslationIDLink = getInt(getColumnIndex(WordTable.Columns.MAIN_TANSLATION_ID_LINK));
        int mTranscriptionIDLink = getInt(getColumnIndex(WordTable.Columns.MAIN_TANSCRIPTION_ID_LINK));
        int mDescriptionIDLink = getInt(getColumnIndex(WordTable.Columns.MAIN_DESCRIPTION_ID_LINK));

        String mLanguageIDLink = getString(getColumnIndex(WordTable.Columns.LANGUAGE_ID_LINK));

        int mLearned = getInt(getColumnIndex(WordTable.Columns.LEARNED));
        int mFavorite = getInt(getColumnIndex(WordTable.Columns.FAVORITE));


        DictionaryModel word = new DictionaryModel();

        word.setID(mId);
        word.setWordName(mWordString);

        word.setSynonymID(mSynonymIDLink);
        word.setCategoryID(mCategoryIDLink);
        word.setCategoryID(mTranslationIDLink);
        word.setCategoryID(mTranscriptionIDLink);
        word.setCategoryID(mDescriptionIDLink);

        //word.setLanguageID(mLanguageIDLink);

        word.setLearned(mLearned !=0);
        word.setFavorite(mFavorite !=0);

        Log.d(LOGTAG, "------------------------WordTable----------------------");
        Log.d(LOGTAG, "ID: " + mId
                + "    / Word: " + mWordString

                + "    / Synonym: " + mSynonymIDLink
                + "    / Category: " + mCategoryIDLink
                + "    / Translation: " + mTranslationIDLink
                + "    / Transcription: " + mTranscriptionIDLink
                + "    / Description: " + mDescriptionIDLink

                + "    / Language: " + mLanguageIDLink

                + "    / Learned status: " + mLearned
                + "    / Favorite status: " + mFavorite);

        return word;
    }

    public DictionaryModel getFormTable(){
        String mFormNameString = getString(getColumnIndex(FormTable.Columns.FORM_NAME));

        int mFormID = getInt(getColumnIndex(FormTable.Columns.FORM_ID));
        int mWordIDLink = getInt(getColumnIndex(FormTable.Columns.WORD_ID_LINK));
        int mTranslationIDLink = getInt(getColumnIndex(FormTable.Columns.FORM_TRANSLATION_ID_LINK));
        int mTranscriptionIDLink = getInt(getColumnIndex(FormTable.Columns.FORM_TRANSCRIPTION_ID_LINK));
        int mFormDescriptionIDLink = getInt(getColumnIndex(FormTable.Columns.FORM_DESCRIPTION_ID_LINK));
        int mTypeIDLink = getInt(getColumnIndex(FormTable.Columns.TYPE_ID_LINK));

        DictionaryModel word = new DictionaryModel();

        word.setForm(mFormNameString);

        word.setFromID(mFormID);
        word.setWordIDLink(mWordIDLink);
        word.setFormTranscriptionIDLink(mTranscriptionIDLink);
        word.setTypeIDLink(mTypeIDLink);
        word.setFormTranslationIDLink(mTranslationIDLink);
        word.setFormDescriptionIDLink(mFormDescriptionIDLink);

        Log.d(LOGTAG, "------------------------FormTable----------------------");
        Log.d(LOGTAG, "Name of form: " + mFormNameString

                + "    / Transcription id: " + mTranscriptionIDLink
                + "    / Translation id: " + mTranslationIDLink
                + "    / Description id: " + mFormDescriptionIDLink
                + "    / Word id: " + mWordIDLink
                + "    / Type id: " + mTypeIDLink
                + "    / Form type id: " + mFormID);

        return word;
    }

}

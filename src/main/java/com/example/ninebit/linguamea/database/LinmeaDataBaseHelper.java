package com.example.ninebit.linguamea.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ninebit.linguamea.database.schemes.CustomDictionaryDBSchema.CustomDictionaryTable;
import com.example.ninebit.linguamea.database.schemes.MainDictionaryDBScheme.CategoryTable;
import com.example.ninebit.linguamea.database.schemes.MainDictionaryDBScheme.DescriptionTable;
import com.example.ninebit.linguamea.database.schemes.MainDictionaryDBScheme.FormTable;
import com.example.ninebit.linguamea.database.schemes.MainDictionaryDBScheme.MainDictionaryTable;
import com.example.ninebit.linguamea.database.schemes.MainDictionaryDBScheme.TranslationTable;
import com.example.ninebit.linguamea.database.schemes.MainDictionaryDBScheme.TypeTable;

import static com.example.ninebit.linguamea.database.schemes.MainDictionaryDBScheme.FormNameTable;
import static com.example.ninebit.linguamea.database.schemes.MainDictionaryDBScheme.WordTable;

public class LinmeaDataBaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "linmeaDataBase.db";

    public LinmeaDataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + CustomDictionaryTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                CustomDictionaryTable.Columns.UUID + " TEXT, " +
                CustomDictionaryTable.Columns.WORD + " TEXT, " +
                CustomDictionaryTable.Columns.TRANSLATION + " TEXT, " +
                CustomDictionaryTable.Columns.DESCRIPTION + " TEXT, " +
                CustomDictionaryTable.Columns.FAVORITE +  " INTEGER, " +
                CustomDictionaryTable.Columns.LEARNED +  " INTEGER)" );

        InputData.toCustomDictionary(db);



        db.execSQL("create table " + WordTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                WordTable.Columns.ID + " INTEGER, " +
                WordTable.Columns.NAME + " TEXT, " +

                WordTable.Columns.SYNONYM_ID_LINK + " INTEGER, " +
                WordTable.Columns.CATEGORY_ID_LINK + " INTEGER, " +
                WordTable.Columns.MAIN_TANSLATION_ID_LINK + " INTEGER, " +
                WordTable.Columns.MAIN_TANSCRIPTION_ID_LINK + " INTEGER, " +
                WordTable.Columns.MAIN_DESCRIPTION_ID_LINK + " INTEGER, " +

                WordTable.Columns.LANGUAGE_ID_LINK + " TEXT, " +

                WordTable.Columns.FAVORITE + " INTEGER, " +
                WordTable.Columns.LEARNED +  " INTEGER)" );

        db.execSQL("create table " + FormTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                FormTable.Columns.FORM_NAME + " TEXT, " +

                FormTable.Columns.FORM_ID + " TEXT, " +
                FormTable.Columns.WORD_ID_LINK + " INTEGER, " +
                FormTable.Columns.FORM_TRANSLATION_ID_LINK + " INTEGER, " +
                FormTable.Columns.FORM_TRANSCRIPTION_ID_LINK + " INTEGER, " +
                FormTable.Columns.FORM_DESCRIPTION_ID_LINK + " INTEGER, " +
                FormTable.Columns.TYPE_ID_LINK + " INTEGER) " );

        db.execSQL("create table " + TypeTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                TypeTable.Columns.ID + " INTEGER, " +
                TypeTable.Columns.NAME +  " TEXT)" );

        db.execSQL("create table " + FormNameTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                FormNameTable.Columns.ID + " INTEGER, " +
                FormNameTable.Columns.NAME +  " TEXT)" );

        db.execSQL("create table " + TranslationTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                TranslationTable.Columns.ID + " INTEGER, " +
                TranslationTable.Columns.NAME +  " TEXT)" );

        db.execSQL("create table " + DescriptionTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                DescriptionTable.Columns.ID + " INTEGER, " +
                DescriptionTable.Columns.NAME +  " TEXT)" );

        db.execSQL("create table " + CategoryTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                CategoryTable.Columns.ID + " INTEGER, " +
                CategoryTable.Columns.NAME +  " TEXT)" );

        InputData.toMDictionary(db);








        db.execSQL("create table " + MainDictionaryTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                MainDictionaryTable.Columns.UUID + " TEXT, " +
                MainDictionaryTable.Columns.TRANSLATION_UUID + " TEXT, " +
                MainDictionaryTable.Columns.TYPE_UUID + " TEXT, " +
                MainDictionaryTable.Columns.SYNONYM_UUID + " TEXT, " +
                MainDictionaryTable.Columns.FORM_UUID + " TEXT, " +
                MainDictionaryTable.Columns.CATEGORY_UUID + " TEXT, " +
                MainDictionaryTable.Columns.DESCRIPTION_UUID + " TEXT, " +
                MainDictionaryTable.Columns.LANGUAGE_UUID + " TEXT, " +

                MainDictionaryTable.Columns._TYPE_ID + " integer, " +
                MainDictionaryTable.Columns._TRANSLATION_ID + " integer, " +

                MainDictionaryTable.Columns.WORD + " TEXT, " +
                MainDictionaryTable.Columns.TRANSCRIPTION + " TEXT, " +
                MainDictionaryTable.Columns.FAVORITE + " INTEGER, " +
                MainDictionaryTable.Columns.LEARNED +  " INTEGER)" );

        InputData.toMainDictionary(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

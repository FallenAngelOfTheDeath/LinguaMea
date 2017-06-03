package com.example.ninebit.linguamea.database;

import android.database.sqlite.SQLiteDatabase;

import com.example.ninebit.linguamea.database.schemes.MainDictionaryDBScheme.CategoryTable;
import com.example.ninebit.linguamea.database.schemes.MainDictionaryDBScheme.DescriptionTable;
import com.example.ninebit.linguamea.database.schemes.MainDictionaryDBScheme.FormNameTable;
import com.example.ninebit.linguamea.database.schemes.MainDictionaryDBScheme.WordTable;

import static com.example.ninebit.linguamea.database.schemes.CustomDictionaryDBSchema.CustomDictionaryTable;
import static com.example.ninebit.linguamea.database.schemes.MainDictionaryDBScheme.FormTable;
import static com.example.ninebit.linguamea.database.schemes.MainDictionaryDBScheme.MainDictionaryTable;
import static com.example.ninebit.linguamea.database.schemes.MainDictionaryDBScheme.TranslationTable;
import static com.example.ninebit.linguamea.database.schemes.MainDictionaryDBScheme.TypeTable;

/**
 * Created by NineB on 4/4/2017.
 */

public class InputData {

    public static void toCustomDictionary (SQLiteDatabase db){
        db.execSQL("INSERT INTO " + CustomDictionaryTable.NAME +" ("
                + CustomDictionaryTable.Columns.UUID + ", "
                + CustomDictionaryTable.Columns.WORD + ", "
                + CustomDictionaryTable.Columns.TRANSLATION  + ", "
                + CustomDictionaryTable.Columns.DESCRIPTION  + ", "
                + CustomDictionaryTable.Columns.FAVORITE  + ", "
                + CustomDictionaryTable.Columns.LEARNED  +
                ") VALUES ('9f837674-0787-4aa4-a003-4611bffa68be', 'Apple', 'Яблоко', 'This is apple', 1, 1);");

        db.execSQL("INSERT INTO "+ CustomDictionaryTable.NAME +" ("
                + CustomDictionaryTable.Columns.UUID + ", "
                + CustomDictionaryTable.Columns.WORD + ", "
                + CustomDictionaryTable.Columns.TRANSLATION  + ", "
                + CustomDictionaryTable.Columns.DESCRIPTION  + ", "
                + CustomDictionaryTable.Columns.FAVORITE  + ", "
                + CustomDictionaryTable.Columns.LEARNED  +
                ") VALUES ('8f837674-0787-4aa4-a003-4611bffa68be', 'Run', 'Бежать', ' ', 0, 1);");

        db.execSQL("INSERT INTO " + CustomDictionaryTable.NAME + " ("
                + CustomDictionaryTable.Columns.UUID + ", "
                + CustomDictionaryTable.Columns.WORD + ", "
                + CustomDictionaryTable.Columns.TRANSLATION + ", "
                + CustomDictionaryTable.Columns.DESCRIPTION  + ", "
                + CustomDictionaryTable.Columns.FAVORITE  + ", "
                + CustomDictionaryTable.Columns.LEARNED  +
                ") VALUES ('7f837674-0787-4aa4-a003-4611bffa68be', 'Blue', 'Синий', ' ', 0, 1);");

        db.execSQL("INSERT INTO " + CustomDictionaryTable.NAME + " ("
                + CustomDictionaryTable.Columns.UUID + ", "
                + CustomDictionaryTable.Columns.WORD + ", "
                + CustomDictionaryTable.Columns.TRANSLATION + ", "
                + CustomDictionaryTable.Columns.DESCRIPTION  + ", "
                + CustomDictionaryTable.Columns.FAVORITE  + ", "
                + CustomDictionaryTable.Columns.LEARNED  +
                ") VALUES ('6f837674-0787-4aa4-a003-4611bffa68be', 'Hate', 'Ненавидеть', ' ', 0, 1);");

        db.execSQL("INSERT INTO " + CustomDictionaryTable.NAME + " ("
                + CustomDictionaryTable.Columns.UUID + ", "
                + CustomDictionaryTable.Columns.WORD + ", "
                + CustomDictionaryTable.Columns.TRANSLATION + ", "
                + CustomDictionaryTable.Columns.DESCRIPTION  + ", "
                + CustomDictionaryTable.Columns.FAVORITE  + ", "
                + CustomDictionaryTable.Columns.LEARNED  +
                ") VALUES ('5f837674-0787-4aa4-a003-4611bffa68be', 'Rather', 'Скорее', ' ', 0, 0);");

        db.execSQL("INSERT INTO " + CustomDictionaryTable.NAME + " ("
                + CustomDictionaryTable.Columns.UUID + ", "
                + CustomDictionaryTable.Columns.WORD + ", "
                + CustomDictionaryTable.Columns.TRANSLATION + ", "
                + CustomDictionaryTable.Columns.DESCRIPTION  + ", "
                + CustomDictionaryTable.Columns.FAVORITE  + ", "
                + CustomDictionaryTable.Columns.LEARNED  +
                ") VALUES ('4f837674-0787-4aa4-a003-4611bffa68be', 'Slightly', 'Немного', ' ', 0, 0);");

        db.execSQL("INSERT INTO " + CustomDictionaryTable.NAME + " ("
                + CustomDictionaryTable.Columns.UUID + ", "
                + CustomDictionaryTable.Columns.WORD + ", "
                + CustomDictionaryTable.Columns.TRANSLATION + ", "
                + CustomDictionaryTable.Columns.DESCRIPTION  + ", "
                + CustomDictionaryTable.Columns.FAVORITE  + ", "
                + CustomDictionaryTable.Columns.LEARNED  +
                ") VALUES ('3f837674-0787-4aa4-a003-4611bffa68be', 'Some', 'Некоторые', ' ', 0, 0);");

        db.execSQL("INSERT INTO " + CustomDictionaryTable.NAME + " ("
                + CustomDictionaryTable.Columns.UUID + ", "
                + CustomDictionaryTable.Columns.WORD + ", "
                + CustomDictionaryTable.Columns.TRANSLATION + ", "
                + CustomDictionaryTable.Columns.DESCRIPTION  + ", "
                + CustomDictionaryTable.Columns.FAVORITE  + ", "
                + CustomDictionaryTable.Columns.LEARNED  +
                ") VALUES ('2f837674-0787-4aa4-a003-4611bffa68be', 'Gonna', 'Собираюсь', ' ', 0, 1);");

        db.execSQL("INSERT INTO " + CustomDictionaryTable.NAME + " ("
                + CustomDictionaryTable.Columns.UUID + ", "
                + CustomDictionaryTable.Columns.WORD + ", "
                + CustomDictionaryTable.Columns.TRANSLATION + ", "
                + CustomDictionaryTable.Columns.DESCRIPTION  + ", "
                + CustomDictionaryTable.Columns.FAVORITE  + ", "
                + CustomDictionaryTable.Columns.LEARNED  +
                ") VALUES ('1f837674-0787-4aa4-a003-4611bffa68be', 'Unite', 'Объединять', ' ', 0, 0);");

        db.execSQL("INSERT INTO " + CustomDictionaryTable.NAME + " ("
                + CustomDictionaryTable.Columns.UUID + ", "
                + CustomDictionaryTable.Columns.WORD + ", "
                + CustomDictionaryTable.Columns.TRANSLATION + ", "
                + CustomDictionaryTable.Columns.DESCRIPTION  + ", "
                + CustomDictionaryTable.Columns.FAVORITE  + ", "
                + CustomDictionaryTable.Columns.LEARNED  +
                ") VALUES ('0f837674-0787-4aa4-a003-4611bffa68be', 'Mean', 'Имею в виду', ' ', 0, 1);");
    }

//    public static void toOIDictionary (SQLiteDatabase db){
//        //for (int i= 0; i>10; i++){
//            db.execSQL("INSERT INTO " + OIDictionaryTable.NAME + " ("
//                    + OIDictionaryTable.Columns.UUID + ", " + OIDictionaryTable.Columns.WORD + ", " + OIDictionaryTable.Columns.TRANSLATION + ", " + OIDictionaryTable.Columns.LEARNED  +
//                    ") VALUES ('0f837674-0781-4aa4-a003-4611bffa68be', 'bjblb', 'bnvnbff', 1);");
//            db.execSQL("INSERT INTO " + OIDictionaryTable.NAME + " ("
//                    + OIDictionaryTable.Columns.UUID + ", " + OIDictionaryTable.Columns.WORD + ", " + OIDictionaryTable.Columns.TRANSLATION + ", " + OIDictionaryTable.Columns.LEARNED  +
//                    ") VALUES ('0f837674-0787-4aa4-a003-4611bmfa68be', 'fghgfhg', 'fghxfgx', 0);");
//       // }
//    }

    public static void toMainDictionary (SQLiteDatabase db){
        db.execSQL("INSERT INTO " + MainDictionaryTable.NAME + " ("
                + MainDictionaryTable.Columns.UUID + ", "
                + MainDictionaryTable.Columns.WORD + ", "
                + MainDictionaryTable.Columns.TRANSCRIPTION + ", "
                + MainDictionaryTable.Columns.LEARNED + ", "
                + MainDictionaryTable.Columns.FAVORITE + ", "
                + MainDictionaryTable.Columns.TYPE_UUID + ", "
                + MainDictionaryTable.Columns.TRANSLATION_UUID + ", "
                + MainDictionaryTable.Columns._TYPE_ID + ", "
                + MainDictionaryTable.Columns._TRANSLATION_ID + ", "
                + MainDictionaryTable.Columns.FORM_UUID + ", "
                + MainDictionaryTable.Columns.SYNONYM_UUID + ", "
                + MainDictionaryTable.Columns.CATEGORY_UUID + ", "
                + MainDictionaryTable.Columns.LANGUAGE_UUID + ", "
                + MainDictionaryTable.Columns.DESCRIPTION_UUID

                + ") VALUES ('0f837674-0787-4aa4-a003-4611bffa68be', 'AMean', 'TRANSCRIPTION', 1, 0, '001', '0002', 001, 0002, '003', '0241', '2445', '00001', '40452');");

        db.execSQL("INSERT INTO " + MainDictionaryTable.NAME + " ("
                + MainDictionaryTable.Columns.UUID + ", "
                + MainDictionaryTable.Columns.WORD + ", "
                + MainDictionaryTable.Columns.TRANSCRIPTION + ", "
                + MainDictionaryTable.Columns.LEARNED + ", "
                + MainDictionaryTable.Columns.FAVORITE + ", "
                + MainDictionaryTable.Columns.TYPE_UUID + ", "
                + MainDictionaryTable.Columns.TRANSLATION_UUID + ", "
                + MainDictionaryTable.Columns._TYPE_ID + ", "
                + MainDictionaryTable.Columns._TRANSLATION_ID + ", "
                + MainDictionaryTable.Columns.FORM_UUID + ", "
                + MainDictionaryTable.Columns.SYNONYM_UUID + ", "
                + MainDictionaryTable.Columns.CATEGORY_UUID + ", "
                + MainDictionaryTable.Columns.LANGUAGE_UUID + ", "
                + MainDictionaryTable.Columns.DESCRIPTION_UUID

                + ") VALUES ('0f837674-0787-4aa4-a003-4611bffa68be', 'CMean', 'TRANSCRIPTION', 1, 0, '001', '0002', 001, 0002, '003', '0241', '2445', '00001', '40452');");

        db.execSQL("INSERT INTO " + MainDictionaryTable.NAME + " ("
                + MainDictionaryTable.Columns.UUID + ", "
                + MainDictionaryTable.Columns.WORD + ", "
                + MainDictionaryTable.Columns.TRANSCRIPTION + ", "
                + MainDictionaryTable.Columns.LEARNED + ", "
                + MainDictionaryTable.Columns.FAVORITE + ", "
                + MainDictionaryTable.Columns.TYPE_UUID + ", "
                + MainDictionaryTable.Columns.TRANSLATION_UUID + ", "
                + MainDictionaryTable.Columns._TYPE_ID + ", "
                + MainDictionaryTable.Columns._TRANSLATION_ID + ", "
                + MainDictionaryTable.Columns.FORM_UUID + ", "
                + MainDictionaryTable.Columns.SYNONYM_UUID + ", "
                + MainDictionaryTable.Columns.CATEGORY_UUID + ", "
                + MainDictionaryTable.Columns.LANGUAGE_UUID + ", "
                + MainDictionaryTable.Columns.DESCRIPTION_UUID

                + ") VALUES ('0f837674-0787-4aa4-a003-4611bffa68be', 'BMean', 'TRANSCRIPTION', 1, 0, '001', '0002', 001, 0002, '003', '0241', '2445', '00001', '40452');");

    }

    public static void toMDictionary (SQLiteDatabase db){
        db.execSQL("INSERT INTO " + WordTable.NAME + " ("
                + WordTable.Columns.ID + ", "
                + WordTable.Columns.NAME + ", "

                + WordTable.Columns.SYNONYM_ID_LINK + ", "
                + WordTable.Columns.CATEGORY_ID_LINK + ", "
                + WordTable.Columns.MAIN_TANSLATION_ID_LINK + ", "
                + WordTable.Columns.MAIN_TANSCRIPTION_ID_LINK + ", "
                + WordTable.Columns.MAIN_DESCRIPTION_ID_LINK + ", "

                + WordTable.Columns.LANGUAGE_ID_LINK + ", "

                + WordTable.Columns.FAVORITE + ", "
                + WordTable.Columns.LEARNED

                + ") VALUES (00000001, 'Fly', 000001, 0, 001, 001, 001, 001, 0, 1);");

        db.execSQL("INSERT INTO " + FormTable.NAME + " ("
                + FormTable.Columns.FORM_NAME + ", "

                + FormTable.Columns.FORM_ID + ", "
                + FormTable.Columns.WORD_ID_LINK + ", "
                + FormTable.Columns.FORM_TRANSLATION_ID_LINK + ", "
                + FormTable.Columns.FORM_TRANSCRIPTION_ID_LINK + ", "
                + FormTable.Columns.FORM_DESCRIPTION_ID_LINK + ", "
                + FormTable.Columns.TYPE_ID_LINK

                + ") VALUES ('Fly', 'flaɪ', 00000001, 00000001, 00000001, 000001, 000001);");

        db.execSQL("INSERT INTO " + TypeTable.NAME + " ("
                + TypeTable.Columns.ID + ", "
                + TypeTable.Columns.NAME
                + ") VALUES ('000001', 'verb');");

        db.execSQL("INSERT INTO " + FormNameTable.NAME + " ("
                + FormNameTable.Columns.ID + ", "
                + FormNameTable.Columns.NAME
                + ") VALUES ('000001', 'infinitive');");

        db.execSQL("INSERT INTO " + TranslationTable.NAME + " ("
                + TranslationTable.Columns.ID + ", "
                + TranslationTable.Columns.NAME
                + ") VALUES ('000001', 'лететь');");

        db.execSQL("INSERT INTO " + DescriptionTable.NAME + " ("
                + DescriptionTable.Columns.ID + ", "
                + DescriptionTable.Columns.NAME
                + ") VALUES ('000001', 'In traditional descriptions of English, the infinitive is the basic dictionary form of a verb when used non-finitely, with or without the particle to. Thus to go is an infinitive, as is go in a sentence like \"I must go there\" (but not in \"I go there\", where it is a finite verb).');");

        db.execSQL("INSERT INTO " + CategoryTable.NAME + " ("
                + CategoryTable.Columns.ID + ", "
                + CategoryTable.Columns.NAME
                + ") VALUES ('000001', 'test');");
    }


}



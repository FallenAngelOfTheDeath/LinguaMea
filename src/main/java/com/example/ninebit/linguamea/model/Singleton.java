package com.example.ninebit.linguamea.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ninebit.linguamea.database.LinmeaCursorWrapper;
import com.example.ninebit.linguamea.database.LinmeaDataBaseHelper;
import com.example.ninebit.linguamea.database.schemes.CustomDictionaryDBSchema.CustomDictionaryTable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Singleton {

    private static Singleton sSingleton;

    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static Singleton getInstance(Context context) {
        if (sSingleton == null){
            sSingleton = new Singleton(context);
        }
        return sSingleton;
    }

    private Singleton(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new LinmeaDataBaseHelper(mContext).getWritableDatabase();
    }



    public List<CustomDictionaryModel> getWordList(){
        List<CustomDictionaryModel> wordList = new ArrayList<CustomDictionaryModel>();
        LinmeaCursorWrapper cursorWrapper = queryWords(null, null);

        try {
           cursorWrapper.moveToFirst();
                while (!cursorWrapper.isAfterLast()) {
                    wordList.add(cursorWrapper.getWord());
                    cursorWrapper.moveToNext();
                }
        }finally {
            cursorWrapper.close();
        }
        return wordList;
    }

    public CustomDictionaryModel getWord(UUID uuid){
        LinmeaCursorWrapper cursor = queryWords( CustomDictionaryTable.Columns.UUID + " = ?", new String[] { uuid.toString() }    );
        try {
            if (cursor.getCount() == 0) {
                return null;
            }
            cursor.moveToFirst();
            return cursor.getWord();
        } finally {
            cursor.close();
        }


    }

    public List<CustomDictionaryModel> getSearchResult (String where, String word){
        List<CustomDictionaryModel> searchWordList = new ArrayList<CustomDictionaryModel>();
        LinmeaCursorWrapper cursor = queryWords( where + " like ?", new String[] {"%" + word.toString() + "%"}    );
        try {
            cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    searchWordList.add(cursor.getWord());
                    cursor.moveToNext();
                }
        }finally {
            cursor.close();
        }
        return searchWordList;
    }

    private LinmeaCursorWrapper queryWords(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query( CustomDictionaryTable.NAME, null, whereClause, whereArgs, null, null, null);
        return new LinmeaCursorWrapper(cursor);
    }

    public void deleteWord(CustomDictionaryModel word) {
        String uuidString = word.getUUID().toString();
        //ContentValues values = getContentValues(word);
        mDatabase.delete(CustomDictionaryTable.NAME, CustomDictionaryTable.Columns.UUID + " = ?", new String[] { uuidString }); }

    public void updateWord(CustomDictionaryModel word) {
        String uuidString = word.getUUID().toString();
        ContentValues values = getContentValues(word);
        mDatabase.update(CustomDictionaryTable.NAME, values, CustomDictionaryTable.Columns.UUID + " = ?", new String[] { uuidString }); }

    public void saveWord(CustomDictionaryModel word) {
        ContentValues values = getContentValues(word);
        mDatabase.insert(CustomDictionaryTable.NAME, null, values);
    }

    private static ContentValues getContentValues(CustomDictionaryModel mModel){
        ContentValues values = new ContentValues();
        values.put(CustomDictionaryTable.Columns.UUID, mModel.getUUID().toString());
        values.put(CustomDictionaryTable.Columns.WORD, mModel.getWord());
        values.put(CustomDictionaryTable.Columns.TRANSLATION, mModel.getTranslation());
        values.put(CustomDictionaryTable.Columns.LEARNED, mModel.getLearned());

        return values;
    }


    //_________________________________________________________MAIN_____________________________________________________    MainDictionaryTable.NAME, null, null, null, null, null, MainDictionaryTable.Columns.WORD

    public List<MainDictionaryModel> getMainItemsList(String table, String[] columns, String whereClause, String[] whereArgs, String groupBy, String having, String orderBy ){
        List<MainDictionaryModel> itemList = new ArrayList<MainDictionaryModel>();
        LinmeaCursorWrapper cursorWrapper = queryDictionaryTable( table, columns, whereClause, whereArgs, groupBy, having, orderBy );

        try {
            cursorWrapper.moveToFirst();
            while (!cursorWrapper.isAfterLast()) {
                itemList.add(cursorWrapper.getMainWord());
                cursorWrapper.moveToNext();
            }
        }finally {
            cursorWrapper.close();
        }
        return itemList;
    }


    private LinmeaCursorWrapper queryDictionaryTable(
            String table, String[] columns, String whereClause, String[] whereArgs, String groupBy, String having, String orderBy ) {
        Cursor cursor = mDatabase.query( table, columns, whereClause, whereArgs, groupBy, having, orderBy );
        return new LinmeaCursorWrapper(cursor);
    }



    //_________________________________________________________MAIN2_____________________________________________________    MainDictionaryTable.NAME, null, null, null, null, null, MainDictionaryTable.Columns.WORD
//    public List<DictionaryModel> getMItemsList(String table, String[] columns, String whereClause, String[] whereArgs, String groupBy, String having, String orderBy ){
//        List<DictionaryModel> itemList = new ArrayList<DictionaryModel>();
//        LinmeaCursorWrapper cursorWrapper = queryTable( table, columns, whereClause, whereArgs, groupBy, having, orderBy );
//
//        try {
//            cursorWrapper.moveToFirst();
//            while (!cursorWrapper.isAfterLast()) {
//                itemList.add(cursorWrapper.getMDictionaryTable());
//
//                cursorWrapper.moveToNext();
//            }
//        }finally {
//            cursorWrapper.close();
//        }
//        return itemList;
//    }
//
//
//
//    public List<DictionaryModel> getFormItemsList(String table, String[] columns, String whereClause, String[] whereArgs, String groupBy, String having, String orderBy ){
//        List<DictionaryModel> itemList = new ArrayList<DictionaryModel>();
//        LinmeaCursorWrapper cursorWrapper = queryTable( table, columns, whereClause, whereArgs, groupBy, having, orderBy );
//
//        try {
//            cursorWrapper.moveToFirst();
//            while (!cursorWrapper.isAfterLast()) {
//                itemList.add(cursorWrapper.getFormTable());
//
//                cursorWrapper.moveToNext();
//            }
//        }finally {
//            cursorWrapper.close();
//        }
//        return itemList;
//    }
//
//    public List<DictionaryModel> getDict(){
//        List<DictionaryModel> dict = new ArrayList<DictionaryModel>();
//        String table = "people as PL inner join position as PS on PL.posid = PS.id";
//
//        LinmeaCursorWrapper cursorWrapper = queryTable( MainDictionaryDBScheme.WordTable.NAME + "" + MainDictionaryDBScheme.FormTable.NAME, columns, whereClause, whereArgs, groupBy, having, orderBy );
//        String columns[] = { "PL.name as Name", "PS.name as Position", "salary as Salary" };
//
//
//        try {
//            cursorWrapper.moveToFirst();
//            while (!cursorWrapper.isAfterLast()) {
//                itemList.add(cursorWrapper.getFormTable());
//
//                cursorWrapper.moveToNext();
//            }
//        }finally {
//            cursorWrapper.close();
//        }
//        return dict;
//    }
//
//    private LinmeaCursorWrapper queryTable(
//            String table, String[] columns, String whereClause, String[] whereArgs, String groupBy, String having, String orderBy ) {
//        Cursor cursor = mDatabase.query( table, columns, whereClause, whereArgs, groupBy, having, orderBy );
//        return new LinmeaCursorWrapper(cursor);
//    }




    //_________________________________________________________OI_____________________________________________________
//    public List<OIModel> getOIWordList(){
//        List<OIModel> wordList = new ArrayList<>();
//        OICursorWrapper cursorWrapper = queryOIWords(null, null);
//
//        try {
//            cursorWrapper.moveToFirst();
//            while (!cursorWrapper.isAfterLast()) {
//                wordList.add(cursorWrapper.getWord());
//                cursorWrapper.moveToNext();
//            }
//        }finally {
//            cursorWrapper.close();
//        }
//        return wordList;
//    }
//
//    private OICursorWrapper queryOIWords(String whereClause, String[] whereArgs) {
//        Cursor cursor = mDatabase.query( OIDictionaryTable.NAME, null, whereClause, whereArgs, null, null, null);
//        return new OICursorWrapper(cursor);
//    }
}

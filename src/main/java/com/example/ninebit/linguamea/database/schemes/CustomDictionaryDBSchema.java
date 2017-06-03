package com.example.ninebit.linguamea.database.schemes;

public class CustomDictionaryDBSchema {


    public static final class CustomDictionaryTable {

        public static final String NAME = "customdictionary";

        public static final class Columns {
            public static final String UUID = "uuid";
            public static final String WORD = "word";
            public static final String TRANSLATION = "translation";
            public static final String LEARNED = "learned";
            public static final String DESCRIPTION = "description";
            public static final String FAVORITE = "favorite";
        }
    }
}

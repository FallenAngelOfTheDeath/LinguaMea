package com.example.ninebit.linguamea.database.schemes;

public class MainDictionaryDBScheme {

    public static final class MainDictionaryTable {

        public static final String NAME = "maindictionary";

        public static final class Columns {
            public static final String UUID = "uuid";
            public static final String WORD = "word";
            public static final String TRANSCRIPTION = "transcription";

            public static final String TRANSLATION_UUID = "translation_uuid";
            public static final String _TRANSLATION_ID = "_translation_id";

            public static final String TYPE_UUID = "type_uuid";
            public static final String _TYPE_ID = "_type_id";

            public static final String FORM_UUID = "form_uuid";

            public static final String SYNONYM_UUID = "synonym_uuid";

            public static final String CATEGORY_UUID = "category_uuid";
            public static final String DESCRIPTION_UUID = "description_uuid";
            public static final String LANGUAGE_UUID = "language_uuid";

            public static final String LEARNED = "learned";
            public static final String FAVORITE = "favorite";
        }
    }











    public  static final class WordTable {

        public static final String NAME = "word_table";

        public static final class Columns {
            public static final String ID = "id";
            public static final String NAME = "word_name";

            public static final String SYNONYM_ID_LINK = "synonym_id_link";
            public static final String CATEGORY_ID_LINK = "category_id_link";
            public static final String MAIN_TANSLATION_ID_LINK = "main_translation_id_link";
            public static final String MAIN_TANSCRIPTION_ID_LINK = "main_transcription_link";
            public static final String MAIN_DESCRIPTION_ID_LINK = "main_description_link";

            public static final String LANGUAGE_ID_LINK = "language_id_link";

            public static final String LEARNED = "learned";
            public static final String FAVORITE = "favorite";
        }
    }

    public  static final class FormTable {

        public static final String NAME = "form_table";

        public static final class Columns {
            public static final String FORM_NAME = "form_name";

            public static final String FORM_ID = "form_id";
            public static final String WORD_ID_LINK = "word_id_link";
            public static final String FORM_TRANSCRIPTION_ID_LINK = "form_transcription_id_link";
            public static final String FORM_TRANSLATION_ID_LINK = "form_translation_id_link";
            public static final String FORM_DESCRIPTION_ID_LINK = "form_description_id_link";
            public static final String TYPE_ID_LINK = "type_id_link";
        }
    }

    public  static final class TypeTable {

        public static final String NAME = "type_table";

        public static final class Columns {
            public static final String ID = "type_id";
            public static final String NAME = "type_name";
        }
    }

    public  static final class FormNameTable {

        public static final String NAME = "form_name_table";

        public static final class Columns {
            public static final String ID = "form_name_id";
            public static final String NAME = "form_name";
        }
    }

    public  static final class TranslationTable {

        public static final String NAME = "translation_table";

        public static final class Columns {
            public static final String ID = "translation_id";
            public static final String NAME = "translation_name";
        }
    }

    public  static final class TranscriptinTable {

        public static final String NAME = "transcription_table";

        public static final class Columns {
            public static final String ID = "transcription_id";
            public static final String NAME = "transcription_name";
        }
    }


    public  static final class DescriptionTable {

        public static final String NAME = "description_table";

        public static final class Columns {
            public static final String ID = "description_id";
            public static final String NAME = "description_name";
        }
    }

    public  static final class CategoryTable {

        public static final String NAME = "category_table";

        public static final class Columns {
            public static final String ID = "category_id";
            public static final String NAME = "category_name";
        }
    }

    public  static final class LanguageTable {

        public static final String NAME = "language_table";

        public static final class Columns {
            public static final String ID = "language_id";
            public static final String NAME = "language_name";
        }
    }








//    public  static final class MDictionaryTable {
//
//        public static final String NAME = "mdictionary";
//
//        public static final class Columns {
//            public static final String ID = "id";
//            public static final String NAME = "word";
//
//            public static final String SYNONYM_ID = "synonym_id";
//            public static final String CATEGORY_ID = "category_id";
//
//            public static final String LANGUAGE_ID = "language_id";
//
//            public static final String LEARNED = "learned";
//            public static final String FAVORITE = "favorite";
//        }
//    }
//
//    public  static final class FormTable {
//
//        public static final String NAME = "formtable";
//
//        public static final class Columns {
//            public static final String NAME = "word";
//            public static final String TRANSCRIPTION = "transcription";
//
//            public static final String DESCRIPTION_ID = "description_id";
//            public static final String ENTRY_ID = "entry_id";
//            public static final String TYPE_ID = "type_id";
//            public static final String FORM_TYPE_ID = "form_type_id";
//        }
//    }
//
//    public  static final class TypeTable {
//
//        public static final String NAME = "typetable";
//
//        public static final class Columns {
//            public static final String ID = "id";
//            public static final String NAME = "type";
//        }
//    }
//
//    public  static final class FormTypeTable {
//
//        public static final String NAME = "formtypetable";
//
//        public static final class Columns {
//            public static final String ID = "id";
//            public static final String NAME = "form";
//        }
//    }
//
//    public  static final class TranslationTable {
//
//        public static final String NAME = "translationtable";
//
//        public static final class Columns {
//            public static final String ID = "id";
//            public static final String NAME = "translation";
//        }
//    }
//
//
//    public  static final class DescriptionTable {
//
//        public static final String NAME = "descriptiontable";
//
//        public static final class Columns {
//            public static final String ID = "id";
//            public static final String NAME = "description";
//        }
//    }
//
//    public  static final class CategoryTable {
//
//        public static final String NAME = "categorytable";
//
//        public static final class Columns {
//            public static final String ID = "id";
//            public static final String NAME = "category";
//        }
//    }



















    public static final class MainTranslationTable {

        public static final String NAME = "translationtable";

        public static final class Columns {
            public static final String TRANSLATION_UUID = "translation_uuid";
            public static final String TRANSLATION = "translation";
        }
    }

    public static final class MainTypeTable {

        public static final String NAME = "typetable";

        public static final class Columns {
            public static final String TYPE_UUID = "type_uuid";
            public static final String TYPE = "type";
        }
    }

    public static final class MainSynonimTable {

        public static final String NAME = "synonimtable";

        public static final class Columns {
            public static final String SYNONYM_UUID = "synonym_uuid";
            public static final String SYNONYM = "synonym";
        }
    }

    public static final class MainFormsTable {

        public static final String NAME = "formtable";

        public static final class Columns {
            public static final String FORM_UUID = "form_uuid";
            public static final String FORM = "form";
        }
    }

    public static final class MainCategoryeTable {

        public static final String NAME = "categorytable";

        public static final class Columns {
            public static final String CATEGORY_UUID = "category_uuid";
            public static final String CATEGORY = "category";
        }
    }

    public static final class MainDescriptionTable {

        public static final String NAME = "descriptiontable";

        public static final class Columns {
            public static final String DESCRIPTION_UUID = "description_uuid";
            public static final String DESCRIPTION = "description";
        }
    }
}

package com.example.ninebit.linguamea.model;

/**
 * Created by NineB on 4/23/2017.
 */

public class DictionaryModel {

        //Main dictionary table
        private Integer mID, mSynonymID, mCategoryIDLink, mMinaTranscriptionIDLink, mMainTranslationIDLink, mMainDescriptionIDLink;
        private String mWordName, mLanguageIDLink;
        private Boolean mLearned, mFavorite;

        //Form table
        private Integer mFromID, mWordIDLink, mFormTranscriptionIDLink, mTypeIDLink, mFormTranslationIDLink, mFormDescriptionIDLink;
        private String mForm;

        //Type table
        private Integer mTypeID;
        private String mTypeName;

        //Form name table
        private Integer mFormNameID;
        private String mFormName;

        //Translation table
        private Integer mTranslationID;
        private String mTranslationName;

        //Transcription table
        private Integer mTranscriptionID;
        private String mTranscriptionName;

        //Description table
        private Integer mDescriptionID;
        private String mDescriptionName;

        //Category table
        private Integer mCategoryID;
        private String mCategoryName;

        //Language table
        private Integer mLanguageID;
        private String mLanguageName;

        public DictionaryModel() {
        }

    public Integer getID() {
        return mID;
    }

    public void setID(Integer ID) {
        mID = ID;
    }

    public Integer getSynonymID() {
        return mSynonymID;
    }

    public void setSynonymID(Integer synonymID) {
        mSynonymID = synonymID;
    }

    public Integer getCategoryIDLink() {
        return mCategoryIDLink;
    }

    public void setCategoryIDLink(Integer categoryIDLink) {
        mCategoryIDLink = categoryIDLink;
    }

    public Integer getMinaTranscriptionIDLink() {
        return mMinaTranscriptionIDLink;
    }

    public void setMinaTranscriptionIDLink(Integer minaTranscriptionIDLink) {
        mMinaTranscriptionIDLink = minaTranscriptionIDLink;
    }

    public Integer getMainTranslationIDLink() {
        return mMainTranslationIDLink;
    }

    public void setMainTranslationIDLink(Integer mainTranslationIDLink) {
        mMainTranslationIDLink = mainTranslationIDLink;
    }

    public Integer getMainDescriptionIDLink() {
        return mMainDescriptionIDLink;
    }

    public void setMainDescriptionIDLink(Integer mainDescriptionIDLink) {
        mMainDescriptionIDLink = mainDescriptionIDLink;
    }

    public String getWordName() {
        return mWordName;
    }

    public void setWordName(String wordName) {
        mWordName = wordName;
    }

    public String getLanguageIDLink() {
        return mLanguageIDLink;
    }

    public void setLanguageIDLink(String languageIDLink) {
        mLanguageIDLink = languageIDLink;
    }

    public Boolean getLearned() {
        return mLearned;
    }

    public void setLearned(Boolean learned) {
        mLearned = learned;
    }

    public Boolean getFavorite() {
        return mFavorite;
    }

    public void setFavorite(Boolean favorite) {
        mFavorite = favorite;
    }

    public Integer getFromID() {
        return mFromID;
    }

    public void setFromID(Integer fromID) {
        mFromID = fromID;
    }

    public Integer getWordIDLink() {
        return mWordIDLink;
    }

    public void setWordIDLink(Integer wordIDLink) {
        mWordIDLink = wordIDLink;
    }

    public Integer getFormTranscriptionIDLink() {
        return mFormTranscriptionIDLink;
    }

    public void setFormTranscriptionIDLink(Integer formTranscriptionIDLink) {
        mFormTranscriptionIDLink = formTranscriptionIDLink;
    }

    public Integer getTypeIDLink() {
        return mTypeIDLink;
    }

    public void setTypeIDLink(Integer typeIDLink) {
        mTypeIDLink = typeIDLink;
    }

    public Integer getFormTranslationIDLink() {
        return mFormTranslationIDLink;
    }

    public void setFormTranslationIDLink(Integer formTranslationIDLink) {
        mFormTranslationIDLink = formTranslationIDLink;
    }

    public Integer getFormDescriptionIDLink() {
        return mFormDescriptionIDLink;
    }

    public void setFormDescriptionIDLink(Integer formDescriptionIDLink) {
        mFormDescriptionIDLink = formDescriptionIDLink;
    }

    public String getForm() {
        return mForm;
    }

    public void setForm(String form) {
        mForm = form;
    }

    public Integer getTypeID() {
        return mTypeID;
    }

    public void setTypeID(Integer typeID) {
        mTypeID = typeID;
    }

    public String getTypeName() {
        return mTypeName;
    }

    public void setTypeName(String typeName) {
        mTypeName = typeName;
    }

    public Integer getFormNameID() {
        return mFormNameID;
    }

    public void setFormNameID(Integer formNameID) {
        mFormNameID = formNameID;
    }

    public String getFormName() {
        return mFormName;
    }

    public void setFormName(String formName) {
        mFormName = formName;
    }

    public Integer getTranslationID() {
        return mTranslationID;
    }

    public void setTranslationID(Integer translationID) {
        mTranslationID = translationID;
    }

    public String getTranslationName() {
        return mTranslationName;
    }

    public void setTranslationName(String translationName) {
        mTranslationName = translationName;
    }

    public Integer getTranscriptionID() {
        return mTranscriptionID;
    }

    public void setTranscriptionID(Integer transcriptionID) {
        mTranscriptionID = transcriptionID;
    }

    public String getTranscriptionName() {
        return mTranscriptionName;
    }

    public void setTranscriptionName(String transcriptionName) {
        mTranscriptionName = transcriptionName;
    }

    public Integer getDescriptionID() {
        return mDescriptionID;
    }

    public void setDescriptionID(Integer descriptionID) {
        mDescriptionID = descriptionID;
    }

    public String getDescriptionName() {
        return mDescriptionName;
    }

    public void setDescriptionName(String descriptionName) {
        mDescriptionName = descriptionName;
    }

    public Integer getCategoryID() {
        return mCategoryID;
    }

    public void setCategoryID(Integer categoryID) {
        mCategoryID = categoryID;
    }

    public String getCategoryName() {
        return mCategoryName;
    }

    public void setCategoryName(String categoryName) {
        mCategoryName = categoryName;
    }

    public Integer getLanguageID() {
        return mLanguageID;
    }

    public void setLanguageID(Integer languageID) {
        mLanguageID = languageID;
    }

    public String getLanguageName() {
        return mLanguageName;
    }

    public void setLanguageName(String languageName) {
        mLanguageName = languageName;
    }

    //    private Integer mID, mTypeID, mTranslationID, mFormID, mSynonymID, mCategoryID, mDescriptionID, mEntryFormID, mFormTypeID;
//    private String mWord, mTranscription, mTranslation, mLanguageID, mType, mForm, mSynonym, mCategory, mDescription;
//    private Boolean mLearned, mFavorite;
//
//    public DictionaryModel(){
//        //mID = id;
//    }
//
//    public Integer getFormTypeID() {
//        return mFormTypeID;
//    }
//
//    public void setFormTypeID(Integer formTypeID) {
//        mFormTypeID = formTypeID;
//    }
//
//    public Integer getEntryFormID() {
//        return mEntryFormID;
//    }
//
//    public void setEntryFormID(Integer entryFormID) {
//        mEntryFormID = entryFormID;
//    }
//
//    public Integer getID() {
//        return mID;
//    }
//
//    public void setID(Integer ID) {
//        mID = ID;
//    }
//
//    public Integer getTypeID() {
//        return mTypeID;
//    }
//
//    public void setTypeID(Integer typeID) {
//        mTypeID = typeID;
//    }
//
//    public Integer getTranslationID() {
//        return mTranslationID;
//    }
//
//    public void setTranslationID(Integer translationID) {
//        mTranslationID = translationID;
//    }
//
//    public Integer getFormID() {
//        return mFormID;
//    }
//
//    public void setFormID(Integer formID) {
//        mFormID = formID;
//    }
//
//    public Integer getSynonymID() {
//        return mSynonymID;
//    }
//
//    public void setSynonymID(Integer synonymID) {
//        mSynonymID = synonymID;
//    }
//
//    public Integer getCategoryID() {
//        return mCategoryID;
//    }
//
//    public void setCategoryID(Integer categoryID) {
//        mCategoryID = categoryID;
//    }
//
//    public Integer getDescriptionID() {
//        return mDescriptionID;
//    }
//
//    public void setDescriptionID(Integer descriptionID) {
//        mDescriptionID = descriptionID;
//    }
//
//    public String getWord() {
//        return mWord;
//    }
//
//    public void setWord(String word) {
//        mWord = word;
//    }
//
//    public String getTranscription() {
//        return mTranscription;
//    }
//
//    public void setTranscription(String transcription) {
//        mTranscription = transcription;
//    }
//
//    public String getTranslation() {
//        return mTranslation;
//    }
//
//    public void setTranslation(String translation) {
//        mTranslation = translation;
//    }
//
//    public String getLanguageID() {
//        return mLanguageID;
//    }
//
//    public void setLanguageID(String languageID) {
//        mLanguageID = languageID;
//    }
//
//    public String getType() {
//        return mType;
//    }
//
//    public void setType(String type) {
//        mType = type;
//    }
//
//    public String getForm() {
//        return mForm;
//    }
//
//    public void setForm(String form) {
//        mForm = form;
//    }
//
//    public String getSynonym() {
//        return mSynonym;
//    }
//
//    public void setSynonym(String synonym) {
//        mSynonym = synonym;
//    }
//
//    public String getCategory() {
//        return mCategory;
//    }
//
//    public void setCategory(String category) {
//        mCategory = category;
//    }
//
//    public String getDescription() {
//        return mDescription;
//    }
//
//    public void setDescription(String description) {
//        mDescription = description;
//    }
//
//    public Boolean getLearned() {
//        return mLearned;
//    }
//
//    public void setLearned(Boolean learned) {
//        mLearned = learned;
//    }
//
//    public Boolean getFavorite() {
//        return mFavorite;
//    }
//
//    public void setFavorite(Boolean favorite) {
//        mFavorite = favorite;
//    }
}

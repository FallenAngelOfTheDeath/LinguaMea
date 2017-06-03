package com.example.ninebit.linguamea.model;

import java.util.UUID;

public class MainDictionaryModel {

    private UUID mUUID, mTypeUUID, mTranslationUUID, mFormUUID, mSynonymUUID, mCategoryUUID, mLanguageUUID, mDescriptionUUID;
    private String mWord, mTranscription;
    private Boolean mLearned, mFavorite;

    public MainDictionaryModel() {
        this(UUID.randomUUID());
    }

    public MainDictionaryModel(UUID uuid){
        mUUID = uuid;
    }

    public UUID getUUID() {
        return mUUID;
    }

    public void setUUID(UUID UUID) {
        mUUID = UUID;
    }

    public UUID getTypeUUID() {
        return mTypeUUID;
    }

    public void setTypeUUID(UUID typeUUID) {
        mTypeUUID = typeUUID;
    }

    public UUID getTranslationUUID() {
        return mTranslationUUID;
    }

    public void setTranslationUUID(UUID translationUUID) {
        mTranslationUUID = translationUUID;
    }

    public UUID getFormUUID() {
        return mFormUUID;
    }

    public void setFormUUID(UUID formUUID) {
        mFormUUID = formUUID;
    }

    public UUID getSynonymUUID() {
        return mSynonymUUID;
    }

    public void setSynonymUUID(UUID synonymUUID) {
        mSynonymUUID = synonymUUID;
    }

    public UUID getCategoryUUID() {
        return mCategoryUUID;
    }

    public void setCategoryUUID(UUID categoryUUID) {
        mCategoryUUID = categoryUUID;
    }

    public UUID getLanguageUUID() {
        return mLanguageUUID;
    }

    public void setLanguageUUID(UUID languageUUID) {
        mLanguageUUID = languageUUID;
    }

    public UUID getDescriptionUUID() {
        return mDescriptionUUID;
    }

    public void setDiscriptionUUID(UUID discriptionUUID) {
        mDescriptionUUID = discriptionUUID;
    }

    public String getWord() {
        return mWord;
    }

    public void setWord(String word) {
        mWord = word;
    }

    public String getTranscription() {
        return mTranscription;
    }

    public void setTranscription(String transcription) {
        mTranscription = transcription;
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
}

package com.example.ninebit.linguamea.model;

import java.util.UUID;

public class CustomDictionaryModel {

    private UUID mUUID;
    private String mWord, mTranslation, mDescription;
    private Boolean mLearned, mFavorite;

    public CustomDictionaryModel() {
        this(UUID.randomUUID());
    }

    public CustomDictionaryModel(UUID uuid){
        mUUID = uuid;
    }

    public UUID getUUID() {
        return mUUID;
    }

    public void setUUID(UUID UUID) {
        mUUID = UUID;
    }

    public String getWord() {
        return mWord;
    }

    public void setWord(String word) {
        mWord = word;
    }

    public String getTranslation() {
        return mTranslation;
    }

    public void setTranslation(String translation) {
        mTranslation = translation;
    }

    public Boolean getLearned() {
        return mLearned;
    }

    public void setLearned(Boolean learned) {
        mLearned = learned;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public Boolean getFavorite() {
        return mFavorite;
    }

    public void setFavorite(Boolean favorite) {
        mFavorite = favorite;
    }
}

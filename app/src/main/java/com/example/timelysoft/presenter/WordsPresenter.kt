package com.example.timelysoft.presenter

import com.example.timelysoft.data.model.Word

interface WordsPresenter{

    suspend fun showAddedWord(word: Word)
    suspend fun showError(message: String)
}
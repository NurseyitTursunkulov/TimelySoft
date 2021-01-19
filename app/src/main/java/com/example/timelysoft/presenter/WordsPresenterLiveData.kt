package com.example.timelysoft.presenter

import androidx.lifecycle.LiveData
import com.example.timelysoft.data.model.Word
import com.example.timelysoft.util.Event

interface WordsPresenterLiveData {

    val showAddedWordEvent: LiveData<Event<Word>>
    val showErrorEvent: LiveData<Event<String>>
}
package com.example.timelysoft.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.timelysoft.data.model.Word
import com.example.timelysoft.util.Event

class WordsPresneterImpl:WordsPresenter,WordsPresenterLiveData {

    private val _showAddedWordEvent = MutableLiveData<Event<Word>>()
    override val showAddedWordEvent: LiveData<Event<Word>> = _showAddedWordEvent
    override suspend fun showAddedWord(word: Word) {
        _showAddedWordEvent.postValue(Event(word))
    }

    private val _showErrorEvent = MutableLiveData<Event<String>>()
    override val showErrorEvent :LiveData<Event<String>> = _showErrorEvent
    override suspend fun showError(message: String) {
        _showErrorEvent.postValue(Event(message))
    }

}
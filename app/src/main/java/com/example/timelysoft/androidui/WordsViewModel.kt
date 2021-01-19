package com.example.timelysoft.androidui

import android.app.Application
import androidx.lifecycle.*
import com.example.timelysoft.data.model.Word
import com.example.timelysoft.domain.MainUseCase
import com.example.timelysoft.presenter.WordsPresenterLiveData
import com.example.timelysoft.util.EventObserver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WordsViewModel(
    private val useCase: MainUseCase,
    private val presenterLiveData: WordsPresenterLiveData
) : ViewModel(), WordsPresenterLiveData by presenterLiveData {

    val listOfWords = MutableLiveData<MutableList<Word>>(mutableListOf())

    init {
        presenterLiveData.showAddedWordEvent.observeForever(EventObserver {
            listOfWords.value = (listOfWords.value as MutableList<Word>).apply {
                add(it)
            }
        })
    }

    fun saveWord(name:String){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                useCase.saveWord(Word(name))
            }
        }
    }
}

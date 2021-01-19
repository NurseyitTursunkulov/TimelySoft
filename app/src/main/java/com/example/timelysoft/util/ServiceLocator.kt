package com.example.timelysoft.util

import com.example.timelysoft.data.WordRepoImpl
import com.example.timelysoft.data.WordRepository
import com.example.timelysoft.presenter.WordsPresenter
import com.example.timelysoft.presenter.WordsPresenterLiveData
import com.example.timelysoft.presenter.WordsPresneterImpl

object ServiceLocator{
    val wordsPresneterImpl = WordsPresneterImpl()
    fun getWordsPresenterLiveData():WordsPresenterLiveData{
        return wordsPresneterImpl
    }

    fun getWordsPresenter():WordsPresenter{
        return wordsPresneterImpl
    }

    val wordsRepository = WordRepoImpl()

    fun getWordsRepository(): WordRepository {
        return wordsRepository
    }
}
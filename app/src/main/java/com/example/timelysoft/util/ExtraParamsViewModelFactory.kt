package com.example.timelysoft.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.timelysoft.androidui.WordsViewModel
import com.example.timelysoft.domain.MainUseCase
import com.example.timelysoft.presenter.WordsPresenterLiveData


class ExtraParamsViewModelFactory(
    private val mainUseCase: MainUseCase,
    private val presenterLiveData: WordsPresenterLiveData
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        WordsViewModel(mainUseCase, presenterLiveData) as T
}
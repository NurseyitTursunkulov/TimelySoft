package com.example.timelysoft.domain

import com.example.timelysoft.data.WordRepository
import com.example.timelysoft.data.model.Word
import com.example.timelysoft.presenter.WordsPresenter
import com.example.timelysoft.util.Result

class MainUseCase(
   private val wordRepository: WordRepository,
   private val presenter: WordsPresenter
) {

    suspend fun saveWord(word: Word) {
        val result = wordRepository.saveWord(word)
        when (result) {
            is Result.Success -> {
                presenter.showAddedWord(result.data)
            }
            is Result.Error -> {
                presenter.showError(result.exception.toString())
            }
        }
    }

    suspend fun deleteWord(word: Word) {

        wordRepository.deleteWord(word)
    }

    suspend fun getSavedWords() {
        wordRepository.getSavedWords()
    }

    suspend fun translateWord(word: Word) {
        wordRepository.translateWord(word)
    }
}
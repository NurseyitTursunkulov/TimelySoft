package com.example.timelysoft.data

import com.example.timelysoft.data.model.Word
import com.example.timelysoft.util.Result

interface WordRepository {
    suspend fun saveWord(word: Word):               Result<Word>
    suspend fun deleteWord(word: Word):             Result<Unit>
    suspend fun getSavedWords():                Result<List<Word>>
    suspend fun translateWord(word: Word):              Result<Word>
}
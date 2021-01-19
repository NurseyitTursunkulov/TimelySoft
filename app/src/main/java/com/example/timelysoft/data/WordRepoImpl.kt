package com.example.timelysoft.data

import com.example.timelysoft.data.model.Word
import com.example.timelysoft.util.Result

class WordRepoImpl :WordRepository{
    val words = mutableListOf<Word>()
    override suspend fun saveWord(word: Word): Result<Word> {
        words.add(word)
        return Result.Success(word)
    }

    override suspend fun deleteWord(word: Word): Result<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun getSavedWords(): Result<List<Word>> {
        TODO("Not yet implemented")
    }

    override suspend fun translateWord(word: Word): Result<Word> {
        TODO("Not yet implemented")
    }

}
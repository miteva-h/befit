package com.example.befit.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.befit.fakeapi.ExerciseDbApiProvider
import com.example.befit.repository.ExerciseRepository

class ExerciseListViewModelFactory (private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(ExerciseRepository::class.java)
            .newInstance(
                ExerciseRepository(ExerciseDbApiProvider.getExerciseDbApi())
            )
    }
}

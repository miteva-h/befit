package com.example.befit.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.befit.model.Exercise
import com.example.befit.repository.ExerciseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ExerciseViewModel(private val exerciseRepository: ExerciseRepository) : ViewModel() {

    private val exerciseLiveData = MutableLiveData<Exercise>()
    fun getExerciseLiveData(): LiveData<Exercise> = exerciseLiveData

    fun getExercise(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val exercise = exerciseRepository.getExercise(id)
            exerciseLiveData.postValue(exercise)
        }
    }
}

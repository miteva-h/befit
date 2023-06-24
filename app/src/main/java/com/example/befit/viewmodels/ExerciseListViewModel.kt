package com.example.befit.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.befit.model.Exercise
import com.example.befit.repository.ExerciseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ExerciseListViewModel(private val exerciseRepository: ExerciseRepository) : ViewModel() {

    private val exerciseListLiveData = MutableLiveData<List<Exercise>>()
    fun getExerciseListLiveData(): LiveData<List<Exercise>> = exerciseListLiveData

    fun listExercisesBySection(section: String) {
        viewModelScope.launch(Dispatchers.IO){
            val exercises = exerciseRepository.listExercisesBySection(section)
            exerciseListLiveData.postValue(exercises)
        }
    }
}
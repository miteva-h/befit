package com.example.befit.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.befit.model.Nutrition
import com.example.befit.repository.NutritionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NutritionViewModel(private val nutritionRepository: NutritionRepository) : ViewModel() {

    private val nutritionLiveData = MutableLiveData<Nutrition>()
    fun getNutritionLiveData(): LiveData<Nutrition> = nutritionLiveData

    fun getNutrition(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val nutrition = nutritionRepository.getNutrition(id)
            nutritionLiveData.postValue(nutrition)
        }
    }
}

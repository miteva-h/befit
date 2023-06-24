package com.example.befit.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.befit.model.Nutrition
import com.example.befit.repository.NutritionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NutritionListViewModel(private val nutritionRepository: NutritionRepository) : ViewModel() {

    private val nutritionListLiveData = MutableLiveData<List<Nutrition>>()
    fun getNutritionListLiveData(): LiveData<List<Nutrition>> = nutritionListLiveData

    fun listNutritionsByMeal(meal: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val nutritions = nutritionRepository.listNutritionsByMeal(meal)
            nutritionListLiveData.postValue(nutritions)
        }
    }
}
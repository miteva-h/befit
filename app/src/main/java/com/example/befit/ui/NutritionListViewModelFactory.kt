package com.example.befit.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.befit.fakeapi.NutritionDbApiProvider
import com.example.befit.repository.NutritionRepository

class NutritionListViewModelFactory (private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(NutritionRepository::class.java)
            .newInstance(
                NutritionRepository(NutritionDbApiProvider.getNutritionDbApi())
            )
    }
}
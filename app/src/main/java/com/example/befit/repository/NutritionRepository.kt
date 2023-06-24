package com.example.befit.repository

import com.example.befit.fakeapi.NutritionDbApi
import com.example.befit.model.Nutrition

class NutritionRepository(private val nutritionDbApi: NutritionDbApi) {

    fun listNutritionsByMeal(meal:String): List<Nutrition> {
        return nutritionDbApi.getNutritionByMeal(meal)
    }

    fun getNutrition(nutritionId: String): Nutrition {
        val nutritions = nutritionDbApi.getAllNutritions()
        val nutrition = nutritions.find { it.id.toString() == nutritionId }
        return nutrition!!
    }
}
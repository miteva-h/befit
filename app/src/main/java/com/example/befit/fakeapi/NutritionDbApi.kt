package com.example.befit.fakeapi

import com.example.befit.model.Nutrition

class NutritionDbApi {

    private val nutritions:MutableList<Nutrition> = ArrayList()

    fun getAllNutritions():List<Nutrition>{
        return nutritions
    }
    fun getNutritionByMeal(meal:String): List<Nutrition> {
        return nutritions.filter { it.meal == meal}
    }

    fun addNutrition(name:String, meal:String, photo: String, preparation:String, cal:String){
        val newNutrition = Nutrition(nutritions.size, name, meal, photo, preparation, cal);
        nutritions.add(newNutrition)
    }
}
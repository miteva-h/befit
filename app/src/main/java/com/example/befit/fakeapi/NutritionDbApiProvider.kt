package com.example.befit.fakeapi

class NutritionDbApiProvider {

    companion object {
        @Volatile
        private var INSTANCE: NutritionDbApi? = null

        @JvmStatic
        fun getNutritionDbApi(): NutritionDbApi {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = NutritionDbApiProvider.createNutritionDbApi()
                INSTANCE = instance
                // return instance
                instance
            }
        }

        private fun createNutritionDbApi(): NutritionDbApi {
            var nutritionDbApi = NutritionDbApi()
            nutritionDbApi.addNutrition(
                "Oat meal",
                "Breakfast",
                "breakfast_oats",
                "Serve your oats with forest fruit.",
                "300kcal"
            )
            nutritionDbApi.addNutrition(
                "Avocado toast",
                "Breakfast",
                "breakfast_avo_toast",
                "Serve your avocado on toast.",
                "400kcal"
            )
            nutritionDbApi.addNutrition(
                "Egg quesadillas",
                "Breakfast",
                "breakfast_quesadillas",
                "Serve your eggs inside the quesadillas.",
                "500kcal"
            )
            nutritionDbApi.addNutrition(
                "Rice chicken",
                "Lunch",
                "lunch_rice_chicken",
                "Serve your chicken with rice.",
                "500kcal"
            )
            nutritionDbApi.addNutrition(
                "Veggie wrap",
                "Lunch",
                "lunch_veggie_wrap",
                "Serve your wrap with different souses.",
                "450kcal"
            )
            nutritionDbApi.addNutrition(
                "Chicken bowl",
                "Lunch",
                "lunch_chicken_bowl",
                "Serve your chicken with veggies.",
                "400kcal"
            )
            nutritionDbApi.addNutrition(
                "Pepper nachos",
                "Dinner",
                "dinner_pepper_nachos",
                "Serve your peppers with meat and veggies.",
                "500kcal"
            )
            nutritionDbApi.addNutrition(
                "Salmon",
                "Dinner",
                "dinner_salmon",
                "Serve your salmon with veggies.",
                "450kcal"
            )
            nutritionDbApi.addNutrition(
                "Pasta",
                "Dinner",
                "dinner_pasta",
                "Serve your pasta with souse.",
                "550kcal"
            )
            return nutritionDbApi
        }
    }
}

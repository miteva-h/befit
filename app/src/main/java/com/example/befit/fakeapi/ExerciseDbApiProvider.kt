package com.example.befit.fakeapi

class ExerciseDbApiProvider {

    companion object {
        @Volatile
        private var INSTANCE: ExerciseDbApi? = null

        @JvmStatic
        fun getExerciseDbApi(): ExerciseDbApi {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = createExerciseDbApi()
                INSTANCE = instance
                // return instance
                instance
            }
        }

        private fun createExerciseDbApi(): ExerciseDbApi {
            var exerciseDbApi = ExerciseDbApi()
            exerciseDbApi.addExercise(
                "Lifted legs push-ups",
                "Upper Body",
                "upper_lifted_pushups",
                "Do 3sets x 8repetitions.",
                "Advanced"
            )
            exerciseDbApi.addExercise(
                "Dumbbell push",
                "Upper Body",
                "upper_dumbell_push",
                "Do 3sets x 8repetitions.",
                "Intermediate"
            )
            exerciseDbApi.addExercise(
                "Lifted leg push-ups",
                "Upper Body",
                "upper_upleg_pushups",
                "Do 3sets x 8repetitions.",
                "Advanced"
            )
            exerciseDbApi.addExercise(
                "Lunges",
                "Lower Body",
                "legs_lunges",
                "Do 4sets x 10repetitions.",
                "Beginner"
            )
            exerciseDbApi.addExercise(
                "Bridges",
                "Lower Body",
                "legs_bridges",
                "Do 4sets x 10repetitions.",
                "Beginner"
            )
            exerciseDbApi.addExercise(
                "Weighted step-ups",
                "Lower Body",
                "legs_weighted_stepups",
                "Do 4sets x 10repetitions.",
                "Intermediate"
            )
            exerciseDbApi.addExercise(
                "Crunches",
                "Abs and Core",
                "abs_crunches",
                "Do 4sets x 15repetitions.",
                "Beginner"
            )
            exerciseDbApi.addExercise(
                "Cross crunches",
                "Abs and Core",
                "abs_cross_crunches",
                "Do 4sets x 15repetitions.",
                "Intermediate"
            )
            exerciseDbApi.addExercise(
                "Side plank",
                "Abs and Core",
                "abs_side_crunches",
                "Do 3sets x 45sec.",
                "Advanced"
            )
            return exerciseDbApi
        }
    }
}
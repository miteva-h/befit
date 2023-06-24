package com.example.befit.repository

import com.example.befit.fakeapi.ExerciseDbApi
import com.example.befit.model.Exercise

class ExerciseRepository(private val exerciseDbApi:ExerciseDbApi) {

    fun listExercisesBySection(section:String): List<Exercise> {
        return exerciseDbApi.getExercisesBySection(section)
    }

    fun getExercise(exerciseId: String): Exercise {
        val exercises = exerciseDbApi.getAllExercises()
        val exercise = exercises.find { it.id.toString() == exerciseId }
        return exercise!!
    }
}
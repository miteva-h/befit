package com.example.befit.fakeapi

import com.example.befit.model.Exercise

class ExerciseDbApi {

    private val exercises:MutableList<Exercise> = ArrayList()

    fun getAllExercises():List<Exercise>{
        return exercises
    }
    fun getExercisesBySection(section:String): List<Exercise> {
        return exercises.filter { it.section == section }
    }

    fun addExercise(name:String, section:String, photo: String, description:String, level:String){
        val newExercise = Exercise(exercises.size, name, section, photo, description, level);
        exercises.add(newExercise)
    }
}
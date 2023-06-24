package com.example.befit.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.befit.R

class HomeFragment:Fragment(R.layout.home_fragment) {

    private lateinit var buttonExercises: Button
    private lateinit var buttonNutrition: Button
    private lateinit var buttonOptions: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        buttonExercises = view.findViewById(R.id.button_exercises)
        buttonNutrition = view.findViewById(R.id.button_nutrition)
        buttonOptions = view.findViewById(R.id.button_options)

        buttonExercises.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_container_view, ExerciseFragment())
                setReorderingAllowed(true)
                addToBackStack(null)
            }
        }

        buttonNutrition.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_container_view, NutritionFragment())
                setReorderingAllowed(true)
                addToBackStack(null)
            }
        }

        buttonOptions.setOnClickListener {
            val intent = Intent(requireContext(), OptionsActivity::class.java)
            startActivity(intent)
        }
    }
}
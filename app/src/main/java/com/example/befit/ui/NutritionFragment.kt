package com.example.befit.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.befit.R

class NutritionFragment:Fragment(R.layout.nutrition_fragment) {

    private lateinit var buttonHome: Button
    private lateinit var buttonExercises: Button
    private lateinit var buttonOptions: Button
    private lateinit var breakfastButton: Button
    private lateinit var lunchButton: Button
    private lateinit var dinnerButton: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonHome = view.findViewById(R.id.button_home)
        buttonExercises = view.findViewById(R.id.button_exercises)
        buttonOptions = view.findViewById(R.id.button_options)
        breakfastButton = view.findViewById(R.id.breakfast_button)
        lunchButton = view.findViewById(R.id.lunch_button)
        dinnerButton = view.findViewById(R.id.dinner_button)

        buttonHome.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_container_view, HomeFragment())
                setReorderingAllowed(true)
                addToBackStack(null)
            }
        }

        buttonExercises.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_container_view, ExerciseFragment())
                setReorderingAllowed(true)
                addToBackStack(null)
            }
        }

        breakfastButton.setOnClickListener{
            val bundle = Bundle().apply {
                putString("meal", "Breakfast")
            }
            val nutritionListFragment = NutritionListFragment()
            nutritionListFragment.arguments = bundle

            parentFragmentManager.commit {
                replace(R.id.fragment_container_view, nutritionListFragment)
                setReorderingAllowed(true)
                addToBackStack(null)
            }
        }

        lunchButton.setOnClickListener{
            val bundle = Bundle().apply {
                putString("meal", "Lunch")
            }
            val nutritionListFragment = NutritionListFragment()
            nutritionListFragment.arguments = bundle

            parentFragmentManager.commit {
                replace(R.id.fragment_container_view, nutritionListFragment)
                setReorderingAllowed(true)
                addToBackStack(null)
            }
        }

        dinnerButton.setOnClickListener{
            val bundle = Bundle().apply {
                putString("meal", "Dinner")
            }
            val nutritionListFragment = NutritionListFragment()
            nutritionListFragment.arguments = bundle

            parentFragmentManager.commit {
                replace(R.id.fragment_container_view, nutritionListFragment)
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
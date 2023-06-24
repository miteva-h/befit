package com.example.befit.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.befit.R

class ExerciseFragment:Fragment(R.layout.exercise_fragment) {

    private lateinit var buttonHome: Button
    private lateinit var buttonNutrition: Button
    private lateinit var buttonOptions: Button
    private lateinit var upperBodyButton: Button
    private lateinit var absButton: Button
    private lateinit var legsButton: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        buttonHome = view.findViewById(R.id.button_home)
        buttonNutrition = view.findViewById(R.id.button_nutrition)
        buttonOptions = view.findViewById(R.id.button_options)
        upperBodyButton = view.findViewById(R.id.upper_body_button)
        absButton = view.findViewById(R.id.abs_button)
        legsButton = view.findViewById(R.id.legs_button)

        buttonHome.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_container_view, HomeFragment())
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

        upperBodyButton.setOnClickListener{
            val bundle = Bundle().apply {
                putString("section", "Upper Body")
            }
            val exerciseListFragment = ExerciseListFragment()
            exerciseListFragment.arguments = bundle

            parentFragmentManager.commit {
                replace(R.id.fragment_container_view, exerciseListFragment)
                setReorderingAllowed(true)
                addToBackStack(null)
            }
        }

        absButton.setOnClickListener{
            val bundle = Bundle().apply {
                putString("section", "Abs and Core")
            }
            val exerciseListFragment = ExerciseListFragment()
            exerciseListFragment.arguments = bundle

            parentFragmentManager.commit {
                replace(R.id.fragment_container_view, exerciseListFragment)
                setReorderingAllowed(true)
                addToBackStack(null)
            }
        }

        legsButton.setOnClickListener{
            val bundle = Bundle().apply {
                putString("section", "Lower Body")
            }
            val exerciseListFragment = ExerciseListFragment()
            exerciseListFragment.arguments = bundle

            parentFragmentManager.commit {
                replace(R.id.fragment_container_view, exerciseListFragment)
                setReorderingAllowed(true)
                addToBackStack(null)
            }
        }
    }
}
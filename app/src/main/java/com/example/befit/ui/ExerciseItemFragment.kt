package com.example.befit.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import com.example.befit.R
import com.example.befit.databinding.ExerciseDetailsFragmentBinding
import com.example.befit.viewmodels.ExerciseViewModel

class ExerciseItemFragment : Fragment(R.layout.exercise_details_fragment) {

    private lateinit var buttonHome: Button
    private lateinit var buttonNutrition: Button
    private lateinit var buttonExercises: Button
    private lateinit var buttonOptions: Button

    private var _binding: ExerciseDetailsFragmentBinding? = null

    private val binding get() = _binding!!

    private val exerciseViewModel: ExerciseViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = ExerciseDetailsFragmentBinding.bind(view)

        exerciseViewModel.getExerciseLiveData().observe(viewLifecycleOwner) {
            binding.sectionText.text = "Target:" + it.section
            binding.nameText.text = it.name
            when (it.photo) {
                "upper_lifted_pushups" -> binding.exerciseImg.setImageResource(R.drawable.upper_lifted_pushups)
                "upper_dumbell_push" -> binding.exerciseImg.setImageResource(R.drawable.upper_dumbell_push)
                "upper_upleg_pushups" -> binding.exerciseImg.setImageResource(R.drawable.upper_upleg_pushups)
                "legs_lunges" -> binding.exerciseImg.setImageResource(R.drawable.legs_lunges)
                "legs_bridges" -> binding.exerciseImg.setImageResource(R.drawable.legs_bridges)
                "legs_weighted_stepups" -> binding.exerciseImg.setImageResource(R.drawable.legs_weighted_stepups)
                "abs_crunches" -> binding.exerciseImg.setImageResource(R.drawable.abs_crunches)
                "abs_cross_crunches" -> binding.exerciseImg.setImageResource(R.drawable.abs_cross_crunches)
                "abs_side_crunches" -> binding.exerciseImg.setImageResource(R.drawable.abs_side_crunches)
                else -> {
                    // Handle any other cases
                }
            }
            binding.levelText.text = "Level:" + it.level
            binding.descText.text = it.description
        }


        buttonHome = view.findViewById(R.id.button_home)
        buttonNutrition = view.findViewById(R.id.button_nutrition)
        buttonExercises = view.findViewById(R.id.button_exercises)
        buttonOptions = view.findViewById(R.id.button_options)


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

        buttonExercises.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_container_view, ExerciseFragment())
                setReorderingAllowed(true)
                addToBackStack(null)
            }
        }

        buttonOptions.setOnClickListener {
            val intent = Intent(requireContext(), LoginActivity::class.java)
            startActivity(intent)
        }

    }
}
package com.example.befit.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import com.example.befit.R
import com.example.befit.databinding.NutritionDetailsFragmentBinding
import com.example.befit.viewmodels.NutritionViewModel

class NutritionItemFragment : Fragment(R.layout.nutrition_details_fragment) {

    private lateinit var buttonHome: Button
    private lateinit var buttonNutrition: Button
    private lateinit var buttonExercises: Button
    private lateinit var buttonOptions: Button

    private var _binding: NutritionDetailsFragmentBinding? = null

    private val binding get() = _binding!!

    private val nutritionViewModel: NutritionViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = NutritionDetailsFragmentBinding.bind(view)

        nutritionViewModel.getNutritionLiveData().observe(viewLifecycleOwner) {
            binding.mealText.text = "Meal:" + it.meal
            binding.nameText.text = it.name
            when (it.photo) {
                "breakfast_avo_toast" -> binding.nutritionImg.setImageResource(R.drawable.breakfast_avo_toast)
                "breakfast_oats" -> binding.nutritionImg.setImageResource(R.drawable.breakfast_oats)
                "breakfast_quesadillas" -> binding.nutritionImg.setImageResource(R.drawable.breakfast_quesadillas)
                "lunch_chicken_bowl" -> binding.nutritionImg.setImageResource(R.drawable.lunch_chicken_bowl)
                "lunch_rice_chicken" -> binding.nutritionImg.setImageResource(R.drawable.lunch_rice_chicken)
                "lunch_veggie_wrap" -> binding.nutritionImg.setImageResource(R.drawable.lunch_veggie_wrap)
                "dinner_pasta" -> binding.nutritionImg.setImageResource(R.drawable.dinner_pasta)
                "dinner_pepper_nachos" -> binding.nutritionImg.setImageResource(R.drawable.dinner_pepper_nachos)
                "dinner_salmon" -> binding.nutritionImg.setImageResource(R.drawable.dinner_salmon)
                else -> {
                    // Handle any other cases
                }
            }
            binding.calText.text = "Calories:" + it.cal
            binding.prepText.text = it.preparation
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
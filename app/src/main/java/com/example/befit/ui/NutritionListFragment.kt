package com.example.befit.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import com.example.befit.R
import com.example.befit.adapters.NutritionListAdapter
import com.example.befit.databinding.NutritionListFragmentBinding
import com.example.befit.model.Nutrition
import com.example.befit.viewmodels.NutritionListViewModel
import com.example.befit.viewmodels.NutritionViewModel

class NutritionListFragment : Fragment(R.layout.nutrition_list_fragment) {
    private lateinit var buttonHome: Button
    private lateinit var buttonNutrition: Button
    private lateinit var buttonExercises: Button
    private lateinit var buttonOptions: Button


    private var _binding: NutritionListFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var nutritionListViewModel: NutritionListViewModel

    private val nutritionViewModel: NutritionViewModel by activityViewModels{NutritionListViewModelFactory(requireContext())}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = NutritionListFragmentBinding.bind(view)

        val viewModelFactory = NutritionListViewModelFactory(requireContext())
        nutritionListViewModel = ViewModelProvider(this, viewModelFactory)[NutritionListViewModel::class.java]

        val clicker = object : NutritionListAdapter.OnClickListener {
            override fun onItemClick(nutritionId:String) {
                nutritionViewModel.getNutrition(nutritionId)
                parentFragmentManager.commit {
                    replace(R.id.fragment_container_view, NutritionItemFragment())
                    setReorderingAllowed(true)
                    addToBackStack(null)
                }
            }
        }

        var adapter: NutritionListAdapter = NutritionListAdapter(ArrayList<Nutrition>(), clicker)
        binding.list.adapter = adapter

        nutritionListViewModel.getNutritionListLiveData().observe(viewLifecycleOwner) {
            adapter.updateNutritions(it)
        }

        nutritionListViewModel.listNutritionsByMeal(arguments?.getString("meal").toString())




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
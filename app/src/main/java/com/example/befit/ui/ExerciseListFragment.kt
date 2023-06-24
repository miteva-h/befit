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
import com.example.befit.adapters.ExerciseListAdapter
import com.example.befit.databinding.ExerciseListFragmentBinding
import com.example.befit.model.Exercise
import com.example.befit.viewmodels.ExerciseListViewModel
import com.example.befit.viewmodels.ExerciseViewModel

class ExerciseListFragment : Fragment(R.layout.exercise_list_fragment) {
    private lateinit var buttonHome: Button
    private lateinit var buttonNutrition: Button
    private lateinit var buttonExercises: Button
    private lateinit var buttonOptions: Button


    private var _binding: ExerciseListFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var exerciseListViewModel: ExerciseListViewModel

    private val exerciseViewModel: ExerciseViewModel by activityViewModels{ExerciseListViewModelFactory(requireContext())}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = ExerciseListFragmentBinding.bind(view)

        val viewModelFactory = ExerciseListViewModelFactory(requireContext())
        exerciseListViewModel = ViewModelProvider(this, viewModelFactory)[ExerciseListViewModel::class.java]

        val clicker = object : ExerciseListAdapter.OnClickListener {
            override fun onItemClick(exerciseId:String) {
                exerciseViewModel.getExercise(exerciseId)
                parentFragmentManager.commit {
                    replace(R.id.fragment_container_view, ExerciseItemFragment())
                    setReorderingAllowed(true)
                    addToBackStack(null)
                }
            }
        }

        var adapter: ExerciseListAdapter = ExerciseListAdapter(ArrayList<Exercise>(), clicker)
        binding.list.adapter = adapter

        exerciseListViewModel.getExerciseListLiveData().observe(viewLifecycleOwner) {
            adapter.updateExercises(it)
        }

        exerciseListViewModel.listExercisesBySection(arguments?.getString("section").toString())




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
            val intent = Intent(requireContext(), OptionsActivity::class.java)
            startActivity(intent)
        }

    }
}
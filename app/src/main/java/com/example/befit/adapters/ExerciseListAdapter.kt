package com.example.befit.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.befit.R
import com.example.befit.model.Exercise

class ExerciseListAdapter(
    private val exerciseList: ArrayList<Exercise> = ArrayList<Exercise>(),
    private val clicker: OnClickListener
) : Adapter<ExerciseListAdapter.ExerciseViewHolder>() {

    interface OnClickListener {
        fun onItemClick(exerciseId: String)
    }

    class ExerciseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var name: TextView = view.findViewById(R.id.exercise_name)
        private var level: TextView = view.findViewById(R.id.exercise_level)
        private var photo: ImageView = view.findViewById(R.id.exercise_photo)

        fun bind(
            exercise: Exercise,
            onClickListener: OnClickListener
        ) {
            name.text = exercise.name
            level.text = "L:" + exercise.level
            when (exercise.photo) {
                "upper_lifted_pushups" -> photo.setImageResource(R.drawable.upper_lifted_pushups)
                "upper_dumbell_push" -> photo.setImageResource(R.drawable.upper_dumbell_push)
                "upper_upleg_pushups" -> photo.setImageResource(R.drawable.upper_upleg_pushups)
                "legs_lunges" -> photo.setImageResource(R.drawable.legs_lunges)
                "legs_bridges" -> photo.setImageResource(R.drawable.legs_bridges)
                "legs_weighted_stepups" -> photo.setImageResource(R.drawable.legs_weighted_stepups)
                "abs_crunches" -> photo.setImageResource(R.drawable.abs_crunches)
                "abs_cross_crunches" -> photo.setImageResource(R.drawable.abs_cross_crunches)
                "abs_side_crunches" -> photo.setImageResource(R.drawable.abs_side_crunches)
                else -> {
                    // Handle any other cases
                }
            }

            itemView.setOnClickListener {
                onClickListener.onItemClick(exercise.id.toString())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.exercise_item, parent, false)
        return ExerciseViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        holder.bind(exerciseList[position], clicker)
    }


    override fun getItemCount(): Int {
        return exerciseList.size
    }

    fun updateExercises(exercises: List<Exercise>) {
        this.exerciseList.clear()
        if (exercises != null) {
            this.exerciseList.addAll(exercises)
        }
        notifyDataSetChanged()
    }

}
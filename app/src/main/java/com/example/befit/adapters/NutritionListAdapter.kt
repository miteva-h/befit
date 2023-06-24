package com.example.befit.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.befit.R
import com.example.befit.model.Nutrition

class NutritionListAdapter(
    private val nutritionList: ArrayList<Nutrition> = ArrayList<Nutrition>(),
    private val clicker: OnClickListener
) : Adapter<NutritionListAdapter.NutritionViewHolder>() {

    interface OnClickListener {
        fun onItemClick(exerciseId: String)
    }

    class NutritionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var name: TextView = view.findViewById(R.id.nutrition_name)
        private var cal: TextView = view.findViewById(R.id.nutrition_cal)
        private var photo: ImageView = view.findViewById(R.id.nutrition_photo)

        fun bind(
            nutrition: Nutrition,
            onClickListener: NutritionListAdapter.OnClickListener
        ) {
            name.text = nutrition.name
            cal.text = "Kcal:" + nutrition.cal

            when (nutrition.photo) {
                "breakfast_avo_toast" -> photo.setImageResource(R.drawable.breakfast_avo_toast)
                "breakfast_oats" -> photo.setImageResource(R.drawable.breakfast_oats)
                "breakfast_quesadillas" -> photo.setImageResource(R.drawable.breakfast_quesadillas)
                "lunch_chicken_bowl" -> photo.setImageResource(R.drawable.lunch_chicken_bowl)
                "lunch_rice_chicken" -> photo.setImageResource(R.drawable.lunch_rice_chicken)
                "lunch_veggie_wrap" -> photo.setImageResource(R.drawable.lunch_veggie_wrap)
                "dinner_pasta" -> photo.setImageResource(R.drawable.dinner_pasta)
                "dinner_pepper_nachos" -> photo.setImageResource(R.drawable.dinner_pepper_nachos)
                "dinner_salmon" -> photo.setImageResource(R.drawable.dinner_salmon)
                else -> {
                    // Handle any other cases
                }
            }

            itemView.setOnClickListener {
                onClickListener.onItemClick(nutrition.id.toString())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NutritionViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.nutrition_item, parent, false)
        return NutritionViewHolder(view)
    }

    override fun onBindViewHolder(holder: NutritionViewHolder, position: Int) {
        holder.bind(nutritionList[position], clicker)
    }

    override fun getItemCount(): Int {
        return nutritionList.size
    }

    fun updateNutritions(nutritions: List<Nutrition>) {
        this.nutritionList.clear()
        if (nutritions != null) {
            this.nutritionList.addAll(nutritions)
        }
        notifyDataSetChanged()
    }

}
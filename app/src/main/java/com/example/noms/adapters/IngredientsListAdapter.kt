package com.example.noms.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.noms.R
import com.example.noms.model.Ingredient
import kotlinx.android.synthetic.main.ingredient_list_item.view.*
import java.lang.StringBuilder

class IngredientsListAdapter (val ingredient: List<Ingredient>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ingredient_list_item, parent, false)
        return IngredientListItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as IngredientListItemViewHolder).bind(ingredient[position])
    }

    override fun getItemCount() = ingredient.size

    class IngredientListItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(ingredient: Ingredient) {
            var ingredientInfo = StringBuilder()

            ingredientInfo
                .append(ingredient.quantity)
                .append(" ")

            if (ingredient.unit != null) {
                ingredientInfo
                    .append(ingredient.unit)
                    .append(" ")
            }

            ingredientInfo.append(ingredient.title)

            itemView.ingredientInfo.text = ingredientInfo
        }
    }
}
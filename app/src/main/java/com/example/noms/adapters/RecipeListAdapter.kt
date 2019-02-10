package com.example.noms.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.noms.R
import com.example.noms.model.Recipe
import kotlinx.android.synthetic.main.recipe_list_item.view.*

class RecipeListAdapter (val recipe: ArrayList<Recipe>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recipe_list_item, parent, false)
        return PartViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PartViewHolder).bind(recipe[position])
    }

    override fun getItemCount() = recipe.size

    class PartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(recipe: Recipe) {
            itemView.recipeTitle.text = recipe.title
        }
    }
}
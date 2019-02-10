package com.example.noms.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.noms.R
import com.example.noms.adapters.IngredientsListAdapter
import com.example.noms.adapters.InstructionsListAdapter
import com.example.noms.model.Recipe
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_recipe.*

class RecipeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)

        var recipe = intent.getSerializableExtra("RECIPE") as Recipe

        setSupportActionBar(recipeToolbar)

        if (supportActionBar != null){
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
            supportActionBar!!.title = recipe.title
        }

        Picasso.get().load(recipe.image).into(recipeImage)
        ingredientsList.isNestedScrollingEnabled = false
        instructionsList.isNestedScrollingEnabled = false
        ingredientsList.adapter = IngredientsListAdapter(recipe.ingredients!!)
        instructionsList.adapter = InstructionsListAdapter(recipe.instructions!!)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
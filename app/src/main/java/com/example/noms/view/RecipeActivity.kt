package com.example.noms.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.noms.R
import kotlinx.android.synthetic.main.activity_recipe.*

class RecipeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)

        setSupportActionBar(recipeToolbar)

        if (supportActionBar != null){
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
            supportActionBar!!.title = intent.getStringExtra("RECIPE_TITLE")
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
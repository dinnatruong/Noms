package com.example.noms.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.example.noms.R
import com.example.noms.adapters.RecipeListAdapter
import kotlinx.android.synthetic.main.activity_recipe_book.*

class RecipeBookActivity : AppCompatActivity() {

    private lateinit var recipeBookViewModel: RecipeBookViewModel
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_book)
        
        if (supportActionBar != null) {
            supportActionBar!!.title = "Noms"
        }

        recipeBookViewModel = ViewModelProviders.of(this).get(RecipeBookViewModel::class.java)

        // Fetch list of recipes
        recipeBookViewModel.getRecipeBook().observe(this, Observer {

            if (it != null) {
                   recipeList.adapter = RecipeListAdapter(it[0].recipes!!)
            }
        })

        // Add RecyclerView line dividers
        val listDivider = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        listDivider.setDrawable(ContextCompat.getDrawable(this, R.drawable.grey_line_divider)!!)
        recipeList.addItemDecoration(listDivider)
    }
}

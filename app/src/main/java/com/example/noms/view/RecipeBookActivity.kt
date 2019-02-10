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
import com.example.noms.model.Recipe
import kotlinx.android.synthetic.main.activity_recipe_book.*

class RecipeBookActivity : AppCompatActivity() {

    private lateinit var recipeBookViewModel: RecipeBookViewModel
    private lateinit var recipeViewModel: RecipeViewModel
    private var recipesList = arrayListOf<Recipe>()
    private var recipeAdapter = RecipeListAdapter(recipesList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_book)
        
        if (supportActionBar != null) {
            supportActionBar!!.title = "Noms"
        }

        setupRecyclerView()

        recipeBookViewModel = ViewModelProviders.of(this).get(RecipeBookViewModel::class.java)
        recipeViewModel = ViewModelProviders.of(this).get(RecipeViewModel::class.java)

        // Fetch recipe book
        recipeBookViewModel.getRecipeBook().observe(this, Observer {

            if (it != null) {

                // Fetch each recipe
                for (i in it[0].recipes!!) {
                    recipeViewModel.getRecipe(i).observe(this, Observer {

                        // Add recipe to list and display
                        if (it != null && !recipesList.contains(it)) {
                            recipesList.add(it)
                            recipeAdapter.notifyDataSetChanged()
                        }
                    })
                }
            }
        })
    }

    private fun setupRecyclerView() {
        if (recipeList.adapter == null) {
            recipeList.adapter = recipeAdapter

            val listDivider = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
            listDivider.setDrawable(ContextCompat.getDrawable(this, R.drawable.grey_line_divider)!!)
            recipeList.addItemDecoration(listDivider)

        } else {
            recipeAdapter.notifyDataSetChanged()
        }
    }
}

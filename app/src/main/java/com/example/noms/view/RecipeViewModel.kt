package com.example.noms.view

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.noms.data.RecipeBookAPI
import com.example.noms.data.RecipeResponse
import com.example.noms.model.Recipe
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RecipeViewModel : ViewModel() {
    private val BASE_URL = "http://10.0.2.2:3000"
    private val data = MutableLiveData<Recipe>()

    fun getRecipe(recipeId: String) : MutableLiveData<Recipe> {
        loadRecipe(recipeId)
        return data
    }

    fun loadRecipe(recipeId: String) {

        val retrofitService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val recipeBookAPI = retrofitService.create(RecipeBookAPI::class.java)

        val response = recipeBookAPI.getRecipe(recipeId)

        response.enqueue(object : Callback<RecipeResponse> {
            override fun onResponse(call: Call<RecipeResponse>, response: Response<RecipeResponse>) {
                if (response.isSuccessful) {
                    data.value = response.body()!!.recipe
                }
            }

            override fun onFailure(call: Call<RecipeResponse>, t: Throwable) {

            }
        })
    }
}
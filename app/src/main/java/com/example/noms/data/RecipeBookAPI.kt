package com.example.noms.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface  RecipeBookAPI {

    @GET("/recipe_book")
    fun getRecipeBook(): Call<RecipeBookResponse>

    @GET("/recipe/{recipe_id}")
    fun getRecipe(@Path("recipe_id") recipe_id: String?): Call<RecipeResponse>

}
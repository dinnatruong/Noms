package com.example.noms.data

import com.example.noms.model.RecipeBook
import com.google.gson.annotations.SerializedName

class RecipeBookResponse {

    @SerializedName("recipeBook")
    val recipeBook: ArrayList<RecipeBook>? = null

}
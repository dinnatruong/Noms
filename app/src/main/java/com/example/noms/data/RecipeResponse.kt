package com.example.noms.data

import com.example.noms.model.Recipe
import com.google.gson.annotations.SerializedName

class RecipeResponse {

    @SerializedName("recipes")
    var recipes: ArrayList<Recipe>? = null

}
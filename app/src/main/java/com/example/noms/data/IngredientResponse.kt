package com.example.noms.data

import com.example.noms.model.Ingredient
import com.google.gson.annotations.SerializedName

class IngredientResponse {

    @SerializedName("ingredient")
    var ingredients: ArrayList<Ingredient>? = null

}
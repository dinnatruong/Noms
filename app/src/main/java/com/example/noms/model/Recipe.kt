package com.example.noms.model

import com.google.gson.annotations.SerializedName

class Recipe {

    @SerializedName("id")
    val id: Long? = null

    @SerializedName("title")
    val title: String? = null

    @SerializedName("image")
    val image: String? = null

    @SerializedName("ingredient")
    val ingredients: List<Ingredient>? = null

    @SerializedName("instructions")
    val instructions: String? = null

}
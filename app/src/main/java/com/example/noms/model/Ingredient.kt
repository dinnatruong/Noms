package com.example.noms.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Ingredient : Serializable {

    @SerializedName("title")
    val title: String? = null

    @SerializedName("quantity")
    val quantity: String? = null

    @SerializedName("unit")
    val unit: String? = null

}
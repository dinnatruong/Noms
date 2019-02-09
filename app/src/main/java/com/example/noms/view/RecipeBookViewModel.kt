package com.example.noms.view

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.noms.data.RecipeBookAPI
import com.example.noms.data.RecipeBookResponse
import com.example.noms.model.RecipeBook
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RecipeBookViewModel : ViewModel() {
    private val BASE_URL = "http://10.0.2.2:3000"
    private val data = MutableLiveData<ArrayList<RecipeBook>>()

    fun getRecipeBook() : MutableLiveData<ArrayList<RecipeBook>> {
        loadRecipeBook()
        return data
    }

    fun loadRecipeBook() {

        val retrofitService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val recipeBookAPI = retrofitService.create(RecipeBookAPI::class.java)

        val response = recipeBookAPI.getRecipeBook()

        response.enqueue(object : Callback<RecipeBookResponse> {
            override fun onResponse(call: Call<RecipeBookResponse>, response: Response<RecipeBookResponse>) {
                data.value = response.body()!!.recipeBook
            }

            override fun onFailure(call: Call<RecipeBookResponse>, t: Throwable) {

            }
        })
    }
}
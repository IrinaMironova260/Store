package com.example.store.data.api


import com.example.store.data.models.CategoriesApiModel
import com.example.store.data.models.ProductsApiModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("getCategories.php")
    fun getCategories(): Call<ArrayList<CategoriesApiModel>>

    @GET("getProducts.php")
    fun getProducts(): Call<ArrayList<ProductsApiModel>>
}
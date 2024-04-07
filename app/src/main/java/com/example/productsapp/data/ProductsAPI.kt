package com.example.productsapp.data

import com.example.productsapp.data.model.Products
import retrofit2.http.GET

interface ProductsAPI {

    // IO calls need to be launched inside Coroutines
    @GET("products")
    suspend fun getProductList(): Products

    // Base url
    companion object{
        const val BASE_URL = "https://dummyjson.com/"
    }
}
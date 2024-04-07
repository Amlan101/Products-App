package com.example.productsapp.data

import com.example.productsapp.data.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun getProductsList(): Flow<Result<List<Product>>>
}
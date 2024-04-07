package com.example.productsapp.data

import com.example.productsapp.data.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception

class ProductRepositoryImplementation(
    private var api: ProductsAPI
): ProductRepository {
    override suspend fun getProductsList(): Flow<Result<List<Product>>> {
        return flow {
            val productsFromApi = try{
                api.getProductList()
            } catch (e: IOException){
                e.printStackTrace()
                emit(Result.Error(message = "Error loading products: IO Exception occurred"))
                return@flow
            } catch (e: HttpException){
                e.printStackTrace()
                emit(Result.Error(message = "Error loading products: HTTP Exception occurred"))
                return@flow
            } catch (e: Exception){
                e.printStackTrace()
                emit(Result.Error(message = "Error loading products: General Exception occurred"))
                return@flow
            }
            emit(Result.Success(productsFromApi.products))
        }
    }

}
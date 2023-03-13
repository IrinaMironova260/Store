package com.example.store.data.repository.dataSource

import androidx.lifecycle.LiveData
import com.example.store.data.models.ProductsModel

interface ProductsDataSource {

    fun insert(productsModel: ProductsModel)

    fun getProducts(): LiveData<List<ProductsModel>>

    suspend fun clear()
}
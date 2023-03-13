package com.example.store.data.repository.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.store.data.models.ProductsModel
import com.example.store.data.repository.dataSource.ProductsApiDataSource
import com.example.store.data.repository.dataSource.ProductsDataSource
import com.example.store.domain.repository.ProductsCall

class ProductsRepository (private val productsApiDataSource: ProductsApiDataSource,
                          private val productsDataSource: ProductsDataSource
): ProductsCall {

    override fun getProducts(): LiveData<List<ProductsModel>> {
        return productsDataSource.getProducts()
    }

    override suspend fun startMigration(context: Context) {
        productsDataSource.clear()
        productsApiDataSource.startMigration(context)
    }

}
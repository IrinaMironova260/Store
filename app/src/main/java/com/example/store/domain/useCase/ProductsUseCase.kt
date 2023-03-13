package com.example.store.domain.useCase

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.store.data.models.ProductsModel
import com.example.store.domain.repository.ProductsCall

class ProductsUseCase (private val productsCall: ProductsCall) {

    fun getProducts(): LiveData<List<ProductsModel>> {
        return productsCall.getProducts()
    }

    suspend fun startMigration (context: Context) {
        productsCall.startMigration(context)
    }

}
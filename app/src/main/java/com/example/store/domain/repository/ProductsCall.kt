package com.example.store.domain.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.store.data.models.ProductsModel

interface ProductsCall {
    fun getProducts(): LiveData<List<ProductsModel>>

    suspend fun startMigration(context: Context)
}
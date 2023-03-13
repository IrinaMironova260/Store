package com.example.store.domain.useCase

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.store.data.models.CategoriesModel
import com.example.store.domain.repository.CategoriesCall

class CategoriesUseCase (private val categoriesCall: CategoriesCall) {

    fun loadCategories(): LiveData<List<CategoriesModel>> {
        return categoriesCall.getCategories()
    }

    suspend fun startMigration (context: Context) {
        categoriesCall.startMigration(context)
    }
}
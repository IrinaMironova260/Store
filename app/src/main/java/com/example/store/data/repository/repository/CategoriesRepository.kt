package com.example.store.data.repository.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.store.data.models.CategoriesModel
import com.example.store.data.repository.dataSource.CategoriesApiDataSource
import com.example.store.data.repository.dataSource.CategoriesDataSource
import com.example.store.domain.repository.CategoriesCall

class CategoriesRepository (private val categoriesApiDataSource: CategoriesApiDataSource,
                            private val categoriesDataSource: CategoriesDataSource
): CategoriesCall {

    override fun getCategories(): LiveData<List<CategoriesModel>> {
        return categoriesDataSource.getCategories()
    }

    override suspend fun startMigration(context: Context) {
        categoriesDataSource.clear()
        categoriesApiDataSource.startMigration(context)
    }
}
package com.example.store.data.repository.dataSource

import androidx.lifecycle.LiveData
import com.example.store.data.models.CategoriesModel

interface CategoriesDataSource {

    fun insert(categoriesModel: CategoriesModel)
    fun getCategories(): LiveData<List<CategoriesModel>>
    suspend fun clear()
}
package com.example.store.data.repository.dataSourceIMPL

import androidx.lifecycle.LiveData
import com.example.store.data.localDB.CategoriesDao
import com.example.store.data.models.CategoriesModel
import com.example.store.data.repository.dataSource.CategoriesDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoriesDataSourceIMPL (private val dao: CategoriesDao):
    CategoriesDataSource {


    override fun insert(categoriesModel: CategoriesModel) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.insert(categoriesModel)}
    }

    override fun getCategories(): LiveData<List<CategoriesModel>> {
        return dao.getCategories()
    }

    override suspend fun clear() {
        CoroutineScope(Dispatchers.IO).launch {
            dao.clear()}
    }
}
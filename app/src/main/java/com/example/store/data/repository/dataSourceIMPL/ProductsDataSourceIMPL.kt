package com.example.store.data.repository.dataSourceIMPL

import androidx.lifecycle.LiveData
import com.example.store.data.localDB.ProductsDao
import com.example.store.data.models.ProductsModel
import com.example.store.data.repository.dataSource.ProductsDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductsDataSourceIMPL (private val dao: ProductsDao):  ProductsDataSource {

       override fun insert(productsModel: ProductsModel) {
            CoroutineScope(Dispatchers.IO).launch {
                dao.insertProduct(productsModel)}
        }

    override fun getProducts(): LiveData<List<ProductsModel>> {
       return dao.getAllProducts()
    }

    override suspend fun clear() {
            CoroutineScope(Dispatchers.IO).launch {
                dao.clear()}
        }

    }
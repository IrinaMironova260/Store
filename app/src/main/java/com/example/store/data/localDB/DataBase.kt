package com.example.store.data.localDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.store.data.models.CategoriesModel
import com.example.store.data.models.ProductsModel

@Database(entities = [CategoriesModel::class, ProductsModel::class ], version = 1)
abstract class DataBase : RoomDatabase() {
    abstract val categoriesDao: CategoriesDao
    abstract val productsDao: ProductsDao
}
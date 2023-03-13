package com.example.store.data.localDB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.store.data.models.CategoriesModel

@Dao
interface CategoriesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(categoriesModel: CategoriesModel)

    @Query("SELECT * FROM categories_data_table")
    fun getCategories(): LiveData<List<CategoriesModel>>

    @Query("DELETE FROM categories_data_table")
    suspend fun clear()
}
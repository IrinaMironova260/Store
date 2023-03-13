package com.example.store.domain.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.store.data.models.CategoriesModel

interface CategoriesCall {

    fun getCategories(): LiveData<List<CategoriesModel>>

    suspend fun startMigration(context: Context)
}
package com.example.store.data.repository.dataSource

import android.content.Context

interface CategoriesApiDataSource {
    fun startMigration(context: Context)
}
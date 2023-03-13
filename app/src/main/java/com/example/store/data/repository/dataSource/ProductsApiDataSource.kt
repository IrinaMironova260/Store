package com.example.store.data.repository.dataSource

import android.content.Context

interface ProductsApiDataSource {
    fun startMigration(context: Context)
}
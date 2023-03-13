package com.example.store.presentation.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.store.domain.useCase.ProductsUseCase
import kotlinx.coroutines.launch

class ProductsViewModel(private val productsUseCase: ProductsUseCase):
    ViewModel() {

    val getProducts = productsUseCase.getProducts()

    fun migration(context: Context) = viewModelScope.launch {
        productsUseCase.startMigration(context)

    }
}
package com.example.store.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.store.R
import com.example.store.databinding.ActivityMainBinding
import com.example.store.presentation.viewModel.CategoriesViewModel
import com.example.store.presentation.viewModel.ProductsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    val categoriesViewModel: CategoriesViewModel by viewModel()
    val productsViewModel: ProductsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        categoriesViewModel.migration(this)
        productsViewModel.migration(this)

        supportFragmentManager.beginTransaction().replace(R.id.content, Home()).commit()

        binding?.bottomNav?.selectedItemId = R.id.homeItemBottomNav

        binding?.bottomNav?.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.homeItemBottomNav -> supportFragmentManager.beginTransaction()
                    .replace(R.id.content, Home()).commit()
                R.id.productsItemBottomNav -> supportFragmentManager.beginTransaction()
                    .replace(R.id.content, Products()).commit()
                R.id.categoriesItemBottomNav -> supportFragmentManager.beginTransaction()
                    .replace(R.id.content, Category()).commit()
            }
            return@setOnItemSelectedListener true
        }

    }
}
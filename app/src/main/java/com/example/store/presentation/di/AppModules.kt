package com.example.store.presentation.di

import androidx.room.Room
import com.example.store.data.localDB.DataBase
import com.example.store.data.repository.dataSource.CategoriesApiDataSource
import com.example.store.data.repository.dataSource.CategoriesDataSource
import com.example.store.data.repository.dataSource.ProductsApiDataSource
import com.example.store.data.repository.dataSource.ProductsDataSource
import com.example.store.data.repository.dataSourceIMPL.CategoriesApiDataSourceIMPL
import com.example.store.data.repository.dataSourceIMPL.CategoriesDataSourceIMPL
import com.example.store.data.repository.dataSourceIMPL.ProductsApiDataSourceIMPL
import com.example.store.data.repository.dataSourceIMPL.ProductsDataSourceIMPL
import com.example.store.data.repository.repository.CategoriesRepository
import com.example.store.data.repository.repository.ProductsRepository
import com.example.store.domain.repository.CategoriesCall
import com.example.store.domain.repository.ProductsCall
import com.example.store.domain.useCase.CategoriesUseCase
import com.example.store.domain.useCase.ProductsUseCase
import com.example.store.presentation.viewModel.CategoriesViewModel
import com.example.store.presentation.viewModel.ProductsViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val moduleCategories = module{
    single {
        Room.databaseBuilder(androidContext(), DataBase::class.java,
            "localDB").build()
    }
    single { get<DataBase>().categoriesDao }
    single<CategoriesDataSource> {
        CategoriesDataSourceIMPL(
            get()
        )}
    single<CategoriesApiDataSource> {
        CategoriesApiDataSourceIMPL(
            get()
        )}
    single<CategoriesCall> { CategoriesRepository(get(),get()) }
    single { CategoriesUseCase(get()) }
    viewModel { CategoriesViewModel(get()) }
}

val moduleProducts = module{

    single {
        Room.databaseBuilder(androidContext(), DataBase::class.java,
            "localDB").build()
    }

    single { get<DataBase>().productsDao }

    single<ProductsDataSource> {
        ProductsDataSourceIMPL(
            get()
        )}

    single<ProductsApiDataSource> {
        ProductsApiDataSourceIMPL(
            get()
        )}

    single<ProductsCall> { ProductsRepository(get(),get()) }
    single { ProductsUseCase(get()) }
    viewModel { ProductsViewModel(get()) }
}
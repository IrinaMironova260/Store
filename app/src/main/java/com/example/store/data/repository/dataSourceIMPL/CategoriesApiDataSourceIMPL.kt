package com.example.store.data.repository.dataSourceIMPL

import android.content.Context
import android.widget.Toast
import com.example.store.data.api.ApiClient
import com.example.store.data.models.CategoriesApiModel
import com.example.store.data.models.CategoriesModel
import com.example.store.data.repository.dataSource.CategoriesApiDataSource
import com.example.store.data.repository.dataSource.CategoriesDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoriesApiDataSourceIMPL (private val categoriesDataSource: CategoriesDataSource):
    CategoriesApiDataSource {

    override fun startMigration (context: Context) {

        val call = ApiClient.instance?.api?.getCategories()
        call?.enqueue(object: Callback<ArrayList<CategoriesApiModel>> {
            override fun onResponse(
                call: Call<ArrayList<CategoriesApiModel>>,
                response: Response<ArrayList<CategoriesApiModel>>
            ) {
                var getCategories: ArrayList<CategoriesApiModel>? = null
                getCategories?.clear()
                getCategories = (response.body() as ArrayList<CategoriesApiModel>?)!!
                for (audit in getCategories) {
                    audit.id?.let {
                        CategoriesModel(
                            it,
                            audit.name.toString(),
                            audit.image.toString()
                        )
                    }?.let {
                        categoriesDataSource.insert(
                            it
                        )
                    }
                }
                Toast.makeText(context, "ЗАГРУЗКА", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<ArrayList<CategoriesApiModel>>, t: Throwable) {
                Toast.makeText(context, "ОШИБКА! ВКЛЮЧИТЕ ИНТЕРНЕТ!", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
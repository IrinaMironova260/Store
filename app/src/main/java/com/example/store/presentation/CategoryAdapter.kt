package com.example.store.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.store.data.models.CategoriesModel
import com.example.store.databinding.CategoryItemBinding
import com.squareup.picasso.Picasso

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategoryHolder>() {

    private val categoriesList = ArrayList<CategoriesModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        val binding: CategoryItemBinding =
            CategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryHolder(binding)
    }

    override fun getItemCount(): Int {
        return categoriesList.size
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.bind(categoriesList[position])
    }

    fun setList(categories: List<CategoriesModel>) {
        categoriesList.clear()
        categoriesList.addAll(categories)
    }


    class CategoryHolder(val binding: CategoryItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            categories: CategoriesModel
        ) {
            val getImage = categories.image
            Picasso.get().load(getImage).into(binding.imageCategory)
            binding.idCategory.text = categories.id.toString()
            binding.nameCategory.text = categories.name
        }
    }
}
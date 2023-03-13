package com.example.store.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.store.databinding.FragmentCategoryBinding
import com.example.store.presentation.viewModel.CategoriesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class Category : Fragment() {

    private var binding:FragmentCategoryBinding? = null
    private var categoryAdapter: CategoryAdapter? = null
    val categoriesViewModel: CategoriesViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryBinding.inflate(inflater, container, false)
        initRecyclerCategories()
        loadCategories()
        return binding?.root
    }

    private fun initRecyclerCategories(){
        binding?.recyclerCategories?.layoutManager = LinearLayoutManager(context)
        categoryAdapter = CategoryAdapter()
        binding?.recyclerCategories?.adapter = categoryAdapter
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun loadCategories(){
        categoriesViewModel.loadCategories.observe(viewLifecycleOwner, Observer {
            categoryAdapter?.setList(it)
            categoryAdapter?.notifyDataSetChanged()
        })
    }

}
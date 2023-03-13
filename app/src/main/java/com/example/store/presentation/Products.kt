package com.example.store.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.store.databinding.FragmentProductsBinding
import com.example.store.presentation.viewModel.ProductsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class Products : Fragment() {

    private var binding: FragmentProductsBinding? = null
    private var productAdapter: ProductAdapter? = null
    val productsViewModel: ProductsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductsBinding.inflate(inflater, container, false)
        initRecyclerProducts()
        getProducts()
        return binding?.root
    }

    private fun initRecyclerProducts(){
        binding?.recyclerProducts?.layoutManager = LinearLayoutManager(context)
        productAdapter = ProductAdapter()
        binding?.recyclerProducts?.adapter = productAdapter

    }

    private fun getProducts(){
        productsViewModel.getProducts.observe(viewLifecycleOwner, Observer {
            productAdapter?.setList(it)
            productAdapter?.notifyDataSetChanged()
        })
    }
}
package com.nickoperea.inventariapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.nickoperea.inventariapp.R
import com.nickoperea.inventariapp.ui.adapters.ProductAdapter
import com.nickoperea.inventariapp.data.models.Product
import com.nickoperea.inventariapp.databinding.FragmentProductBinding
import com.nickoperea.inventariapp.ui.listeners.OnProductListener
import com.nickoperea.inventariapp.ui.viewmodels.ProductViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class ProductFragment : Fragment() {

    private var _binding: FragmentProductBinding? = null
    private val binding get() = _binding!!
    private lateinit var productAdapter: ProductAdapter
    private lateinit var productManager: GridLayoutManager
    private val productViewModel: ProductViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        productViewModel.products
        productAdapter = ProductAdapter(
            listOf()
        )

        productAdapter.listener = object: OnProductListener {
            override fun onClick(item: Product) {
                Log.d("PRODUCT", item.name!!)
                productViewModel.selectProduct(item)
                findNavController().navigate(R.id.action_productFragment_to_productDetailFragment)
            }
        }

        productManager = GridLayoutManager(requireContext(), 2)
        binding.productRecycler.apply {
            adapter = productAdapter
            layoutManager = productManager
        }
        observeViewModels()
    }

    private fun observeViewModels() {
        productViewModel.products.observe(viewLifecycleOwner, { products ->
            productAdapter.newDataSet(products)
        })
    }
}
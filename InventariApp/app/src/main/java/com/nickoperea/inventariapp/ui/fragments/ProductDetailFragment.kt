package com.nickoperea.inventariapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.nickoperea.inventariapp.R
import com.nickoperea.inventariapp.databinding.FragmentProductDetailBinding
import com.nickoperea.inventariapp.ui.viewmodels.ProductViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ProductDetailFragment : Fragment() {
    private var _binding: FragmentProductDetailBinding? = null
    private val binding get() = _binding!!
    private val productViewModel: ProductViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProductDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        observeViewModel()
    }

    private fun observeViewModel() {
        productViewModel.selected.observe(viewLifecycleOwner, { product ->
            binding.productDetailTitle.text = product.name
            binding.productDetailPrice.text = product.price.toString()
            binding.productDetailDescription.text = product.description
            Glide.with(binding.root).load(product.image).into(binding.productDetailImage)
        })
    }
}
package com.nickoperea.inventariapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.nickoperea.inventariapp.databinding.FragmentHomeBinding
import com.nickoperea.inventariapp.ui.viewmodels.StoreViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val storeViewModel: StoreViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        storeViewModel.loadInfo()
        observeViewModels()
    }

    private fun observeViewModels() {
        storeViewModel.info.observe(viewLifecycleOwner, {info ->
            binding.homeTitle.text = info.name
            binding.homeAdress.text = info.address
            binding.homeDescription.text = info.description
            Glide.with(binding.root).load(info.image).into(binding.homeImage)
        })
    }

}
package com.nickoperea.inventariapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.nickoperea.inventariapp.databinding.FragmentHomeBinding
import com.nickoperea.inventariapp.databinding.FragmentLoginBinding
import com.nickoperea.inventariapp.ui.viewmodels.StoreViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
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
        storeViewModel.loadData()
        observeViewModels()
    }

    private fun observeViewModels() {
        storeViewModel.data.observe(viewLifecycleOwner, Observer {info ->
            binding.homeTitle.text = info.name
            binding.homeAdress.text = info.address
            binding.homeDescription.text = info.description
            Glide.with(binding.root).load(info.image).into(binding.homeImage)
        })
    }

}
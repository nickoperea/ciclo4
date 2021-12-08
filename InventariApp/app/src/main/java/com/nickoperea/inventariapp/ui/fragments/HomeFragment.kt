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
import androidx.lifecycle.lifecycleScope
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions
import com.google.maps.android.ktx.awaitMap
import com.google.maps.android.ktx.awaitMapLoad
import com.nickoperea.inventariapp.R

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment()  {

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

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        mapFragment.getMapAsync(this)
//    }

    override fun onStart() {
        super.onStart()
        storeViewModel.loadData()
        observeViewModels()
    }

//    override fun onMapReady(p0: GoogleMap?) {
//        val ubication = Ubication()
//        val zoom= 16f
//        val centerMap = LatLng(ubication.latitude, ubication.longitude)
//        p0?.animateCamera(CameraUpdateFactory.newLatLngZoom(centerMap,zoom))
//    }

    private fun observeViewModels() {
        storeViewModel.data.observe(viewLifecycleOwner, {info ->
            binding.homeTitle.text = info.name
            binding.homeAdress.text = info.address
            binding.homeDescription.text = info.description
            Glide.with(binding.root).load(info.image).into(binding.homeImage)
            val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
            lifecycleScope.launchWhenStarted {
                val googleMap = mapFragment.awaitMap()
                googleMap.awaitMapLoad()
                val latLng = LatLng(info.latitude!!,info.longitude!!)
                googleMap.addMarker(
                    MarkerOptions()
                        .position(latLng)
                        .title(info.name!!)
                )

                val bounds = LatLngBounds.builder()
                    .include(latLng)
                    .build()
                googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 15))
            }
        })



    }

}
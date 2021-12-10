package com.nickoperea.inventariapp.ui.fragments

import android.Manifest.permission.CAMERA
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.nickoperea.inventariapp.databinding.FragmentProfileBinding
import com.nickoperea.inventariapp.ui.activities.MainActivity
import com.nickoperea.inventariapp.ui.viewmodels.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.lang.Exception

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private val loginViewModel: LoginViewModel by viewModel()

    private val REQUEST_CAMERA_PERMISSION = 1
    private val REQUEST_IMAGE = 2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        checkPermission()
        observerViewModels()
        loginViewModel.loggedIn()

        binding.profileImage.setOnClickListener {
            if (ContextCompat.checkSelfPermission(requireContext(), CAMERA) == PackageManager.PERMISSION_GRANTED){
                Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { intent ->
                    try {
                        startActivityForResult(intent, REQUEST_IMAGE )
                    } catch (e: Exception){

                    }


                }
            }
        }

        binding.profileLogOut.setOnClickListener {
            loginViewModel.logOut()
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(resultCode == Activity.RESULT_OK){
            if(requestCode == REQUEST_IMAGE){
                val bitmap = data?.extras?.get("data") as Bitmap
//                binding.profileImage.setImageBitmap(bitmap)
                loginViewModel.uploadImage(bitmap)
            }
        }
    }

    private fun observerViewModels(){
        loginViewModel.user.observe(viewLifecycleOwner, { user ->
            if (user != null) {
                binding.profileName.text = user.displayName
                if (user.photoUrl != null) {
                    Glide.with(binding.root).load(user.photoUrl).into(binding.profileImage)
                }
            } else {
                val intent = Intent(requireContext(), MainActivity::class.java)
                startActivity(intent)
                requireActivity().finish()
            }
        })
    }

    private fun checkPermission(){
        if(ContextCompat.checkSelfPermission(requireContext(), CAMERA) != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(requireActivity(), arrayOf(CAMERA), REQUEST_CAMERA_PERMISSION)
    }
}
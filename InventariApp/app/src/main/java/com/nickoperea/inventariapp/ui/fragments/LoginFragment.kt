package com.nickoperea.inventariapp.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.nickoperea.inventariapp.ui.activities.HomeActivity
import com.nickoperea.inventariapp.R
import com.nickoperea.inventariapp.databinding.FragmentLoginBinding
import com.nickoperea.inventariapp.isValidEmail

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.loginButton.setOnClickListener {
            var isValid = true

            if (!binding.LoginEmail.text.isValidEmail()){
                isValid = false
                binding.LoginEmailLayout.error = getString(R.string.required_email_field)
            }else{
                binding.LoginEmailLayout.error = null
            }

            if(binding.LoginPassword.text.toString().length < 4){
                isValid = false
                binding.LoginPasswordLayout.error = getString(R.string.required_password_field)
            }else {
                binding.LoginPasswordLayout.error = null
            }

            if(isValid) {
                startActivity(Intent(requireContext(), HomeActivity::class.java))
            }
        }
        binding.registerButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signupFragment)
        }
    }

}
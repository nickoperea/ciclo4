package com.nickoperea.inventariapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.nickoperea.inventariapp.databinding.FragmentLoginBinding

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
                binding.LoginEmailLayout.error = "correo electronico no valido"
            }else{
                binding.LoginEmailLayout.error = null
            }

            if(binding.LoginPassword.text.toString().length < 4){
                isValid = false
                binding.LoginPasswordLayout.error = "contraseña invalida"
            }else {
                binding.LoginPasswordLayout.error = null
            }

            if(isValid) {
                val intent = Intent(requireContext(), HomeActivity::class.java)
                startActivity(intent)
            }
        }
        binding.registrerButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signupFragment)
        }
    }

}
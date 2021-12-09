package com.nickoperea.inventariapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.nickoperea.inventariapp.R
import com.nickoperea.inventariapp.databinding.FragmentSignupBinding
import com.nickoperea.inventariapp.ui.viewmodels.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 * Use the [SignupFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignupFragment : Fragment() {

    private var _binding: FragmentSignupBinding? = null
    private val binding get() = _binding!!
    private val loginViewModel: LoginViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        observeViewModels()
        binding.registrerSignupButton.setOnClickListener {
            findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
        }
        binding.signupButton.setOnClickListener {
            loginViewModel.signUp(binding.SignUpEmail.text.toString(), binding.SignUpUsername.text.toString(),
                binding.SignUpPassword.text.toString())
        }
    }

    private fun observeViewModels() {
        loginViewModel.user.observe(viewLifecycleOwner, Observer { user ->
            if (user != null){
                findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
            }
        })
    }
}
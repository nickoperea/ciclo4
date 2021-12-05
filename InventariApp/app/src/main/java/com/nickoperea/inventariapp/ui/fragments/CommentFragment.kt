package com.nickoperea.inventariapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.nickoperea.inventariapp.databinding.FragmentCommentBinding
import com.nickoperea.inventariapp.ui.adapters.CommentAdapter
import com.nickoperea.inventariapp.ui.viewmodels.CommentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class CommentFragment : Fragment() {

    private var _binding: FragmentCommentBinding? = null
    private val binding get() = _binding!!
    private lateinit var commentAdapter: CommentAdapter
    private lateinit var commentManager: LinearLayoutManager
    private val commentViewModel: CommentViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCommentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        commentViewModel.loadComments()
        commentAdapter = CommentAdapter(
            listOf()
        )

        commentManager = LinearLayoutManager(requireContext())
        binding.commentRecycler.apply {
            adapter = commentAdapter
            layoutManager = commentManager
        }
        observeViewModels()
    }

    private fun observeViewModels() {
        commentViewModel.comments.observe(viewLifecycleOwner, { comments ->
            commentAdapter.newDataSet(comments)
        })
    }
}
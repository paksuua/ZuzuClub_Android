package com.stock.sns.zuzuclub_android.ui.post

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.stock.sns.zuzuclub_android.databinding.FragmentPostBinding

class PostFragment : Fragment() {
    private val viewModel by viewModels<PostViewModel>()
    private val binding by lazy { FragmentPostBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.text.observe(
            viewLifecycleOwner,
            Observer {
                binding.tvPost.text = it
            }
        )
        return binding.root
    }
}

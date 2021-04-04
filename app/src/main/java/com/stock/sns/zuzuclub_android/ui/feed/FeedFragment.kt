package com.stock.sns.zuzuclub_android.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.stock.sns.zuzuclub_android.databinding.FragmentFeedBinding

class FeedFragment : Fragment() {
    private val binding by lazy { FragmentFeedBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<FeedViewModel>()

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
            {
                //binding.tvFeed.text = it
            }
        )
        return binding.root
    }
}

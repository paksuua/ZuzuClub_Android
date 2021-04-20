package com.stock.sns.zuzuclub_android.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.stock.sns.zuzuclub_android.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private val viewModel by viewModels<SearchViewModel>()
    private val binding by lazy { FragmentSearchBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return binding.root
    }

}
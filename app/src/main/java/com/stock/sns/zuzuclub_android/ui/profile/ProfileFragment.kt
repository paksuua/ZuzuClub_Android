package com.stock.sns.zuzuclub_android.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.stock.sns.zuzuclub_android.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private val viewModel by viewModels<ProfileViewModel>()
    private val binding by lazy { FragmentProfileBinding.inflate(layoutInflater) }

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
                binding.tvProfile.text = it
            }
        )
        return binding.root
    }
}

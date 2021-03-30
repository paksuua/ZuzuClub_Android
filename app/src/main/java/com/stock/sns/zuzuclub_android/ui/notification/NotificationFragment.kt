package com.stock.sns.zuzuclub_android.ui.notification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.stock.sns.zuzuclub_android.databinding.FragmentNotificationBinding

class NotificationFragment : Fragment() {
    private val binding by lazy { FragmentNotificationBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<NofiticationViewModel>()

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
                binding.tvNotification.text = it
            }
        )
        return binding.root
    }
}

package com.stock.sns.zuzuclub_android.ui.feed.list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.stock.sns.zuzuclub_android.R

class AllFragment : Fragment() {

    companion object {
        fun newInstance() = AllFragment()
    }

    private lateinit var viewModel: AllViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_all_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AllViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
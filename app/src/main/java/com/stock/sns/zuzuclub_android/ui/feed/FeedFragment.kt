package com.stock.sns.zuzuclub_android.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.stock.sns.zuzuclub_android.data.model.Feed
import com.stock.sns.zuzuclub_android.databinding.FragmentFeedBinding

class FeedFragment : Fragment() {
    private val binding by lazy { FragmentFeedBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<FeedViewModel>()
    var data = MutableLiveData<ArrayList<Feed>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //binding.fFeedTablayout.addOnTabSelectedListener(viewModel.onTabSelectedListener)
        binding.fFeedRcvList.layoutManager = LinearLayoutManager(context)

        //viewmodel의 값 바뀌면 livedata 로직 실행
        val dataObserver: Observer<ArrayList<Feed>> =
            Observer { livedata ->
                data.value = livedata
                binding.fFeedRcvList.adapter = FeedRecyclerAdapter(data)
            }
        viewModel.feedData.observe(
            viewLifecycleOwner, dataObserver
        )

//        viewModel.text.observe(
//            viewLifecycleOwner,
//            {
//                //binding.tvFeed.text = it
//            }
//        )
        return binding.root
    }
}

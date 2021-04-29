package com.stock.sns.zuzuclub_android.ui.feedpost

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.stock.sns.zuzuclub_android.data.model.Comment
import com.stock.sns.zuzuclub_android.data.model.Feed
import com.stock.sns.zuzuclub_android.databinding.ActivityFeedPostBinding

class FeedPostActivity : AppCompatActivity() {
    private val viewModel by viewModels<FeedPostViewModel>()
    private lateinit var binding: ActivityFeedPostBinding
    var commentData = MutableLiveData<ArrayList<Comment>>()
    var postData = MutableLiveData<Feed>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeedPostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataObserver: Observer<ArrayList<Comment>> =
            Observer { livedata ->
                commentData.value = livedata
            }
        val postObserver: Observer<Feed> =
            Observer { livedata ->
                postData.value = livedata
            }
        binding.aFeedpostRcvList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = FeedPostRecyclerAdapter(commentData, postData)
        }
        viewModel.commentData.observe(
            this, dataObserver
        )
        viewModel.postData.observe(
            this, postObserver
        )
    }
}

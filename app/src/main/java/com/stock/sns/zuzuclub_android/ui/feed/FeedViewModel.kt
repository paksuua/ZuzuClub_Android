package com.stock.sns.zuzuclub_android.ui.feed

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayout
import com.stock.sns.zuzuclub_android.R
import com.stock.sns.zuzuclub_android.data.model.Feed
import com.stock.sns.zuzuclub_android.data.model.getDefaultFeedList
import com.volokh.danylo.hashtaghelper.HashTagHelper


class FeedViewModel : ViewModel() {
//
//    private val _text = MutableLiveData<String>().apply {
//        value = "This is feed Fragment"
//    }
//    val text: LiveData<String> = _text

    val feedData: MutableLiveData<ArrayList<Feed>> = MutableLiveData()


    init {
        var demoData = getDefaultFeedList()
        feedData.postValue(demoData)
    }


    fun getListItem(pos: Int) {

    }

    var onTabSelectedListener = object : TabLayout.OnTabSelectedListener {
        override fun onTabSelected(tab: TabLayout.Tab?) {
            tab?.position.let { position ->
                if (position != null) {
                    getListItem(position)
                }
            }
        }

        override fun onTabUnselected(tab: TabLayout.Tab?) {
        }

        override fun onTabReselected(tab: TabLayout.Tab?) {
        }

    }
}

@BindingAdapter("profileImage")
fun getProfileImage(view: ImageView, url: String) {
    Glide.with(view.context).load(url).placeholder(R.drawable.non_profile).centerCrop().into(view)
}

@BindingAdapter("emojiType")
fun getEmojiImage(view: ImageView, type: Int) {
    when (type) {
        0 -> {
            view.visibility = View.GONE
        }
        1 -> {
            view.setImageResource(R.drawable.flex_fox_72)
        }
        2 -> {
            view.setImageResource(R.drawable.sad_lion_72)
        }
        3 -> {
            view.setImageResource(R.drawable.expect_rabbit_72)
        }
        4 -> {
            view.setImageResource(R.drawable.nervous_horse_72)
        }
    }
}

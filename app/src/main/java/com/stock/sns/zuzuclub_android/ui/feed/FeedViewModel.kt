package com.stock.sns.zuzuclub_android.ui.feed

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener
import com.stock.sns.zuzuclub_android.data.model.Feed
import com.stock.sns.zuzuclub_android.data.model.getDefaultFeedList

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


    fun getListItem(pos: Int){

    }

    var onTabSelectedListener = object : TabLayout.OnTabSelectedListener {
        override fun onTabSelected(tab: TabLayout.Tab?) {
            tab?.position.let {position ->
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
fun getImg(view: ImageView, url: String) {
    Glide.with(view.context).load(url).centerCrop().into(view)
}
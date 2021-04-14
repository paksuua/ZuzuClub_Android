package com.stock.sns.zuzuclub_android.ui.feed

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayout
import com.stock.sns.zuzuclub_android.R
import com.stock.sns.zuzuclub_android.data.model.Feed
import com.stock.sns.zuzuclub_android.data.model.getDefaultFeedList

class FeedViewModel : ViewModel() {
//
//    private val _text = MutableLiveData<String>().apply {
//        value = "This is feed Fragment"
//    }
//    val text: LiveData<String> = _text

    val feedData: MutableLiveData<ArrayList<Feed>> = MutableLiveData()
    var tempList: ArrayList<Feed> = getDefaultFeedList()

    init {
        cutoffText() // 글자수 잘라서 더보기 붙
        feedData.postValue(tempList)
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

    fun cutoffText() { // 야매로 글자 잘라버리기
        for (i in tempList) {
            if (i.text.length > 150) {
                i.text = i.text.substring(0, 150)
                i.text = i.text + " ...더 보기"
            }
        }
    }
}

@BindingAdapter("profileImage")
fun getProfileImage(view: ImageView, url: String) {
    Glide.with(view.context).load(url).placeholder(R.drawable.non_profile).centerCrop().into(view)
}

@BindingAdapter("feedImage")
fun getFeedImage(view: ImageView, url: String) {
    if (url != "") {
        view.visibility = View.VISIBLE
        Glide.with(view.context).load(url).placeholder(R.drawable.expect_rabbit_96).centerCrop().into(view)
    } else view.visibility = View.GONE
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

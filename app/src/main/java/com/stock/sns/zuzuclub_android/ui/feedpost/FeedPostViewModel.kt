package com.stock.sns.zuzuclub_android.ui.feedpost

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stock.sns.zuzuclub_android.data.model.Comment
import com.stock.sns.zuzuclub_android.data.model.Feed
import com.stock.sns.zuzuclub_android.data.model.getDefaultComment
import com.stock.sns.zuzuclub_android.data.model.getDefaultFeedList

class FeedPostViewModel : ViewModel() {

    val commentData: MutableLiveData<ArrayList<Comment>> = MutableLiveData()
    val postData: MutableLiveData<Feed> = MutableLiveData()
    var tempList: ArrayList<Comment> = getDefaultComment() // 데모데이터
    var tempPost: Feed = getDefaultFeedList()[0]

    init {
        Log.e("feed post vm","init")
        commentData.postValue(tempList)
        postData.postValue(tempPost)
    }
}

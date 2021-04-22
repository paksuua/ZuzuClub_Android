package com.stock.sns.zuzuclub_android.ui.home.hotranking

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stock.sns.zuzuclub_android.data.model.*

class HotRankingViewModel : ViewModel() {

    val hotRankingData: MutableLiveData<ArrayList<HotRankingData>> = MutableLiveData()

    init {
        var hotStockDummyData = getDummyHotRanking()
        hotRankingData.postValue(hotStockDummyData)
    }
}

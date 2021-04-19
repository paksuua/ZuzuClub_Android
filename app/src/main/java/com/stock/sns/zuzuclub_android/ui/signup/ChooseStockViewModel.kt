package com.stock.sns.zuzuclub_android.ui.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stock.sns.zuzuclub_android.data.model.InterestData
import com.stock.sns.zuzuclub_android.data.model.getDummyMainInterestList

class ChooseStockViewModel : ViewModel() {
    private var _interestStock = MutableLiveData<ArrayList<InterestData>>()
    val interestStock : ArrayList<InterestData> = getDummyMainInterestList()

    init {
        interestStock.add(InterestData(1, "삼성전자"))
        interestStock.add(InterestData(1,"데브시스터즈"))
        interestStock.add(InterestData(1,"뱅크샐러드"))
        interestStock.add(InterestData(1,"효성ITX"))
        interestStock.add(InterestData(1,"NAVER"))
        interestStock.add(InterestData(1,"현대차"))
        interestStock.add(InterestData(1,"한화생명"))
        interestStock.add(InterestData(1,"SK이노베이션"))
        interestStock.add(InterestData(1,"동원시스템즈"))
        interestStock.add(InterestData(1,"HMM"))
        interestStock.add(InterestData(1, "삼성전자"))
        interestStock.add(InterestData(1,"데브시스터즈"))
        interestStock.add(InterestData(1,"뱅크샐러드"))
        interestStock.add(InterestData(1,"효성ITX"))
        interestStock.add(InterestData(1,"NAVER"))
        interestStock.add(InterestData(1,"현대차"))
        interestStock.add(InterestData(1,"한화생명"))
        interestStock.add(InterestData(1,"SK이노베이션"))
        interestStock.add(InterestData(1,"동원시스템즈"))
        interestStock.add(InterestData(1,"HMM"))
        _interestStock.postValue(interestStock)
    }

}
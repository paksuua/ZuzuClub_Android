package com.stock.sns.zuzuclub_android.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stock.sns.zuzuclub_android.data.model.*

class HomeViewModel : ViewModel() {

    val weatherData: MutableLiveData<WeatherData> = MutableLiveData()

    val hotStockData: MutableLiveData<ArrayList<HotData>> = MutableLiveData()
    val interestStockData: MutableLiveData<ArrayList<InterestData>> = MutableLiveData()

    init {
        var weatherDummyData = getDummyWeather()
        weatherData.postValue(weatherDummyData)

        var hotStockDummyData = getDummyMainHotList()
        hotStockData.postValue(hotStockDummyData)

        var interestStockDummyData = getDummyMainInterestList()
        interestStockData.postValue(interestStockDummyData)
    }
}

package com.stock.sns.zuzuclub_android.data.model

data class WeatherData(
    val weatherType: Int, // 맑음 1, 비 2, 선선 3, 흐림 4
    val figure: Int
)

fun getDummyWeather(): WeatherData {
    return WeatherData(
        weatherType = 1,
        figure = 72
    )
}
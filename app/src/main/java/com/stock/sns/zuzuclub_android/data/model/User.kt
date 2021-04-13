package com.stock.sns.zuzuclub_android.data.model

data class User(
    var nickname : String,
    var introduce : String,
    var interestStock : ArrayList<InterestData>,
    var accessToken : String,
    var refreshToken : String
)
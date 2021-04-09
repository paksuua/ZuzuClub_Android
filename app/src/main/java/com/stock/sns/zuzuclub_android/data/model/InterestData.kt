package com.stock.sns.zuzuclub_android.data.model

data class InterestData(
    val emojiType: Int, // 여우 1, 사자 2, 토끼 3, 말 4
    val name: String
)

fun getDummyMainInterestList() = arrayListOf(
    InterestData(
        emojiType = 1,
        name = "카카오"
    ),
    InterestData(
        emojiType = 2,
        name = "SK하이닉스"
    ),
    InterestData(
        emojiType = 3,
        name = "LG전자"
    ),
    InterestData(
        emojiType = 1,
        name = "메디톡스"
    ),
    InterestData(
        emojiType = 4,
        name = "삼성SDI"
    ),
    InterestData(
        emojiType = 2,
        name = "씨젠"
    )
)
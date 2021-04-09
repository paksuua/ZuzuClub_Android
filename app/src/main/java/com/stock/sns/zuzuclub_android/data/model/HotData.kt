package com.stock.sns.zuzuclub_android.data.model

data class HotData(
    val emojiType: Int, // 여우 1, 사자 2, 토끼 3, 말 4
    val name: String,
    val desc: String
)

fun getDummyMainHotList() = arrayListOf(
    HotData(
        emojiType = 1,
        name = "카카오",
        desc = "FLEX 축제를 벌이고 있는 종목!"
    ),
    HotData(
        emojiType = 2,
        name = "SK하이닉스",
        desc = "피눈물을 흘리고 있는 종목!"
    ),
    HotData(
        emojiType = 3,
        name = "LG전자",
        desc = "드릉드릉 기대되는 종목!"
    ),
    HotData(
        emojiType = 4,
        name = "메디톡스",
        desc = "나락가는걸까? 아슬아슬한 종목!"
    )
)
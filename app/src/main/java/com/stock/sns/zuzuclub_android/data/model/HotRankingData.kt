package com.stock.sns.zuzuclub_android.data.model

data class HotRankingData(
    val ranking: String,
    val stock: String
)

fun getDummyHotRanking() = arrayListOf(
    HotRankingData(
        ranking = "1위",
        stock = "카카오"
    ),
    HotRankingData(
        ranking = "2위",
        stock = "SK하이닉스"
    ),
    HotRankingData(
        ranking = "3위",
        stock = "삼성전자"
    ),
    HotRankingData(
        ranking = "4위",
        stock = "메디톡스"
    ),
    HotRankingData(
        ranking = "5위",
        stock = "네이버"
    ),
    HotRankingData(
        ranking = "6위",
        stock = "SM Life&Design"
    ),
    HotRankingData(
        ranking = "7위",
        stock = "아이젠"
    ),
    HotRankingData(
        ranking = "8위",
        stock = "LG전자"
    ),
    HotRankingData(
        ranking = "9위",
        stock = "진에어"
    ),
    HotRankingData(
        ranking = "10위",
        stock = "한진"
    )
)

// data class HotRankingData(
//    val ranking: Int,
//    val stock: String
// )
//
// fun getDummyHotRanking() = arrayListOf(
//    HotRankingData(
//        ranking = 1,
//        stock = "카카오"
//    ),
//    HotRankingData(
//        ranking = 2,
//        stock = "SK하이닉스"
//    ),
//    HotRankingData(
//        ranking = 3,
//        stock = "삼성전자"
//    ),
//    HotRankingData(
//        ranking = 4,
//        stock = "메디톡스"
//    ),
//    HotRankingData(
//        ranking = 5,
//        stock = "네이버"
//    ),
//    HotRankingData(
//        ranking = 6,
//        stock = "SM Life&Design"
//    ),
//    HotRankingData(
//        ranking = 7,
//        stock = "아이젠"
//    ),
//    HotRankingData(
//        ranking = 8,
//        stock = "LG전자"
//    ),
//    HotRankingData(
//        ranking = 9,
//        stock = "진에어"
//    ),
//    HotRankingData(
//        ranking = 10,
//        stock = "한진"
//    )
// )
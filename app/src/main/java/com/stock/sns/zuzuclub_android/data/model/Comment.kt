package com.stock.sns.zuzuclub_android.data.model

data class Comment(
    var profileImage: String,
    var nickname: String,
    var updated: String,
    var text: String,
    var countAction: Int
)

fun getDefaultComment() = arrayListOf(
    Comment("", "방배동살쾡이", "3시간 전", "드가자드가자~", 2),
    Comment("", "방배동살쾡이", "2시간 전", "드가자드가자~", 2),
    Comment("", "방배동고양이", "2시간 전", "@방배동살쾡이 시작하자~", 2),
    Comment("", "방배동살쾡이", "2시간 전", "드가자드가자~", 1)
)

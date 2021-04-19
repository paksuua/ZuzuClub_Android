package com.stock.sns.zuzuclub_android.data

import android.os.Parcelable
import com.stock.sns.zuzuclub_android.R
import kotlinx.android.parcel.Parcelize

@Parcelize
enum class EmojiPackage(val value: String) : Parcelable {
    BASIC1("basic1"), BASIC2("basic2")
}

fun EmojiPackage.toTitle(): String {
    return when (this) {
        EmojiPackage.BASIC1 -> "기본 1"
        EmojiPackage.BASIC2 -> "기본 2"
    }
}

fun EmojiPackage.toEmojiList(): List<Int> {
    return when (this) {
        EmojiPackage.BASIC1
        -> listOf(
            R.drawable.flex_fox_72,
            R.drawable.sad_lion_72,
            R.drawable.expect_rabbit_72,
            R.drawable.nervous_horse_72
        )
        EmojiPackage.BASIC2
        -> listOf(
            R.drawable.nervous_horse_72,
            R.drawable.expect_rabbit_72,
            R.drawable.sad_lion_72,
            R.drawable.flex_fox_72
        )
    }
}
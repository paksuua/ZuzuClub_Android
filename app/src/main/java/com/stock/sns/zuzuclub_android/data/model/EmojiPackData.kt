package com.stock.sns.zuzuclub_android.data.model

import androidx.annotation.DrawableRes
import com.stock.sns.zuzuclub_android.R
import com.stock.sns.zuzuclub_android.data.EmojiPackage
import java.util.*

data class EmojiPackData(
    val emojiPack: EmojiPackage,
    var isSelected: Boolean
) {
    @DrawableRes
    fun getDummyPostEmojiList(): List<Int> {
        return when (emojiPack) {
            EmojiPackage.BASIC1 -> listOf(
                R.drawable.nervous_horse_72,
                R.drawable.expect_rabbit_72,
                R.drawable.sad_lion_72,
                R.drawable.flex_fox_72
            )
            EmojiPackage.BASIC2 -> listOf(
                R.drawable.nervous_horse_72,
                R.drawable.expect_rabbit_72,
                R.drawable.sad_lion_72,
                R.drawable.flex_fox_72
            )
        }
    }

    fun getTitle(): CharSequence {
        return when (emojiPack) {
            EmojiPackage.BASIC1 -> "기본 1"
            EmojiPackage.BASIC2 -> "기본 2"
        }
    }
}
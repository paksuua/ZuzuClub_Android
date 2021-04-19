package com.stock.sns.zuzuclub_android.ui.post

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.stock.sns.zuzuclub_android.data.EmojiPackage
import com.stock.sns.zuzuclub_android.data.model.*
import com.stock.sns.zuzuclub_android.util.SingleLiveEvent

class PostViewModel : ViewModel() {
    val interestStockData: MutableLiveData<ArrayList<InterestData>> = MutableLiveData()
    val emojisData: MutableLiveData<List<Int>> = MutableLiveData()

    private val _pack: MutableLiveData<EmojiPackage> = MutableLiveData(EmojiPackage.BASIC1)
    val pack: LiveData<EmojiPackage> = _pack

    val packageItemHolder: LiveData<List<EmojiPackData>> = _pack.map { selected ->
        PACKAGE.map { EmojiPackData(it, isSelected = it == selected) }
    }

    private val _showPackageTitle: SingleLiveEvent<EmojiPackData> = SingleLiveEvent()
    val showPackageTitle: LiveData<EmojiPackData> = _showPackageTitle

    fun onChangeSelectedPackage(itemHolder: EmojiPackData) {
        when (itemHolder.emojiPack) {
            EmojiPackage.BASIC1 -> {
                _showPackageTitle.postValue(itemHolder)
                emojisData.postValue(itemHolder.getDummyPostEmojiList())
            }
            else -> {
                _pack.postValue(itemHolder.emojiPack)
                emojisData.postValue(itemHolder.getDummyPostEmojiList())
            }
        }
    }

    companion object {
        private val PACKAGE = listOf(
            EmojiPackage.BASIC1,
            EmojiPackage.BASIC2
        )
    }
}

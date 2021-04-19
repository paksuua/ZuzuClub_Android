package com.stock.sns.zuzuclub_android.ui.signup

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.stock.sns.zuzuclub_android.R

class SignUpViewModel : ViewModel() {
    private var _isAvailable = MutableLiveData<Boolean>(false)
    val isAvailable: LiveData<Boolean> = _isAvailable

    private val _nickname = MutableLiveData<String>()
    val nickname: LiveData<String> = _nickname

    private val _introduce = MutableLiveData<String>()
    val introduce: LiveData<String> = _introduce

    fun isAvailableNickname() {
        _isAvailable.value = _isAvailable.value == false
    }
}
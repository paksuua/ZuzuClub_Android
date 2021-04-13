package com.stock.sns.zuzuclub_android.ui.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel() {
    private var _isAvailable = MutableLiveData<Boolean>()
    val isAvailable : LiveData<Boolean> = _isAvailable

    private val _nickname = MutableLiveData<String>()
    val nickname : LiveData<String> = _nickname

    private val _introduce = MutableLiveData<String>()
    val introduce : LiveData<String> = _introduce

    init {
        _isAvailable.value = false
    }

    fun isAvailableNickname(){
        _isAvailable.value = _isAvailable.value == false
    }
}
package com.stock.sns.zuzuclub_android.ui.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel() {
    private var _isAvailable = MutableLiveData<Boolean>(false)
    val isAvailable: LiveData<Boolean> = _isAvailable

    private val _nickname = MutableLiveData<String>()
    val nickname: LiveData<String> = _nickname

    private var _isActivated = MutableLiveData<Boolean>(false)
    val isActivated: LiveData<Boolean> = _isActivated

    private val _introduce = MutableLiveData<String>()
    val introduce: LiveData<String> = _introduce

    fun isAvailableNickname() {
        _isAvailable.value = _isAvailable.value == false
    }

    fun isActivatedState(){
        _isActivated.value = _isActivated.value == false
    }
}
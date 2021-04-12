package com.stock.sns.zuzuclub_android.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel(){
    private val _token = MutableLiveData<String>()
    val token : MutableLiveData<String> = _token
}
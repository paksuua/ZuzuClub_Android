package com.stock.sns.zuzuclub_android.ui.notification

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NofiticationViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is notification Fragment"
    }
    val text: LiveData<String> = _text
}

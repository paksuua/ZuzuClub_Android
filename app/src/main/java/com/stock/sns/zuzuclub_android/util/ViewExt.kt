package com.stock.sns.zuzuclub_android.util

import android.widget.CheckedTextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.distinctUntilChanged
import androidx.lifecycle.observe

fun CheckedTextView.bindChecked(owner: LifecycleOwner, liveData: LiveData<Boolean>) {
    liveData.distinctUntilChanged().observe(
        owner,
        {
            this.isChecked = it
        }
    )
}
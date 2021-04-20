package com.stock.sns.zuzuclub_android.util

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

class SimpleDiffUtilCallback<T : Any> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }
}
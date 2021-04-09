package com.stock.sns.zuzuclub_android.util.autolink

data class AutoLinkItem(var startPoint: Int,
                        var endPoint: Int,
                        val originalText: String,
                        val transformedText: String,
                        val mode: Mode)
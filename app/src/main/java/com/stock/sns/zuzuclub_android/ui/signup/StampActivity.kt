package com.stock.sns.zuzuclub_android.ui.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.stock.sns.zuzuclub_android.databinding.ActivityStampBinding
import com.stock.sns.zuzuclub_android.ui.MainActivity

class StampActivity : AppCompatActivity() {
    val binding by lazy { ActivityStampBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.aStampTvNext.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
    }
}
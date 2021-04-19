package com.stock.sns.zuzuclub_android.ui.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.stock.sns.zuzuclub_android.databinding.ActivityChooseStockBinding

class ChooseStockActivity : AppCompatActivity() {
    private val binding by lazy { ActivityChooseStockBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<ChooseStockViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initClickListener()

        binding.aChooseStockRcv.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = ChooseStockAdapter(viewModel.interestStock)
        }
    }

    private fun initClickListener() {
        val intent = Intent(this, StampActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        binding.aChooseStockTvNext.setOnClickListener {
            startActivity(intent)
        }
        binding.aChooseStockTvSkip.setOnClickListener {
            startActivity(intent)
        }
    }
}
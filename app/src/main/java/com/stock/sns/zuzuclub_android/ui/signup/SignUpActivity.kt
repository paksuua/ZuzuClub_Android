package com.stock.sns.zuzuclub_android.ui.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.stock.sns.zuzuclub_android.R
import com.stock.sns.zuzuclub_android.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySignUpBinding.inflate(layoutInflater)}
    private val viewModel by viewModels<SignUpViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            viewModel = viewModel
            lifecycleOwner = this@SignUpActivity
        }
        setContentView(binding.root)
        initViewModel()
        initClickListener()
    }

    private fun initViewModel(){
        viewModel.isAvailable.observe(this, Observer {
            binding.aSignupTvNext.isEnabled = it
            if(it){
                binding.aSignupTvNext.setBackgroundColor(getColor(R.color.zuzu_orange))
                binding.aSignupTvNext.setTextColor(getColor(R.color.zuzu_white))
            }else{
                binding.aSignupTvNext.setBackgroundColor(getColor(R.color.zuzu_coolgrey_10))
                binding.aSignupTvNext.setTextColor(getColor(R.color.zuzu_black_20))
            }
        })
    }

    private fun initClickListener(){
        binding.aSignupBtnCancel.setOnClickListener { finish() }
        binding.aSignupTvNicknameCheck.setOnClickListener { viewModel.isAvailableNickname() }
        binding.aSignupTvNext.setOnClickListener { startActivity(Intent(this, TermsActivity::class.java)) }
    }
}
package com.stock.sns.zuzuclub_android.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.stock.sns.zuzuclub_android.R
import com.stock.sns.zuzuclub_android.databinding.ActivityLoginBinding
import com.stock.sns.zuzuclub_android.ui.signup.SignUpActivity

class LoginActivity : AppCompatActivity() {
    private val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<LoginViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initButtonListener()
    }

    private fun initButtonListener() {
        binding.aLoginBtnGoogleLogin.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    SignUpActivity::class.java
                )
            )
        }

        binding.aLoginBtnNaverLogin.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    SignUpActivity::class.java
                )
            )
        }
    }

}
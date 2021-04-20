package com.stock.sns.zuzuclub_android.ui.signup

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.stock.sns.zuzuclub_android.R
import com.stock.sns.zuzuclub_android.databinding.ActivitySignUpBinding
import java.util.*

class SignUpActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySignUpBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<SignUpViewModel>()
    private lateinit var dialog: Dialog
    private lateinit var imageDialogEmotion: ImageView
    private lateinit var textDialogTitle: TextView
    private lateinit var textDialogContent: TextView
    private lateinit var btnOK: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            viewModel = viewModel
            lifecycleOwner = this@SignUpActivity
        }
        setContentView(binding.root)
        initViewModel()
        initNicknameDialog()
        initClickListener()
    }

    private fun initViewModel() {
        viewModel.isAvailable.observe(this, Observer {
            binding.aSignupTvNext.isEnabled = it
            if (it) {
                binding.aSignupTvNext.setBackgroundColor(getColor(R.color.zuzu_orange))
                binding.aSignupTvNext.setTextColor(getColor(R.color.zuzu_white))
            } else {
                binding.aSignupTvNext.setBackgroundColor(getColor(R.color.zuzu_coolgrey_10))
                binding.aSignupTvNext.setTextColor(getColor(R.color.zuzu_black_20))
            }
        })

        viewModel.isActivated.observe(this, Observer {
            binding.aSignupTvNicknameCheck.isEnabled = it
        })
    }

    private fun initClickListener() {
        binding.aSignupBtnCancel.setOnClickListener { finish() }
        binding.aSignupEtNickname.setOnFocusChangeListener { _, _ ->
            viewModel.isActivatedState()
        }
        binding.aSignupTvNicknameCheck.setOnClickListener {
            viewModel.isAvailableNickname()
            loadNicknameDialog()
        }
        binding.aSignupTvNext.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    TermsActivity::class.java
                )
            )
        }
    }

    private fun loadNicknameDialog() {
        if (binding.aSignupTvNext.isEnabled) {
            textDialogContent.text = "사용할 수 있는 닉네임입니다."
            Glide.with(this)
                .load(R.drawable.dialog_emotion_funny)
                .apply(RequestOptions()
                    .placeholder(R.drawable.dialog_emotion_funny))
                .into(imageDialogEmotion)
        } else {
            textDialogContent.text = "사용할 수 없는 닉네임입니다."
            Glide.with(this)
                .load(R.drawable.dialog_emotion_sad)
                .apply(RequestOptions()
                    .placeholder(R.drawable.dialog_emotion_sad))
                .into(imageDialogEmotion)
        }
        dialog.show()
    }

    private fun initNicknameDialog() {
        dialog = Dialog(Objects.requireNonNull(this))
        dialog.apply {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            window!!.setDimAmount(0.5F)
            setCancelable(false)
            setContentView(R.layout.dialog_sign_up)
        }
        imageDialogEmotion = dialog.findViewById(R.id.d_sign_up_iv_emotion)
        textDialogTitle = dialog.findViewById(R.id.d_sign_up_tv_title)
        textDialogContent = dialog.findViewById(R.id.d_sign_up_tv_content)
        textDialogTitle.text = "중복확인"
        btnOK = dialog.findViewById(R.id.d_sign_up_tv_ok)
        btnOK.setOnClickListener { dialog.dismiss() }
    }
}
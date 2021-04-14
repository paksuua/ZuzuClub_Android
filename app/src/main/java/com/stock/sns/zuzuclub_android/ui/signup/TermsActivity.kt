package com.stock.sns.zuzuclub_android.ui.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import com.stock.sns.zuzuclub_android.R
import com.stock.sns.zuzuclub_android.databinding.ActivityTermsBinding

class TermsActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {
    private val binding by lazy { ActivityTermsBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initClickListener()
        initCheckBoxChangeListener()
    }

    private fun initClickListener(){
        binding.aTermsIvBack.setOnClickListener { finish() }
        binding.aTermsTvNext.setOnClickListener {
            startActivity(Intent(this, ChooseStockActivity::class.java))
        }
    }

    private fun initCheckBoxChangeListener() {
        binding.aTermsCbFullConsent.setOnCheckedChangeListener(this)
        binding.aTermsCbTermsConsent.setOnCheckedChangeListener(this)
        binding.aTermsCbPersonalInfoConsent.setOnCheckedChangeListener(this)
    }

    private fun activateNextBtn() {
        binding.aTermsTvNext.isEnabled = true
        binding.aTermsTvNext.setBackgroundColor(getColor(R.color.zuzu_orange))
        binding.aTermsTvNext.setTextColor(getColor(R.color.zuzu_white))
    }

    private fun deactivateNextBtn(){
        binding.aTermsTvNext.isEnabled = false
        binding.aTermsTvNext.setBackgroundColor(getColor(R.color.zuzu_coolgrey_10))
        binding.aTermsTvNext.setTextColor(getColor(R.color.zuzu_black_20))
    }

    override fun onCheckedChanged(view: CompoundButton, isChecked: Boolean) {
        when(view.id){
            R.id.a_terms_cb_full_consent -> {
                if(isChecked){
                    binding.aTermsCbTermsConsent.isChecked = true
                    binding.aTermsCbPersonalInfoConsent.isChecked = true
                    activateNextBtn()
                }else{
                    binding.aTermsCbTermsConsent.isChecked = false
                    binding.aTermsCbPersonalInfoConsent.isChecked = false
                    deactivateNextBtn()
                }
            }
            else -> {
                if(binding.aTermsCbTermsConsent.isChecked && binding.aTermsCbPersonalInfoConsent.isChecked){
                    activateNextBtn()
                }else{
                    deactivateNextBtn()
                }
            }
        }
    }
}
package com.stock.sns.zuzuclub_android.ui.home.hotranking

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.stock.sns.zuzuclub_android.data.model.HotRankingData
import com.stock.sns.zuzuclub_android.databinding.ActivityHotRankingBinding

class HotRankingActivity : AppCompatActivity() {
    private val binding by lazy { ActivityHotRankingBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<HotRankingViewModel>()
    var data = MutableLiveData<ArrayList<HotRankingData>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        // tab
//        binding.tabHot.setupWithViewPager(viewpagerContent)
//        setupTabIcons

        // 뒤로 가기
        binding.imgHotBack.setOnClickListener {
            finish()
        }

        binding.rvHotList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        viewModel.hotRankingData.observe(
            this,
            {
                data.value = it
                binding.rvHotList.adapter = HotRankingAdapter(data)
            }
        )
    }
}
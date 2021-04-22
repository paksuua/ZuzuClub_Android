package com.stock.sns.zuzuclub_android.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.stock.sns.zuzuclub_android.R
import com.stock.sns.zuzuclub_android.data.model.HotData
import com.stock.sns.zuzuclub_android.data.model.InterestData
import com.stock.sns.zuzuclub_android.databinding.FragmentHomeBinding
import com.stock.sns.zuzuclub_android.ui.home.hotranking.HotRankingActivity

class HomeFragment : Fragment() {
    private val binding by lazy { FragmentHomeBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<HomeViewModel>()

    var hotData = MutableLiveData<ArrayList<HotData>>()
    var interestData = MutableLiveData<ArrayList<InterestData>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initUI()
        return binding.root
    }

    private fun initUI() {
        // 날씨
        viewModel.weatherData.observe(
            viewLifecycleOwner,
            {
                when (it.figure) {
                    1 -> {
                        binding.imgWeather.setImageResource(R.drawable.weather_sun)
                        binding.tvHomeWeather.text = "오늘의 날씨는\n맑아요 ^0^"
                        binding.tvHomeDesc.text = "무려 ${it.figure}%의 주주들이 기뻐하고 있네요!\n따상 따따상 가즈아~!"
                    }
                    2 -> {
                        binding.imgWeather.setImageResource(R.drawable.weather_rain)
                        binding.tvHomeWeather.text = "오늘의 날씨는\n비가 주륵주륵ㅠ"
                        binding.tvHomeDesc.text = "${it.figure}%의 주주들이 하락세에 슬퍼하고있어요\n다들 힘냅시다!"
                    }
                    3 -> {
                        binding.imgWeather.setImageResource(R.drawable.weather_warm)
                        binding.tvHomeWeather.text = "오늘의 날씨는\n선선해요~"
                        binding.tvHomeDesc.text = "기대감에 찬 주주들이 ${it.figure}%네요!\n앞으로 상승세만 있기를..!"
                    }
                    else -> {
                        binding.imgWeather.setImageResource(R.drawable.weather_cloudy)
                        binding.tvHomeWeather.text = "오늘의 날씨는\n구름 잔뜩, 흐려요"
                        binding.tvHomeDesc.text = "${it.figure}%의 주주들이 불안에 떨고있어요"
                    }
                }
                binding.pgHome.progress = it.figure
            }
        )

        // Hot 종목
        binding.rvHomeHot.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        viewModel.hotStockData.observe(
            viewLifecycleOwner,
            {
                hotData.value = it
                binding.rvHomeHot.adapter = HomeHotAdapter(hotData)
            }
        )

        binding.tvHomeRank.setOnClickListener {
            val intent = Intent(requireContext(), HotRankingActivity::class.java)
            startActivity(intent)
        }

        // 관심 종목
        binding.rvHomeInterest.layoutManager = GridLayoutManager(context, 2)
        viewModel.interestStockData.observe(
            viewLifecycleOwner,
            {
                interestData.value = it
                binding.rvHomeInterest.adapter = HomeInterestAdapter(interestData)
            }
        )
    }
}

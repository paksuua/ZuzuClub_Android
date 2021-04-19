package com.stock.sns.zuzuclub_android.ui.intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.stock.sns.zuzuclub_android.R
import com.stock.sns.zuzuclub_android.databinding.ActivityIntroBinding
import com.stock.sns.zuzuclub_android.ui.login.LoginActivity

class IntroActivity : AppCompatActivity(), TabLayout.OnTabSelectedListener {
    private lateinit var binding: ActivityIntroBinding
    private lateinit var viewPager: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pagerAdapter = ScreenSlidePagerAdapter(this)
        viewPager = binding.aIntroVp
        viewPager.adapter = pagerAdapter

        val tabLayout = binding.aIntroTl
        TabLayoutMediator(tabLayout, viewPager) { _, _ ->
        }.attach()

        tabLayout.addOnTabSelectedListener(this)

        binding.aIntroTvStart.setOnClickListener {
            intent = Intent(this, LoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
    }

    inner class ScreenSlidePagerAdapter(introActivity: IntroActivity) :
        FragmentStateAdapter(introActivity) {
        override fun getItemCount(): Int = NUM_PAGES

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> Intro1Fragment()
                1 -> Intro2Fragment()
                2 -> Intro3Fragment()
                else -> {
                    Intro4Fragment()
                }
            }
        }

    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        if (binding.aIntroVp.currentItem == 3) {
            binding.aIntroTvStart.setTextColor(resources.getColor(R.color.zuzu_white, null))
            binding.aIntroTvStart.setBackgroundResource(R.drawable.intro_btn_start_background)
        } else {
            binding.aIntroTvStart.setTextColor(resources.getColor(R.color.zuzu_orange, null))
            binding.aIntroTvStart.setBackgroundResource(0)
        }
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {
    }

    companion object {
        private const val NUM_PAGES = 4
    }
}

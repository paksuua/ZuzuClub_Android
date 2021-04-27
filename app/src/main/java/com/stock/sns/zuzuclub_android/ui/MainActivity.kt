package com.stock.sns.zuzuclub_android.ui

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.stock.sns.zuzuclub_android.R
import com.stock.sns.zuzuclub_android.databinding.ActivityMainBinding
import com.stock.sns.zuzuclub_android.ui.home.HomeFragment
import com.stock.sns.zuzuclub_android.ui.post.PostFragment

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val fragmentPost by lazy { PostFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // initTransparentSystemBar()

        initNavigationBar()
    }

    private fun initNavigationBar() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fcv_main) as NavHostFragment
        val navController = navHostFragment.navController
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.navigation_post || destination.id == R.id.navigation_search) {
                binding.btnvView.visibility = View.GONE
            } else {
                binding.btnvView.visibility = View.VISIBLE
            }
        }

        binding.btnvView.setupWithNavController(navController)
        binding.btnvView.itemIconTintList = null
    }

    // 상단 시스템바를 투명하게
    private fun initTransparentSystemBar() {
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        binding.root.setPadding(0, 0, 0, statusBarHeight(this))
        window.statusBarColor = Color.TRANSPARENT
    }

    private fun statusBarHeight(context: Context): Int {
        val resourceId = context.resources.getIdentifier("status_bar_height", "dimen", "android")

        return if (resourceId > 0) context.resources.getDimensionPixelSize(resourceId)
        else 0
    }

    override fun onBackPressed() {
        if (fragmentPost.isVisible) {
            if (fragmentPost.childFragmentManager.backStackEntryCount >= 1) {
                fragmentPost.childFragmentManager.popBackStackImmediate()
            } else {
                super.onBackPressed()
            }
        } else {
            super.onBackPressed()
        }
    }
}

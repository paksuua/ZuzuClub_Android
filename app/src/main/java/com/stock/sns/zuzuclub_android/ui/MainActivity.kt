package com.stock.sns.zuzuclub_android.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.stock.sns.zuzuclub_android.R
import com.stock.sns.zuzuclub_android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initNavigationBar()
    }

    private fun initNavigationBar() {
        val navView: BottomNavigationView = findViewById(R.id.btnv_view)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fcv_main) as NavHostFragment
        val navController = navHostFragment.navController
        navView.setupWithNavController(navController)
        binding.btnvView.itemIconTintList = null
    }
}

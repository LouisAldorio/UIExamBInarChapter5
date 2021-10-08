package com.catnip.uiexambinarchapter5.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.catnip.uiexambinarchapter5.R
import com.catnip.uiexambinarchapter5.databinding.ActivityMainBinding
import com.catnip.uiexambinarchapter5.ui.fragment.LocationFragment
import com.catnip.uiexambinarchapter5.ui.fragment.ProfileFragment
import com.catnip.uiexambinarchapter5.utils.views.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewPager()
    }

    private fun setupViewPager() {

        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPagerAdapter.addFragment(ProfileFragment(), "Profile")
        viewPagerAdapter.addFragment(LocationFragment(), "Current Location")
        binding.vpTask.adapter = viewPagerAdapter

        //setting title for tab layout
        TabLayoutMediator(binding.tlTask, binding.vpTask, true) { tab, position ->
            tab.text = viewPagerAdapter.getPageTitle(position)
        }.attach()
    }
}
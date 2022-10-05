package com.example.news_app.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.news_app.MainActivity
import com.example.news_app.model.Keys
import com.example.news_app.ui.view.EntertainmentFragment
import com.example.news_app.ui.view.HealthFragment
import com.example.news_app.ui.view.BusinessFragment
import com.example.news_app.ui.view.HomeFragment
import com.example.news_app.ui.view.SportsFragment
import com.example.news_app.ui.view.ScienceFragment

class PagerAdapter(manager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(manager, lifecycle){
    override fun getItemCount(): Int = 6

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> HomeFragment(Keys.GENERAL,MainActivity.isSearch)
            1 -> BusinessFragment(Keys.BUSINESS,MainActivity.isSearch)
            2 -> ScienceFragment(Keys.SCIENCE,MainActivity.isSearch)
            3 -> SportsFragment(Keys.SPORTS,MainActivity.isSearch)
            4 -> EntertainmentFragment(Keys.ENTERTAINMENT,MainActivity.isSearch)
            5 -> HealthFragment(Keys.HEALTH,MainActivity.isSearch)
            else -> HomeFragment(Keys.GENERAL,MainActivity.isSearch)
        }
    }
}
package com.example.news_app.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
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
            0 -> HomeFragment()
            1 -> BusinessFragment()
            2 -> ScienceFragment()
            3 -> SportsFragment()
            4 -> EntertainmentFragment()
            5 -> HealthFragment()
            else -> BusinessFragment()
        }
    }



}
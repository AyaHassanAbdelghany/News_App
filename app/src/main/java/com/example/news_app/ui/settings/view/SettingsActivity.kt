package com.example.news_app.ui.settings.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.news_app.R
import com.example.news_app.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {

    private val binding by lazy { ActivitySettingsBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(binding.fragmentContainerView.id, SettingFragment())
            .commit()
    }
}
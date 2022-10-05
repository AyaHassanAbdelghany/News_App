package com.example.news_app.ui.settings.view

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.example.news_app.R

class SettingFragment : PreferenceFragmentCompat(){
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.prefrence, rootKey)

    }
}
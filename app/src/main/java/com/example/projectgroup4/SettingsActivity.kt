package com.example.projectgroup4

import android.os.Bundle
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_settings)

        val switchDarkMode = findViewById<Switch>(R.id.switchDarkMode)

        val preferences = getSharedPreferences(
            "StudentTaskManager",
            MODE_PRIVATE
        )

        val darkMode = preferences.getBoolean("dark_mode", false)

        switchDarkMode.isChecked = darkMode

        switchDarkMode.setOnCheckedChangeListener { _, isChecked ->

            preferences.edit()
                .putBoolean("dark_mode", isChecked)
                .apply()

            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_YES
                )
            } else {
                AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_NO
                )
            }
        }
    }
}
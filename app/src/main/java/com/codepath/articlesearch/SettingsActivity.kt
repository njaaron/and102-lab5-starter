package com.codepath.articlesearch
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager

class SettingsActivity : AppCompatActivity() {
    private lateinit var cacheSwitch: Switch
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize SharedPreferences and the switch
        sharedPreferences = androidx.preference.PreferenceManager.getDefaultSharedPreferences(this)
        cacheSwitch = findViewById(R.id.switch_cache)

        // Load and display the cached state
        cacheSwitch.isChecked = sharedPreferences.getBoolean("cache_enabled", true)

        // Listen for changes to save the new state
        cacheSwitch.setOnCheckedChangeListener { _, isChecked ->
            sharedPreferences.edit().putBoolean("cache_enabled", isChecked).apply()
        }
    }
}

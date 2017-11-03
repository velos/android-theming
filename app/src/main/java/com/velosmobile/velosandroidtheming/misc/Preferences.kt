package com.velosmobile.velosandroidtheming.misc

import android.content.Context
import android.support.v7.app.AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
import android.support.v7.app.AppCompatDelegate.NightMode
import com.velosmobile.velosandroidtheming.extensions.sharedPreferences

object Preferences {

    private const val KEY_THEME = "Theme"


    @NightMode fun getTheme(context: Context): Int {
        return context.sharedPreferences.getInt(KEY_THEME, MODE_NIGHT_FOLLOW_SYSTEM)
    }

    fun setTheme(context: Context, @NightMode theme: Int) {
        context.sharedPreferences
                .edit()
                .putInt(KEY_THEME, theme)
                .apply()

    }

}

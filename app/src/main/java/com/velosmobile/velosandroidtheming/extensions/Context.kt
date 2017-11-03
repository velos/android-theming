package com.velosmobile.velosandroidtheming.extensions

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

val Context.sharedPreferences: SharedPreferences
    get() = PreferenceManager.getDefaultSharedPreferences(this)

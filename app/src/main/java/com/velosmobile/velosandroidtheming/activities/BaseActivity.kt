package com.velosmobile.velosandroidtheming.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.velosmobile.velosandroidtheming.misc.Preferences

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        delegate.setLocalNightMode(Preferences.getTheme(this))
        super.onCreate(savedInstanceState)
    }

}

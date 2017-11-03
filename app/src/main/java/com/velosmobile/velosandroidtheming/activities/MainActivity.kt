package com.velosmobile.velosandroidtheming.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatDelegate.*
import android.view.View
import android.widget.TextView
import com.velosmobile.velosandroidtheming.R
import com.velosmobile.velosandroidtheming.kotterknife.bindView
import com.velosmobile.velosandroidtheming.misc.Preferences

class MainActivity : BaseActivity() {

    private val mBulbasaur: View by bindView(R.id.bulbasaur)
    private val mCharmander: View by bindView(R.id.charmander)
    private val mSquirtle: View by bindView(R.id.squirtle)
    private val mTheme: View by bindView(R.id.theme)
    private val mThemeSubtitle: TextView by bindView(R.id.themeSubtitle)


    companion object {
        fun getLaunchIntent(context: Context): Intent {
            return Intent.makeRestartActivityTask(Intent(context, MainActivity::class.java).component)
        }
    }

    private fun getThemeNameFromInt(@NightMode theme: Int): CharSequence {
        return when (theme) {
            MODE_NIGHT_AUTO -> { getText(R.string.auto) }
            MODE_NIGHT_NO -> { getText(R.string.day) }
            MODE_NIGHT_YES -> { getText(R.string.night) }
            MODE_NIGHT_FOLLOW_SYSTEM -> { getText(R.string.system) }
            else -> { throw IllegalArgumentException("unknown theme value: $theme") }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mBulbasaur.setOnClickListener {
            startActivity(BulbasaurActivity.getLaunchIntent(this))
        }

        mCharmander.setOnClickListener {
            startActivity(CharmanderActivity.getLaunchIntent(this))
        }

        mSquirtle.setOnClickListener {
            startActivity(SquirtleActivity.getLaunchIntent(this))
        }

        mTheme.setOnClickListener {
            showThemePickerDialog()
        }
    }

    override fun onResume() {
        super.onResume()

        mThemeSubtitle.text = getThemeNameFromInt(Preferences.getTheme(this))
    }

    private fun showThemePickerDialog() {
        val themes = arrayOf(getText(R.string.auto), getText(R.string.day),
                getText(R.string.night), getText(R.string.system))

        val currentTheme = Preferences.getTheme(this)
        val checkedItem = when (currentTheme) {
            MODE_NIGHT_AUTO -> { 0 }
            MODE_NIGHT_NO -> { 1 }
            MODE_NIGHT_YES -> { 2 }
            MODE_NIGHT_FOLLOW_SYSTEM -> { 3 }
            else -> { throw RuntimeException("unknown theme value: $currentTheme") }
        }

        AlertDialog.Builder(this)
                .setSingleChoiceItems(themes, checkedItem) { dialog, which ->
                    val theme = when (which) {
                        0 -> { MODE_NIGHT_AUTO }
                        1 -> { MODE_NIGHT_NO }
                        2 -> { MODE_NIGHT_YES }
                        3 -> { MODE_NIGHT_FOLLOW_SYSTEM }
                        else -> { throw RuntimeException("unknown theme value: $which") }
                    }

                    dialog.dismiss()

                    if (theme != currentTheme) {
                        Preferences.setTheme(this, theme)
                        startActivity(getLaunchIntent(this))
                    }
                }
                .setTitle(R.string.theme)
                .show()
    }

}

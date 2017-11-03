package com.velosmobile.velosandroidtheming.activities

import android.content.Context
import android.content.Intent
import com.velosmobile.velosandroidtheming.models.Pokemon

class SquirtleActivity : PokemonActivity() {

    companion object {
        fun getLaunchIntent(context: Context): Intent {
            return Intent(context, SquirtleActivity::class.java)
                    .putExtra(EXTRA_POKEMON, Pokemon.SQUIRTLE)
        }
    }

}

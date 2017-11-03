package com.velosmobile.velosandroidtheming.activities

import android.content.Context
import android.content.Intent
import com.velosmobile.velosandroidtheming.models.Pokemon

class CharmanderActivity : PokemonActivity() {

    companion object {
        fun getLaunchIntent(context: Context): Intent {
            return Intent(context, CharmanderActivity::class.java)
                    .putExtra(EXTRA_POKEMON, Pokemon.CHARMANDER)
        }
    }

}

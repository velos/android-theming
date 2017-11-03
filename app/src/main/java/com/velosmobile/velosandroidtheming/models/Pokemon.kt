package com.velosmobile.velosandroidtheming.models

import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import com.velosmobile.velosandroidtheming.R

enum class Pokemon(
        @StringRes val descriptionResId: Int,
        val number: Int,
        @DrawableRes val photoResId: Int,
        @StringRes val signatureMoveResId: Int,
        @StringRes val titleResId: Int,
        @StringRes val typeResId: Int
) {

    BULBASAUR(
            R.string.bulbasaur_description,
            1,
            R.drawable.bulbasaur,
            R.string.vine_whip,
            R.string.bulbasaur,
            R.string.grass),

    CHARMANDER(
            R.string.charmander_description,
            4,
            R.drawable.charmander,
            R.string.flamethrower,
            R.string.charmander,
            R.string.fire),

    SQUIRTLE(
            R.string.squirtle_description,
            7,
            R.drawable.squirtle,
            R.string.bubblebeam,
            R.string.squirtle,
            R.string.water);

}

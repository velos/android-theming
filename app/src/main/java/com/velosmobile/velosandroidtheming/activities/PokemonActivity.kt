package com.velosmobile.velosandroidtheming.activities

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.velosmobile.velosandroidtheming.R
import com.velosmobile.velosandroidtheming.kotterknife.bindView
import com.velosmobile.velosandroidtheming.models.Pokemon
import java.text.NumberFormat

abstract class PokemonActivity : BaseActivity() {

    private lateinit var mPokemon: Pokemon

    private val mDescription: TextView by bindView(R.id.description)
    private val mPhoto: ImageView by bindView(R.id.photo)
    private val mSignatureMove: TextView by bindView(R.id.signatureMove)
    private val mType: TextView by bindView(R.id.type)


    companion object {
        val CNAME  = PokemonActivity::class.java.canonicalName
        val EXTRA_POKEMON = CNAME + ".Pokemon"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon)

        mPokemon = intent.getSerializableExtra(EXTRA_POKEMON) as Pokemon

        setTitle(mPokemon.titleResId)
        supportActionBar?.subtitle = resources.getString(R.string.number_format,
                NumberFormat.getIntegerInstance().format(mPokemon.number))

        mPhoto.setImageResource(mPokemon.photoResId)
        mType.text = resources.getString(R.string.type_format,
                resources.getString(mPokemon.typeResId))
        mSignatureMove.text = resources.getString(R.string.signature_move_format,
                resources.getString(mPokemon.signatureMoveResId))
        mDescription.setText(mPokemon.descriptionResId)
    }

}

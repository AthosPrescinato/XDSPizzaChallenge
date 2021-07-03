package com.athosprescinato.xdspizzachallenge.view

import android.content.Context
import android.content.Intent
import android.media.Rating
import android.os.Build.VERSION_CODES.P
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.*
import com.athosprescinato.xdspizzachallenge.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detalhe.*
import kotlinx.android.synthetic.main.activity_login.*
import java.text.DecimalFormat

class DetalheActivity : AppCompatActivity() {

    lateinit var textName: TextView
    lateinit var textPrice: TextView
    lateinit var imagePizzaSelecionada: ImageView
    lateinit var ratingBar: RatingBar

    val df = DecimalFormat("#.00")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe)

        var bundle: Bundle? = intent.extras
        var pizzaName = bundle!!.getString("pizzaName")
        var pizzaSelecionadaImageUrl = bundle!!.getString("pizzaImage")
        var pizzaRating = bundle!!.getString("pizzaRating")
        var pizzaPriceP = bundle!!.getString("pizzaPriceP")
        var pizzaPriceM = bundle!!.getString("pizzaPriceM")
        var pizzaPriceG = bundle!!.getString("pizzaPriceG")
        var radioGroup: RadioGroup = findViewById(R.id.radioGroup)

        textPrice = findViewById(R.id.textPrice)
        textName = findViewById(R.id.textPizzaName)
        ratingBar = findViewById(R.id.ratingBarDetalhe)
        imagePizzaSelecionada = findViewById(R.id.imagePizzaDetalhe)

        textPrice.text = "R$: " + df.format(pizzaPriceM.toString().toFloat())
        textName.text = "Pizza de " + pizzaName
        ratingBar.setRating(pizzaRating.toString().toFloat())

        Picasso.with(baseContext).load(pizzaSelecionadaImageUrl).into(imagePizzaSelecionada)

        radioGroup.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { radioGroup, checkedId ->
                val radioSelected: RadioButton = findViewById(checkedId)
                when (radioSelected.text) {
                    "P" -> textPrice.text = "R$: " + df.format(pizzaPriceP.toString().toFloat())
                    "M" -> textPrice.text = "R$: " + df.format(pizzaPriceM.toString().toFloat())
                    "G" -> textPrice.text = "R$: " + df.format(pizzaPriceG.toString().toFloat())
                }
            }
        )

    }


    override fun onPause() {
        super.onPause()
        finish()
    }

    fun comprar(view: View){
        startActivity(Intent(this, SucessoActivity::class.java))
        finish()
    }
}

package com.athosprescinato.xdspizzachallenge.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.athosprescinato.xdspizzachallenge.R
import kotlinx.android.synthetic.main.activity_sucesso.*

class SucessoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sucesso)


    }


    fun voltarEscolhaActivity(v: View){
        intent = Intent(this, EscolhaActivity::class.java)
        intent.flags =  Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }

}

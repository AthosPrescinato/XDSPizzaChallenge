package com.athosprescinato.xdspizzachallenge.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.athosprescinato.xdspizzachallenge.R
import com.athosprescinato.xdspizzachallenge.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        setListeners()
        observe()

    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_login) {
            handleLogin()
        }
    }

    private fun setListeners() {
        button_login.setOnClickListener(this)

    }

    private fun observe() {
        mViewModel.login.observe(this, Observer {
            if (it) {
                startActivity(Intent(this, EscolhaActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Erro ao logar", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun handleLogin() {
        val email = edit_email.text.toString()
        val password = edit_password.text.toString()

        mViewModel.doLogin(email, password)
    }

}


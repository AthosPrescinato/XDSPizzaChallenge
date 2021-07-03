package com.athosprescinato.xdspizzachallenge.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.athosprescinato.xdschallenge.service.model.LoginModel
import com.athosprescinato.xdschallenge.service.repository.LoginRepository
import com.athosprescinato.xdspizzachallenge.service.listener.APIListener

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val mLoginRepository = LoginRepository()
    private val mLogin = MutableLiveData<Boolean>()
    var login: LiveData<Boolean> = mLogin

    fun doLogin(email: String, password: String) {

        mLoginRepository.login(email, password, object : APIListener {
            override fun onSuccess(  /*model: LoginModel */ ) {
                mLogin.value = true
            }

            override fun onFailure(str: String) {
                mLogin.value = false
            }

        })

    }

}
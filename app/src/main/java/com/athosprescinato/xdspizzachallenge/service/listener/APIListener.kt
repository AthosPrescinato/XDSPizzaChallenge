package com.athosprescinato.xdspizzachallenge.service.listener

import com.athosprescinato.xdschallenge.service.model.LoginModel

interface APIListener {

    fun onSuccess( /* model: LoginModel */ )

    fun onFailure(str: String)


}
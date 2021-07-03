package com.athosprescinato.xdspizzachallenge.service

import com.athosprescinato.xdspizzachallenge.service.model.PizzaModel
import retrofit2.Call
import retrofit2.http.GET

interface PizzaService {

    @GET("/v1/pizza")
    fun list(): Call<MutableList<PizzaModel>>


}
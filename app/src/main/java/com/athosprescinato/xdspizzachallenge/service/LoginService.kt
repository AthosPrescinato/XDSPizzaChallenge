package com.athosprescinato.xdschallenge.service.repository

import com.athosprescinato.xdschallenge.service.model.LoginModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface LoginService {

    @FormUrlEncoded
    @POST("/v1/signin")
    fun login(@Field("email")email: String, @Field("password")password: String): Call<LoginModel>

}
package com.athosprescinato.xdschallenge.service.repository

import com.athosprescinato.xdschallenge.service.model.LoginModel
import com.athosprescinato.xdspizzachallenge.service.listener.APIListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepository {

    private val mRemote = RetrofitClient.createService(LoginService::class.java)

    fun login(email: String, password: String, listener: APIListener){
        val call: Call<LoginModel> = mRemote.login(email, password)


        call.enqueue( object : Callback<LoginModel> {
            override fun onFailure(call: Call<LoginModel>, t: Throwable) {
                listener.onFailure(t.message.toString())
            }

            override fun onResponse(call: Call<LoginModel>, response: Response<LoginModel>) {
               /*response.body()?.let { listener.onSuccess(it) }*/
                listener.onSuccess()

            }

        })

    }
}
package com.athosprescinato.xdspizzachallenge.service.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.athosprescinato.xdschallenge.service.repository.RetrofitClient
import com.athosprescinato.xdspizzachallenge.service.PizzaService
import com.athosprescinato.xdspizzachallenge.service.listener.APIListener
import com.athosprescinato.xdspizzachallenge.service.model.PizzaModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object PizzaRepository{

    private val mRemote = RetrofitClient.createService(PizzaService::class.java)
    var mutableLiveData =  MutableLiveData<ArrayList<PizzaModel>>()

    fun getListPizza(context: Context) : MutableLiveData<ArrayList<PizzaModel>> {
        val call: Call<MutableList<PizzaModel>> = mRemote.list()

        call.enqueue(object : Callback<MutableList<PizzaModel>> {
            override fun onFailure(call: Call<MutableList<PizzaModel>>, t: Throwable) {

            }

            override fun onResponse(call: Call<MutableList<PizzaModel>>, response: Response<MutableList<PizzaModel>>) {
                val listPizzaResponse = response.body()
                listPizzaResponse?.let { mutableLiveData.value = it as ArrayList<PizzaModel> }
            }
        })

        return mutableLiveData
    }


}
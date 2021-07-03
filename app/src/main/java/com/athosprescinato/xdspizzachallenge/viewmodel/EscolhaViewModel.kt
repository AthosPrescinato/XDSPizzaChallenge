package com.athosprescinato.xdspizzachallenge.viewmodel

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.athosprescinato.xdschallenge.service.repository.RetrofitClient
import com.athosprescinato.xdspizzachallenge.service.PizzaService
import com.athosprescinato.xdspizzachallenge.service.model.PizzaModel
import com.athosprescinato.xdspizzachallenge.service.repository.PizzaRepository
import com.athosprescinato.xdspizzachallenge.view.adapter.ListPizzaAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EscolhaViewModel(private val context: Context) : ViewModel()
{

    private val mPizzaRepository = PizzaRepository
    private var listPizza = MutableLiveData<ArrayList<PizzaModel>>()


     init{

         listPizza = mPizzaRepository.getListPizza(context)
     }

    fun getListPizza() : MutableLiveData<ArrayList<PizzaModel>>{
        return listPizza
    }



}
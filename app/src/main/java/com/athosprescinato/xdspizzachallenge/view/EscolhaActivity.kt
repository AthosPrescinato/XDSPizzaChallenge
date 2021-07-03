package com.athosprescinato.xdspizzachallenge.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.athosprescinato.xdspizzachallenge.R
import com.athosprescinato.xdspizzachallenge.service.model.PizzaModel
import com.athosprescinato.xdspizzachallenge.service.repository.PizzaRepository
import com.athosprescinato.xdspizzachallenge.view.adapter.ListPizzaAdapter
import com.athosprescinato.xdspizzachallenge.viewmodel.EscolhaViewModel
import com.athosprescinato.xdspizzachallenge.viewmodel.PizzaViewModelFactory
import kotlinx.android.synthetic.main.activity_escolha.*


class EscolhaActivity : AppCompatActivity(), ListPizzaAdapter.onItemClickListener {

    lateinit var mViewModel: EscolhaViewModel
    private lateinit var pizzaList: MutableList<PizzaModel>
    private lateinit var adapter: ListPizzaAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_escolha)

        recycler_list_pizzas.layoutManager = LinearLayoutManager(this@EscolhaActivity)
        pizzaList = mutableListOf<PizzaModel>()

        adapter = ListPizzaAdapter(this, pizzaList, this)

        recycler_list_pizzas.adapter = adapter


        val pizzaViewModel = ViewModelProviders.of(this,PizzaViewModelFactory(this)).get(EscolhaViewModel::class.java)
        pizzaViewModel.getListPizza().observe(this,object:Observer<ArrayList<PizzaModel>>{
            override fun onChanged(t: ArrayList<PizzaModel>?) {
                pizzaList.clear()
                t?.let { pizzaList.addAll(it) }
                adapter.notifyDataSetChanged()
            }

        })



    }

    override fun onItemClick(position: Int) {

        val pizzaSelecionada = pizzaList[position]
        val intent = Intent(this@EscolhaActivity, DetalheActivity::class.java)
        intent.putExtra("pizzaId", pizzaSelecionada.id)
        intent.putExtra("pizzaName", pizzaSelecionada.name)
        intent.putExtra("pizzaImage", pizzaSelecionada.imageUrl)
        intent.putExtra("pizzaRating", pizzaSelecionada.rating)
        intent.putExtra("pizzaPriceP", pizzaSelecionada.priceP)
        intent.putExtra("pizzaPriceM", pizzaSelecionada.priceM)
        intent.putExtra("pizzaPriceG", pizzaSelecionada.priceG)
        startActivity(intent)
        onStop()
    }
}


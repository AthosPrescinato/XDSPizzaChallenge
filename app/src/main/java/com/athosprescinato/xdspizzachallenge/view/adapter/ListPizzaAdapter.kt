package com.athosprescinato.xdspizzachallenge.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.athosprescinato.xdspizzachallenge.R
import com.athosprescinato.xdspizzachallenge.service.model.PizzaModel
import com.squareup.picasso.Picasso
import java.text.DecimalFormat

class ListPizzaAdapter(
    private val context: Context,
    private var listPizza: MutableList<PizzaModel>,
    private val listener: onItemClickListener

) : RecyclerView.Adapter<ListPizzaAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.recycler_item_pizzas, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listPizza.size
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val df = DecimalFormat("#.00")
        var pizza = listPizza.get(position)
        holder.pizzaname?.text = "Pizza de " + pizza.name
        var price = df.format(pizza.priceP.toString().toFloat())
        holder.pizzapriceP?.text = "R$:" + price
        holder.pizzarating?.setRating(pizza.rating.toString().toFloat())
        Picasso.with(context).load(pizza.imageUrl).into(holder.pizzaimage)


    }


    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {


        var pizzaname: TextView? = null
        var pizzapriceP: TextView? = null
        var pizzaimage: ImageView? = null
        var pizzarating: RatingBar? = null

        init {

            pizzaname = view.findViewById(R.id.textName_item)
            pizzapriceP = view.findViewById(R.id.textPriceP_item)
            pizzaimage = view.findViewById(R.id.imagePizza)
            pizzarating = view.findViewById(R.id.ratingBar)

            itemView.setOnClickListener(this)

        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if(position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }

        }


    }


    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

}
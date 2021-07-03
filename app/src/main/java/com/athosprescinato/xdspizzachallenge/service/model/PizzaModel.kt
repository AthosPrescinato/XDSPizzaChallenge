package com.athosprescinato.xdspizzachallenge.service.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class PizzaModel(


    @SerializedName("id")
    val id: String? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("imageUrl")
    val imageUrl: String? = null,

    @SerializedName("rating")
    val rating: String? = null,

    @SerializedName("priceP")
    val priceP: String? = null,

    @SerializedName("priceM")
    val priceM: String? = null,

    @SerializedName("priceG")
    val priceG: String? = null



) : Serializable
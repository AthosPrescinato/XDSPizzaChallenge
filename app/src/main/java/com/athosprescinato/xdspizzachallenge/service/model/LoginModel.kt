package com.athosprescinato.xdschallenge.service.model

import com.google.gson.annotations.SerializedName

class LoginModel {

    @SerializedName("accessToken")
    var accessToken: String = ""

    @SerializedName("tokenType")
    var tokenType: String = ""

}
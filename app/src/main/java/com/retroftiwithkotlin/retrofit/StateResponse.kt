package com.retroftiwithkotlin.retrofit

import com.google.gson.annotations.SerializedName


 class StateResponse {


    @SerializedName("IsSuccess")
    var isSuccess: Boolean = false

    @SerializedName("Message")
    var message: String? = null

    @SerializedName("ResponseData")
    var stateArrays: ArrayList<StateArray>? = null
}

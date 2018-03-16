package com.retroftiwithkotlin.retrofit

import com.google.gson.annotations.SerializedName

/**
 * Created by User on 15-Mar-18.
 */

class StateArray {

    @SerializedName("StateID")
    var stateID: Int = 0

    @SerializedName("StateName")
    var stateName: String? = null
}

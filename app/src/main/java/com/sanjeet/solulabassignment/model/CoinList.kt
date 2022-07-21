package com.sanjeet.solulabassignment.model

import com.google.gson.annotations.SerializedName

data class CoinList(
    @SerializedName("data")
    val `data`: Data?,
    @SerializedName("msg")
    val msg: String,
    @SerializedName("result")
    val result: Int
)
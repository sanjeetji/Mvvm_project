package com.sanjeet.solulabassignment.model

import com.google.gson.annotations.SerializedName

data class Pictures(
    @SerializedName("front")
    val front: Front?
)
package com.sanjeet.solulabassignment.model

import com.google.gson.annotations.SerializedName

data class ItemList(
    @SerializedName("_id")
    val _id: String,
    @SerializedName("name")
    val name: String?,
    @SerializedName("pictures")
    val pictures: Pictures?
)
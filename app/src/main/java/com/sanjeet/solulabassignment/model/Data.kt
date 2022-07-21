package com.sanjeet.solulabassignment.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("itemsPerPage")
    val itemsPerPage: Int,
    @SerializedName("list")
    val list: List<ItemList>?,
    @SerializedName("startIndex")
    val startIndex: Int,
    @SerializedName("totalItems")
    val totalItems: Int
)
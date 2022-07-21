package com.sanjeet.solulabassignment.repository

import com.sanjeet.solulabassignment.service.RetrofitService

class HomePageRepository constructor(private val retrofitService: RetrofitService) {
    fun getHomePageItem() = retrofitService.getHomePageItem()
}
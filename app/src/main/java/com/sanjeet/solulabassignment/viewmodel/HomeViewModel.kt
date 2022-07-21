package com.sanjeet.solulabassignment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sanjeet.solulabassignment.model.CoinList
import com.sanjeet.solulabassignment.repository.HomePageRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel constructor(private val repository: HomePageRepository) : ViewModel() {

    val data = MutableLiveData<CoinList>()
    val errorMessage = MutableLiveData<String>()

    fun getHomePageItems() {
        val response = repository.getHomePageItem()
        response.enqueue(object : Callback<CoinList> {
            override fun onResponse(call: Call<CoinList>, response: Response<CoinList>) {
                data.postValue(response.body())
            }

            override fun onFailure(call: Call<CoinList>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

        })
    }
}
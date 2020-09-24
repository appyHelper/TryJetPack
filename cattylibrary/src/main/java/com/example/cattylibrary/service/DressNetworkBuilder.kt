package com.example.cattylibrary.service


import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object DressNetworkBuilder {

    fun getDressRetrofitBuilder() :Retrofit{

        val dressNetworkBuilder = Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).baseUrl("https://cat-fact.herokuapp.com/").build()
        return dressNetworkBuilder

    }
}
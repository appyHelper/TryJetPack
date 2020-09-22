package com.example.tryjetpack.service

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object DressNetworkBuilder {

    fun getDressRetrofitBuilder() : DressApi{

        val dressNetworkBuilder = Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).baseUrl("https://cat-fact.herokuapp.com/").build()
        return dressNetworkBuilder.create(DressApi::class.java)

    }
}
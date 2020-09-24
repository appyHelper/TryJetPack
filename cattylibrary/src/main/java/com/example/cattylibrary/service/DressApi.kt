package com.example.cattylibrary.service

import com.example.cattylibrary.modal.CatInfo
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers


interface DressApi {
    @GET("facts")
    @Headers("Content-Type:application/json")
    fun getDressList():Observable<CatInfo>
}
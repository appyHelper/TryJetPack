package com.example.tryjetpack.service

import com.example.tryjetpack.modal.CatInfo
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers


interface DressApi {
    @GET("facts")
    @Headers("Content-Type:application/json")
    fun getDressList():Observable<CatInfo>
}
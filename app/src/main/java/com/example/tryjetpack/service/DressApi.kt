package com.example.tryjetpack.service

import com.example.tryjetpack.modal.CatInfo
import com.example.tryjetpack.modal.Dress
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface DressApi {
    @GET("facts")
    @Headers("Content-Type:application/json")
    fun getDressList():Observable<CatInfo>
}
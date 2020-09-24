package com.example.tryjetpack.repository


import com.example.tryjetpack.modal.All
import com.example.tryjetpack.service.DressApi
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class DressRepository @Inject constructor(val dressApi: DressApi) {

    fun getDressList1():Observable<List<All>>{

     return   dressApi.getDressList().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).map {
        it.all
        }

    }


}
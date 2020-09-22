package com.example.tryjetpack.repository

import android.content.Context
import android.util.Log
import android.widget.ImageView
import com.example.tryjetpack.R
import com.example.tryjetpack.modal.All
import com.example.tryjetpack.modal.CatInfo
import com.example.tryjetpack.modal.Dress
import com.example.tryjetpack.service.DressNetworkBuilder
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlin.collections.ArrayList

class DressRepository() {
    var dressArrayList =ArrayList<Dress>()

    fun getDressList(context: Context): ArrayList<Dress>? {


        dressArrayList.add(Dress("saree","$30"))
        dressArrayList.add(Dress("saree","$50"))
        return dressArrayList


//        Observable.create { t ->
//            Log.d("observable",t.toString())
//
//            Observable.fromIterable(dressArrayList).toList()
//        }toList
    }
    fun getDressList2(): Observable<ArrayList<Dress>>? {

         Log.d("inside","repository")
        dressArrayList.add(Dress("saree","$30"))
        dressArrayList.add(Dress("saree","$50"))
        return Observable.just(dressArrayList)


//        Observable.create { t ->
//            Log.d("observable",t.toString())
//
//            Observable.fromIterable(dressArrayList).toList()
//        }toList
    }

    fun getDressList1():Observable<CatInfo>{

     return   DressNetworkBuilder.getDressRetrofitBuilder().getDressList().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).map {
        it
        }

    }

    fun getEditTextInput(context: Context,name:String){
        dressArrayList.add(Dress(name,"35"))
        Log.d("repo",dressArrayList.toString())
    }
}
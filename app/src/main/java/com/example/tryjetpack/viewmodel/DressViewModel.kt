package com.example.tryjetpack.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tryjetpack.modal.CatInfo
import com.example.tryjetpack.modal.Dress
import com.example.tryjetpack.repository.DressRepository
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.schedulers.Schedulers.io
import java.util.logging.Logger

class DressViewModel() : ViewModel(){


    fun getMutableLiveData(context: Context) : MutableLiveData<ArrayList<Dress>>{
        val repository =DressRepository()
        var mutableLiveData =MutableLiveData<ArrayList<Dress>>()
        Log.d("dressviewmodel",repository.getDressList(context).toString())
        mutableLiveData.value= repository.getDressList(context)
        return mutableLiveData
    }

    fun getObservable():ArrayList<Dress>{
        val repository =DressRepository()
      var dressList2 =ArrayList<Dress>()
      repository.getDressList2()?.observeOn(Schedulers.io())?.subscribeOn(AndroidSchedulers.mainThread())?.map {
       dressList2 =  it
        }
        return dressList2
    }

    fun getEditText(context: Context,name:String){
        val repository =DressRepository()
        repository.getEditTextInput(context,name)
    }
}
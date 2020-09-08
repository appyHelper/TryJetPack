package com.example.tryjetpack.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tryjetpack.modal.Dress
import com.example.tryjetpack.repository.DressRepository

class DressViewModel() : ViewModel(){


    fun getMutableLiveData(context: Context) : MutableLiveData<ArrayList<Dress>>{
        val repository =DressRepository()
        var mutableLiveData =MutableLiveData<ArrayList<Dress>>()
        mutableLiveData.value=repository.getDressList(context)
        return mutableLiveData
    }
}
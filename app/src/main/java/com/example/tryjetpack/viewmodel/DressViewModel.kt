package com.example.tryjetpack.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tryjetpack.modal.All
import com.example.tryjetpack.repository.DressRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class DressViewModel @Inject constructor(val repository: DressRepository) : ViewModel(){


    fun getMutableLiveData() : MutableLiveData<List<All>>{

        var mutableLiveData =MutableLiveData<List<All>>()
        repository.getDressList1().observeOn(AndroidSchedulers.mainThread()).subscribe({
            mutableLiveData.value=it
        },{
           Log.e("DressViewModel","error fetching repository  $it")
        }

        )

        return mutableLiveData

    }



}
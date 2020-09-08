package com.example.tryjetpack.repository

import android.content.Context
import android.widget.ImageView
import com.example.tryjetpack.R
import com.example.tryjetpack.modal.Dress

class DressRepository() {

    fun getDressList(context: Context):ArrayList<Dress>{
      var dressArrayList =ArrayList<Dress>()
        dressArrayList.add(Dress("saree","$30",context.resources.getDrawable(R.drawable.pink_2)))
        dressArrayList.add(Dress("saree","$50",context.resources.getDrawable(R.drawable.pink_4)))
        return dressArrayList
    }
}
package com.example.tryjetpack.repository

import android.content.Context
import android.widget.ImageView
import com.example.tryjetpack.R
import com.example.tryjetpack.modal.Dress

class DressRepository() {

    fun getDressList(context: Context):ArrayList<Dress>{
      var dressArrayList =ArrayList<Dress>()
        dressArrayList.add(Dress("saree","$30",context.resources.getDrawable(R.drawable.pinksaree_background)))
        dressArrayList.add(Dress("saree","$30",context.resources.getDrawable(R.drawable.pinksaree_background)))
        return dressArrayList
    }
}
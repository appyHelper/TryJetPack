package com.example.tryjetpack.view.activity

import android.app.AppComponentFactory
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cattylibrary.MainInteractorActivity
import com.example.tryjetpack.R

import com.example.cattylibrary.di.DressApiServiceModule
import com.example.cattylibrary.di.DressComponent
import com.example.cattylibrary.modal.Dress
import com.example.cattylibrary.repository.DressRepository
import com.example.cattylibrary.view.adapter.EthnicWearAdapter
import com.example.cattylibrary.viewmodel.DressViewModel
import com.example.cattylibrary.viewmodel.DressViewModelFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        dressAddButton.setOnClickListener {
                startActivity(Intent(this,MainInteractorActivity::class.java))
        }

    }




}
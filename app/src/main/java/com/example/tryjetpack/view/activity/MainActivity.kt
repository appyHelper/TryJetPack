package com.example.tryjetpack.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tryjetpack.R
import com.example.tryjetpack.adapter.EthnicWearAdapter
import com.example.tryjetpack.repository.DressRepository
import com.example.tryjetpack.viewmodel.DressViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var repository: DressRepository
    lateinit var viewModel: DressViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel=ViewModelProvider.NewInstanceFactory().create(DressViewModel::class.java)
        viewModel.getMutableLiveData(this).observe(this, Observer {
            rvDressList.adapter = EthnicWearAdapter(this,it)
            rvDressList.layoutManager=LinearLayoutManager(this)
        })

    }
}
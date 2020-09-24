package com.example.cattylibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cattylibrary.di.DaggerDressComponent
import com.example.cattylibrary.di.DressApiServiceModule
import com.example.cattylibrary.modal.Dress
import com.example.cattylibrary.view.adapter.EthnicWearAdapter
import com.example.cattylibrary.viewmodel.DressViewModel
import com.example.cattylibrary.viewmodel.DressViewModelFactory
import kotlinx.android.synthetic.main.activity_main_interactor.*
import javax.inject.Inject

class MainInteractorActivity : AppCompatActivity() {

    @Inject lateinit var dressViewModelFactory: DressViewModelFactory
    lateinit var viewModel: DressViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_interactor)

        DaggerDressComponent.builder().dressApiServiceModule(
            DressApiServiceModule(
                this.application
            )
        ).build().inject(this)
        viewModel= ViewModelProvider(this,dressViewModelFactory).get(DressViewModel::class.java)
        viewModel.getMutableLiveData().observe(this, Observer {
            Log.d("main activity","list of all $it")
            val dressList =ArrayList<Dress>()
            for(i in it){
                dressList.add(Dress(i._id, i.text))
            }

            Log.d("${this.localClassName}","dress list $dressList")
            rvDressList.adapter =
                EthnicWearAdapter(
                    this,
                    dressList
                )
            rvDressList.layoutManager = LinearLayoutManager(this)
        })
    }
}
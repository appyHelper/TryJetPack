package com.example.tryjetpack.view.activity

import android.app.AppComponentFactory
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tryjetpack.R
import com.example.tryjetpack.di.DaggerDressComponent
import com.example.tryjetpack.di.DressApiServiceModule
import com.example.tryjetpack.di.DressComponent
import com.example.tryjetpack.modal.Dress
import com.example.tryjetpack.repository.DressRepository
import com.example.tryjetpack.view.adapter.EthnicWearAdapter
import com.example.tryjetpack.viewmodel.DressViewModel
import com.example.tryjetpack.viewmodel.DressViewModelFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

@Inject lateinit var dressViewModelFactory: DressViewModelFactory
    lateinit var viewModel: DressViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      DaggerDressComponent.builder().dressApiServiceModule(DressApiServiceModule(this.application)).build().inject(this)
        viewModel=ViewModelProvider(this,dressViewModelFactory).get(DressViewModel::class.java)
           viewModel.getMutableLiveData().observe(this, Observer {
               Log.d("main activity","list of all $it")
               val dressList =ArrayList<Dress>()
           for(i in it){
               dressList.add(Dress(i._id,i.text))
           }

               Log.d("${this.localClassName}","dress list $dressList")
               rvDressList.adapter = EthnicWearAdapter(this, dressList)
         rvDressList.layoutManager = LinearLayoutManager(this)
           })

        dressAddButton.setOnClickListener {
            hideSoftKeyboard()

        }

    }

    private fun hideSoftKeyboard() {
        if (currentFocus != null && currentFocus is EditText) {
            val inputManager:InputMethodManager =getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(dressEditText.windowToken, InputMethodManager.SHOW_FORCED)
        }
    }


}
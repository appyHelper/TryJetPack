package com.example.tryjetpack.view.activity

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
import com.example.tryjetpack.modal.Dress
import com.example.tryjetpack.repository.DressRepository
import com.example.tryjetpack.view.adapter.EthnicWearAdapter
import com.example.tryjetpack.viewmodel.DressViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {



    lateinit var viewModel: DressViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         val repository =DressRepository()
        repository.getDressList2()?.observeOn(AndroidSchedulers.mainThread())?.subscribe({
            Log.d("dress just", it.toString())
            rvDressList.adapter = EthnicWearAdapter(this, it)
            rvDressList.layoutManager = LinearLayoutManager(this)
            it
        },{

              })
//     val retrodress =   repository.getDressList1().subscribeOn(Schedulers.io())?.observeOn(AndroidSchedulers.mainThread())?.map {
//            Log.d("dressviewmodell",it.toString())
//            //   mutableLiveData.value= it
//            it
//        }

        //Log.d("retrodress",retrodress.toString())

        viewModel=ViewModelProvider.NewInstanceFactory().create(DressViewModel::class.java)
        Log.d("Main","mainactivity")
        val justdress =
//        viewModel.getMutableLiveData(this).observe(this, Observer {
//            Log.d("Main",it.toString())
////            val observable = Observable.just(it)
////            observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).map {
//             //  viewModel.getEditText(this,dressEditText.text.toString())
//                rvDressList.adapter?.notifyDataSetChanged()
//           // }
//            rvDressList.adapter = EthnicWearAdapter(this,it)
//            rvDressList.layoutManager=LinearLayoutManager(this)
//        })
        dressAddButton.setOnClickListener {
            hideSoftKeyboard()
            viewModel.getEditText(this,dressEditText.text.toString())
//            rvDressList.adapter?.notifyDataSetChanged()
//            dressAddedText.text=dressEditText.text.toString()
        }

    }

    private fun hideSoftKeyboard() {
        if (currentFocus != null && currentFocus is EditText) {
            val inputManager:InputMethodManager =getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(dressEditText.windowToken, InputMethodManager.SHOW_FORCED)
        }
    }


}
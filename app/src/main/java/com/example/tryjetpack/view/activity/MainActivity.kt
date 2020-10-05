package com.example.tryjetpack.view.activity

import android.app.AppComponentFactory
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
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
    private val channelId= "channel1"
    private var notificationManager:NotificationManager?=null
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
            createChannel(channelId,"Dress Added","New Dress Added")
            displayNotification()
        }

    }

    private fun displayNotification(){
       val notificationId =45
        notificationManager=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val notification: Notification =NotificationCompat.Builder(this,channelId).setContentTitle("notification title")
            .setContentText("dress is ready content")
            .setSmallIcon(R.drawable.greysaree_background)
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .build()
     notificationManager?.notify(notificationId,notification)
    }

    private fun createChannel(id:String,name:String,channelDescription:String){
   if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
      val importance = NotificationManager.IMPORTANCE_HIGH
       val channel =NotificationChannel(id,name, importance).apply {
           description=channelDescription
       }
       notificationManager?.createNotificationChannel(channel)
   }
    }
    private fun hideSoftKeyboard() {
        if (currentFocus != null && currentFocus is EditText) {
            val inputManager:InputMethodManager =getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(dressEditText.windowToken, InputMethodManager.SHOW_FORCED)
        }
    }


}
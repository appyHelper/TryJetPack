package com.example.cattylibrary.di

import android.app.Application
import com.example.cattylibrary.service.DressApi
import com.example.cattylibrary.service.DressNetworkBuilder
import dagger.Module
import dagger.Provides

@Module
class DressApiServiceModule(application :Application) {

    @Provides
    fun providesDressRetrofitApi():DressApi{
       return DressNetworkBuilder.getDressRetrofitBuilder().create(DressApi::class.java)
    }
}
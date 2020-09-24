package com.example.tryjetpack.di

import android.app.Application
import com.example.tryjetpack.service.DressApi
import com.example.tryjetpack.service.DressNetworkBuilder
import dagger.Module
import dagger.Provides

@Module
class DressApiServiceModule(application :Application) {

    @Provides
    fun providesDressRetrofitApi():DressApi{
       return DressNetworkBuilder.getDressRetrofitBuilder().create(DressApi::class.java)
    }
}
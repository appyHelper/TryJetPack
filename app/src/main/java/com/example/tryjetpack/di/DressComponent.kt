package com.example.tryjetpack.di

import com.example.tryjetpack.view.activity.MainActivity
import dagger.Component

@Component (modules = [DressApiServiceModule::class])
interface DressComponent {

fun inject(obj1: MainActivity)
}
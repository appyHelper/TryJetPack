package com.example.cattylibrary.di

import com.example.cattylibrary.MainInteractorActivity

import dagger.Component

@Component (modules = [DressApiServiceModule::class])
interface DressComponent {

fun inject(obj1: MainInteractorActivity)
}
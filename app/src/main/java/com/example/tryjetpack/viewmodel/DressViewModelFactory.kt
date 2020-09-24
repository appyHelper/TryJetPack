package com.example.tryjetpack.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.Factory
import com.example.tryjetpack.repository.DressRepository
import javax.inject.Inject

class DressViewModelFactory @Inject constructor(val dressRepository: DressRepository) : Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       return DressViewModel(dressRepository) as T
    }
}
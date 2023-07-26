package com.example.myshop.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myshop.model.Product
import com.example.myshop.repository.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel:ViewModel() {
    val productsRepo= ProductRepository()
    val productsLiveData =MutableLiveData<List<Product>>()
    val errLiveData =MutableLiveData<String>()

    fun fetchProducts(){
        //launching a coroutine
       viewModelScope.launch {
           val response =productsRepo.getProducts()
           if (response.isSuccessful){
               productsLiveData.postValue(response.body()?.products)
           }
           else{
               errLiveData.postValue(response.errorBody()?.string())
           }

       }
    }
}

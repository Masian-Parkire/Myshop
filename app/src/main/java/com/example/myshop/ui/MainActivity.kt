package com.example.myshop.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myshop.databinding.ActivityMainBinding
import com.example.myshop.viewmodel.ProductViewModel

class MainActivity : AppCompatActivity() {
    val productsViewModel:ProductViewModel by viewModels()
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    override fun onResume() {
        super.onResume()
        productsViewModel.fetchProducts()

        productsViewModel.errLiveData.observe(this, Observer { err->
            Toast.makeText(baseContext, err, Toast.LENGTH_LONG).show()
        })

        productsViewModel.productsLiveData.observe(this, Observer { productsList->
            binding.rvProduct.layoutManager = GridLayoutManager(this@MainActivity,
                2)
            binding.rvProduct.adapter = ProductAdapter(productsList,this)
        })
    }
    }

//    fun fetchproduct(){
//        var apiClient = ApiClient.buildClient(ApiInterface::class.java)
//        var request = apiClient.getProducts()//function defined in the APi interface which is a specification
//        request.enqueue(object : Callback<ProductResponse> {
//            //the anonymous callback
//            override fun onResponse(call: Call<ProductResponse>, response: Response<ProductResponse>) {
//                if (response.isSuccessful){
//                    var product = response.body()?.products
//                    var productAdapater= ProductAdapater(product?: emptyList())
////                    binding.rvProduct.layoutManager=LinearLayoutManager(this@MainActivity)
//                    binding.rvProduct.layoutManager=GridLayoutManager(this@MainActivity,2)
//                    binding.rvProduct.adapter=productAdapater
//                    Toast.makeText(baseContext,
//                        "fetched ${product?.size} product" ,Toast.LENGTH_LONG).show()
//
//                }
//                else{
//                    Toast.makeText(baseContext,response.errorBody()?.string(),Toast.LENGTH_LONG).show()
//                }
//            }
//
//            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
//                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
//            }
//        })
//
//    }





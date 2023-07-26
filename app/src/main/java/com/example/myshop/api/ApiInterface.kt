package com.example.myshop.api

import com.example.myshop.model.Product
import com.example.myshop.model.ProductResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiInterface {
    @GET(("/product"))
    suspend fun getProducts():Response<ProductResponse>

   @GET("/product/{id}")
   suspend fun getProductsById(@Path("id")productId : Int):Response<Product>
    @GET("/product/{title}")
   suspend fun getProductsById(@Path("title")producttitle:String):Response<Product>

   @POST("/product/")
   fun postProduct(@Body product: Product):Call<Product>
}
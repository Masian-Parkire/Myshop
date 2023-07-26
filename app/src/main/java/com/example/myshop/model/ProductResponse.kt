package com.example.myshop.model

import com.example.myshop.model.Product

data class ProductResponse(
    var products: List<Product>,
    var total :Int,
    var skip :Int,
    var payment:Int
)

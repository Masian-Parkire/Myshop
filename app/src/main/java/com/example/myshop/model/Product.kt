package com.example.myshop.model

data class Product(
    var id :Int,
    var title:String,
    var description:String,
    var price : Double,
    var rating:Double,
    var stock:Int,
    var brand:String,
    var category:String,
    var thumbnail:String,
    var discountpercentage:Int,
    var image : String
)

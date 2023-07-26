package com.example.myshop.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myshop.databinding.ActivityProductDetailsBinding
import com.squareup.picasso.Picasso

class ProductDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val productId = intent.getStringExtra("PRODUCT_ID")
        val title = intent.getStringExtra("PRODUCT_TITLE")
        val thumbnail = intent.getStringExtra("PRODUCT_IMAGE")
        val description = intent.getStringExtra("PRODUCT_DESCRIPTION")
        val discount = intent.getIntExtra("PRODUCT_DISCOUNT", 0)
        val rating = intent.getDoubleExtra("PRODUCT_RATING", 0.0)
        val price = intent.getDoubleExtra("PRODUCT_PRICE", 0.0)
        val category = intent.getStringExtra("PRODUCT_CATEGORY")
        val stock = intent.getIntExtra("PRODUCT_STOCK", 0)

        populateProductDetails(
            productId, title, thumbnail, description, discount, rating, price, category, stock
        )
    }

    private fun populateProductDetails(
        productId: String?,
        title: String?,
        thumbnail: String?,
        description: String?,
        discount: Int,
        rating: Double,
        price: Double,
        category: String?,
        stock: Int
    ) {
        binding.tvtitl.text = title
        binding.tvdescribe.text = description
        binding.tvpricy.text = price.toString()
        binding.tvdiscount.text = discount.toString()
        binding.tvrate.text = rating.toString()
        binding.tvcategory.text = category
        binding.tvstock.text = stock.toString()

        Picasso.get()
            .load(thumbnail)
            .resize(250, 250)
            .centerCrop()
            .into(binding.ivproduct)
    }
}

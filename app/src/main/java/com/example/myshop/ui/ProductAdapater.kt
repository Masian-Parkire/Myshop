package com.example.myshop.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myshop.databinding.ProductListBinding
import com.example.myshop.model.Product
import com.squareup.picasso.Picasso

class ProductAdapter(private val productList: List<Product>, private val context: Context) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ProductListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val currentProduct = productList[position]
        val binding = holder.binding

        binding.tvtitle.text = currentProduct.title
        binding.tvdescription.text = currentProduct.description
        binding.tvprice.text = currentProduct.price.toString()

        Picasso.get()
            .load(currentProduct.thumbnail)
            .resize(250, 250)
            .centerCrop()
            .into(binding.ivavatar)

        holder.binding.cvProduct.setOnClickListener {
            val intent = Intent(context, ProductDetailsActivity::class.java)
            intent.putExtra("PRODUCT_ID", currentProduct.id)
            intent.putExtra("PRODUCT_TITLE", currentProduct.title)
            intent.putExtra("PRODUCT_IMAGE", currentProduct.thumbnail)
            intent.putExtra("PRODUCT_DESCRIPTION", currentProduct.description)
            intent.putExtra("PRODUCT_DISCOUNT", currentProduct.discountpercentage)
            intent.putExtra("PRODUCT_RATING", currentProduct.rating)
            intent.putExtra("PRODUCT_PRICE", currentProduct.price)
            intent.putExtra("PRODUCT_CATEGORY", currentProduct.category)
            intent.putExtra("PRODUCT_STOCK", currentProduct.stock)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    class ProductViewHolder(var binding: ProductListBinding) : RecyclerView.ViewHolder(binding.root)
}

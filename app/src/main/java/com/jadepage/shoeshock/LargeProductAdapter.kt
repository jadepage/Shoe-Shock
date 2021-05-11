package com.jadepage.shoeshock

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jadepage.shoeshock.databinding.ItemProductLargeBinding
import com.jadepage.shoeshock.models.ProductModel

class LargeProductAdapter(
        private val shoes: List<ProductModel>,
        private val onClick: (ProductModel) -> Unit
        ) : RecyclerView.Adapter<LargeProductAdapter.LargeProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LargeProductViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemProductLargeBinding.inflate(layoutInflater, parent, false)
        return LargeProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LargeProductViewHolder, position: Int) {
        val product = shoes[position]
        holder.bind(product)
        holder.itemView.setOnClickListener{
            onClick(product)

        }
    }

    override fun getItemCount() = shoes.size

    class LargeProductViewHolder(
            private val binding: ItemProductLargeBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(shoes: ProductModel) {
            binding.apply {
                productTitleText.text = shoes.title
                productModelText.text = shoes.model
                productPriceText.text = shoes.price
                productImage.setImageResource(shoes.image)
                background.setBackgroundColor(shoes.background)
            }
        }
    }
}
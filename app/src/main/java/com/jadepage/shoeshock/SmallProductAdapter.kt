package com.jadepage.shoeshock

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jadepage.shoeshock.databinding.ItemProductLargeBinding
import com.jadepage.shoeshock.databinding.ItemProductSmallBinding
import com.jadepage.shoeshock.models.ProductModel

class SmallProductAdapter(
        private val shoes: List<ProductModel>,
        private val onClick: (ProductModel) -> Unit
) : RecyclerView.Adapter<SmallProductAdapter.SmallProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SmallProductViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemProductSmallBinding.inflate(layoutInflater, parent, false)
        return SmallProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SmallProductViewHolder, position: Int) {
        val product = shoes[position]
        holder.bind(product)
        holder.itemView.setOnClickListener{
            onClick(product)
        }
    }

    override fun getItemCount() = shoes.size

    class SmallProductViewHolder(
            private val binding: ItemProductSmallBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(shoes: ProductModel) {
            binding.apply {
                productModelText.text = shoes.model
                productPriceText.text = shoes.price
                productImage.setImageResource(shoes.image)
                background.setBackgroundColor(shoes.background)
            }
        }
    }
}
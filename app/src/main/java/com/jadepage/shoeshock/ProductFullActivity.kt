package com.jadepage.shoeshock

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.jadepage.shoeshock.databinding.ItemProductFullBinding
import com.jadepage.shoeshock.repository.ShoeShockRepository

class ProductFullActivity : AppCompatActivity() {

    companion object {
        const val SHOE = "SHOE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ItemProductFullBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val shoes = intent.getStringExtra(SHOE).orEmpty()
        val product = ShoeShockRepository.getProduct(shoes)

        binding.fullProduct.apply {
            binding.productModelText.text = product.model
            binding.productPriceText.text = product.price
            binding.productDescriptionText.text = product.description
            binding.productImage.setImageResource(product.image)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
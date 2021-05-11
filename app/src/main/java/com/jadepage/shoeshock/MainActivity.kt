package com.jadepage.shoeshock

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.jadepage.shoeshock.databinding.ActivityMainBinding
import com.jadepage.shoeshock.models.ProductModel
import com.jadepage.shoeshock.repository.ShoeShockRepository

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.shoeLarge.apply {
            adapter = LargeProductAdapter(
                    ShoeShockRepository.getShoes()
            ) { productModel ->
                val intent = Intent(this@MainActivity, ProductFullActivity::class.java)
                intent.putExtra(ProductFullActivity.SHOE, productModel.model)
                startActivity(intent)
            }
            layoutManager = LinearLayoutManager(
                    this@MainActivity,
                    LinearLayoutManager.HORIZONTAL,
                    false
            )
            setHasFixedSize(true)
        }

        binding.shoeSmall.apply {
            adapter = SmallProductAdapter(
                    ShoeShockRepository.getShoes()
            ) {productModel ->
                val intent = Intent(this@MainActivity, ProductFullActivity::class.java)
                intent.putExtra(ProductFullActivity.SHOE, productModel.model)
                startActivity(intent)
            }
            layoutManager = LinearLayoutManager(
                    this@MainActivity,
                    LinearLayoutManager.HORIZONTAL,
                    false
            )
            setHasFixedSize(true)
        }
    }
}




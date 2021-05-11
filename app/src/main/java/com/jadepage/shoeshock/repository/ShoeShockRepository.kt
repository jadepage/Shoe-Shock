package com.jadepage.shoeshock.repository

import com.jadepage.shoeshock.R
import com.jadepage.shoeshock.models.ProductModel

object ShoeShockRepository {

    private val shoes =  mutableListOf(
            ProductModel(
                    "Nike",
                    "Air-270",
                    "$150.00",
                    "The Air Max 270 unit, and its subsequent shoe, " +
                            "is the first 100-percent lifestyle Air shoe — " +
                            "designed with the same rigor as sport performance" +
                            " but for the demands of all-day wear.",
                    R.drawable.peach, R.drawable.shoe01
            ),

            ProductModel(
                    "Nike",
                    "Air-Max",
                    "$170.00",
                    "Nike Air Max is a line of shoes produced by Nike," +
                            " Inc., with the first model released" +
                            " in 1987. Air Max shoes are identified by their " +
                            "midsoles incorporating flexible urethane pouches filled" +
                            " with pressurized gas",
                    R.drawable.light_blue, R.drawable.shoe2
            ),

            ProductModel(
                    "Nike",
                    "Air Force",
                    "$130.00",
                    "Designed by Bruce Kilgore and introduced in 1982," +
                            " the Air Force 1 was the first ever basketball shoe to" +
                            " feature Nike Air technology, revolutionizing the game ",
                    R.drawable.peach, R.drawable.shoe3
            ),

            ProductModel(
                    "Nike",
                    "Designer Model",
                    "$119.00",
                    "Your personal Nike co-creation starts here. " +
                            "Make something they've never seen before by " +
                            "creating your own iconic sneakers with Nike By You",
                    R.drawable.light_blue, R.drawable.shoe4
            ),

            ProductModel(
                    "Nike",
                    "Special Force",
                    "$199.00",
                    "Inspiring the world's athletes, Nike delivers" +
                            " innovative products, experiences and services.",
                    R.drawable.peach, R.drawable.shoe5)
    )

    fun getShoes() = shoes

    fun getProduct(product: String) : ProductModel {
        return when(product) {
            "Air-270" -> shoes[0]
            "Air-Max" -> shoes[1]
            "Air Force" -> shoes[2]
            "Designer Model" -> shoes[3]
            "Special Force" -> shoes[4]
            else -> ProductModel(
                    "",
                    "",
                    "",
                    "",
                    1,
                    1
            )
        }
    }
}
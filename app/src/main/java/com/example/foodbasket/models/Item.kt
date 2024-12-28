package com.example.foodbasket.models

import java.io.Serializable

class Item(
    var productId: Int? = null,
    var name: String,
    var price: Int?,
    val image: Int
) : Serializable
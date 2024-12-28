package com.example.foodbasket.database

import com.example.foodbasket.R
import com.example.foodbasket.models.Item

class ItemListDatabase {

    val itemList = mutableListOf(
        Item(null, "Яблоко", 100, R.drawable.apple),
        Item(null, "Банан", 50, R.drawable.banana),
        Item(null, "Морковь", 30, R.drawable.carrot),
        Item(null, "Картофель", 40, R.drawable.potato),
        Item(null, "Помидор", 70, R.drawable.tomato),
        Item(null, "Огурец", 60, R.drawable.cucumber),
        Item(null, "Апельсин", 80, R.drawable.orange),
        Item(null, "Клубника", 120, R.drawable.strawberry),
        Item(null, "Виноград", 150, R.drawable.grapes),
        Item(null, "Молоко", 90, R.drawable.milk),
        Item(null, "Сыр", 200, R.drawable.cheese)
    )
}
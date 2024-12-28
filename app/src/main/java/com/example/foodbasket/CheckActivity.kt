package com.example.foodbasket

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.foodbasket.database.DBHelper

import com.example.foodbasket.models.Item

class CheckActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private val dataBase = DBHelper(this)
    private var items: MutableList<Item> = mutableListOf()
    private lateinit var checkInfoTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check)

        init()

        loadCheckData()

    }

    private fun init() {
        toolbar = findViewById(R.id.toolbar)
        title = ""
        setSupportActionBar(toolbar)
        checkInfoTV = findViewById(R.id.checkInfoTV)
    }

    private fun loadCheckData() {
        items = dataBase.readData()
        updateCheckInfo(items, checkInfoTV)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.exitMenu) {
            finishAffinity()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun updateCheckInfo(itemList: List<Item>, checkInfoTV: TextView) {

        val sortedList = itemList.sortedBy { it.name }
        val stringBuilder = StringBuilder()
        var totalSum = 0
        val groupedItems = sortedList.groupBy { it.name }
        for ((name, items) in groupedItems) {
            val count = items.size
            val price = items.first().price ?: 0
            totalSum += price * count
            stringBuilder.append("$name x$count: ${price * count} руб.\n")
        }
        stringBuilder.append("\nОбщая сумма: $totalSum руб.")
        checkInfoTV.text = stringBuilder.toString()
    }
}
package com.example.foodbasket

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.TranslateAnimation
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodbasket.models.CustomAdapter
import com.example.foodbasket.models.Item
import com.example.foodbasket.models.MyDialog
import com.example.foodbasket.database.ItemListDatabase
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ProductActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private var adapter: CustomAdapter? = null
    private var items: MutableList<Item> = mutableListOf()
    private lateinit var recyclerViewRV: RecyclerView
    private lateinit var floatingActionButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        init()

        val animation = TranslateAnimation(300f, 0f, 0f, 0f)
        animation.duration = 1000
        animation.interpolator = AccelerateDecelerateInterpolator()
        floatingActionButton.startAnimation(animation)

        readItemList()

    }

    private fun init() {
        toolbar = findViewById(R.id.toolbar)
        title = ""
        setSupportActionBar(toolbar)
        floatingActionButton = findViewById(R.id.floatingActionButton)
        recyclerViewRV = findViewById(R.id.recyclerViewRV)
        recyclerViewRV.layoutManager = LinearLayoutManager(this)
    }

    override fun onResume() {
        super.onResume()

        adapter?.setOnItemClickListener(object :
            CustomAdapter.OnItemClickListener{
            override fun onItemClick(item: Item, position: Int) {
                val dialog = MyDialog()
                val args = Bundle()
                args.putSerializable("item", item)
                dialog.arguments = args
                dialog.show(supportFragmentManager, "custom")
            }
        }
        )

        floatingActionButton.setOnClickListener{
            val intent = Intent(this, BasketActivity::class.java)
            startActivity(intent)
        }

    }

    private fun readItemList() {
        items = ItemListDatabase().itemList
        adapter = CustomAdapter(items)
        recyclerViewRV.adapter = adapter
        recyclerViewRV.setHasFixedSize(true)
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


}
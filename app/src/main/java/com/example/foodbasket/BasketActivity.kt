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
import com.example.foodbasket.database.DBHelper
import com.example.foodbasket.models.CustomAdapter
import com.example.foodbasket.models.DeleteItemDialog
import com.example.foodbasket.models.Item
import com.example.foodbasket.utils.Updatable
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BasketActivity : AppCompatActivity(), Updatable {

    private lateinit var toolbar: Toolbar
    private var adapter: CustomAdapter? = null

    private var items: MutableList<Item> = mutableListOf()
    private lateinit var recyclerViewRV: RecyclerView
    private val dataBase = DBHelper(this)
    private lateinit var deleteFloatingActionButton: FloatingActionButton
    private lateinit var buyFloatingActionButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basket)

        init()

        val deleteButtonAnimation = TranslateAnimation(-300f, 0f, 0f, 0f)
        deleteButtonAnimation.duration = 1000
        deleteButtonAnimation.interpolator = AccelerateDecelerateInterpolator()
        deleteFloatingActionButton.startAnimation(deleteButtonAnimation)

        val buyButtonAnimation = TranslateAnimation(300f, 0f, 0f, 0f)
        buyButtonAnimation.duration = 1000
        buyButtonAnimation.interpolator = AccelerateDecelerateInterpolator()
        buyFloatingActionButton.startAnimation(buyButtonAnimation)

        deleteFloatingActionButton.setOnClickListener{
            dataBase.removeAll()
            val intent = Intent(this, ProductActivity::class.java)
            startActivity(intent)
        }

        buyFloatingActionButton.setOnClickListener{
            val intent = Intent(this, CheckActivity::class.java)
            startActivity(intent)
        }

    }

    private fun init() {
        toolbar = findViewById(R.id.toolbar)
        title = ""
        setSupportActionBar(toolbar)
        deleteFloatingActionButton = findViewById(R.id.deleteBasketFloatingActionButton)
        buyFloatingActionButton = findViewById(R.id.buyBasketFloatingActionButton)
        recyclerViewRV = findViewById(R.id.basketRecyclerViewRV)
        recyclerViewRV.layoutManager = LinearLayoutManager(this)
    }

    override fun onResume() {
        refreshData()
        super.onResume()
        adapter?.setOnItemClickListener(object :
            CustomAdapter.OnItemClickListener{
            override fun onItemClick(item: Item, position: Int) {
                val dialog = DeleteItemDialog()
                val args = Bundle()
                args.putSerializable("item", item)
                dialog.arguments = args
                dialog.show(supportFragmentManager, "custom")
            }
        }
        )
    }

    private fun refreshData() {
        items = dataBase.readData()
        adapter = CustomAdapter(items)
        recyclerViewRV.adapter = adapter
        recyclerViewRV.setHasFixedSize(true)
    }

    override fun update() {
        onResume()
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
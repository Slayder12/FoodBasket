package com.example.foodbasket

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.TranslateAnimation
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var imageView: ImageView
    private lateinit var startButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        val toolbarAnimation = TranslateAnimation(0f, 0f, -2000f, 0f)
        toolbarAnimation.duration = 1500
        toolbarAnimation.interpolator = AccelerateDecelerateInterpolator()
        toolbar.startAnimation(toolbarAnimation)

        imageView.alpha = 0f
        imageView.animate().alpha(1f).setDuration(1500).start()
        val imageAnimation = TranslateAnimation(0f, 0f, -2000f, 0f)
        imageAnimation.duration = 1500
        imageAnimation.interpolator = AccelerateDecelerateInterpolator()
        imageView.startAnimation(imageAnimation)

        val animation = TranslateAnimation(0f, 0f, 500f, 0f)
        animation.duration = 1500
        animation.interpolator = AccelerateDecelerateInterpolator()
        startButton.startAnimation(animation)

        startButton.setOnClickListener {
            val intent = Intent(this, ProductActivity::class.java)
            startActivity(intent)
        }

    }

    private fun init() {
        toolbar = findViewById(R.id.toolbar)
        title = ""
        setSupportActionBar(toolbar)
        imageView = findViewById(R.id.imageView)
        startButton = findViewById(R.id.startButton)
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
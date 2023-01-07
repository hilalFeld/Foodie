package com.recipes.foodie

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView

class HowToCook : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_how_to_cook)

        val BurgerHeading : TextView = findViewById(R.id.Header)
        val wayToCook : TextView = findViewById(R.id.TextOfCooking)
        val ImageOfBurger : ImageView = findViewById(R.id.BurgerImage)

        val bundle : Bundle? = intent.extras
        val header = bundle!!.getString("ingredients")
        val image = bundle!!.getInt("imageId")
        val cookWay = bundle!!.getString("burger")

        BurgerHeading.text = header
        ImageOfBurger.setImageResource(image)
        wayToCook.text = cookWay

    }
}
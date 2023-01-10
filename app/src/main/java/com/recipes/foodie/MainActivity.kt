package com.recipes.foodie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView1: RecyclerView
    private lateinit var foodList: ArrayList<FoodType>
    lateinit var imageId : Array<Int>
    lateinit var foodType : Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageId = arrayOf(
            R.drawable.burger
        )

        foodType = arrayOf(
            "Burgers"
        )

        newRecyclerView1 = findViewById(R.id.TypesOfFood)
        newRecyclerView1.layoutManager = LinearLayoutManager(this)
        newRecyclerView1.setHasFixedSize(true)

        foodList = arrayListOf<FoodType>()
        getUserNeed()
    }

    private fun getUserNeed() {

        for(index in imageId.indices) {

            val food = FoodType(imageId[index], foodType[index])
            foodList.add(food)
        }

        var adapter = MyAdapterFood(foodList)
        newRecyclerView1.adapter = adapter
        adapter.setOnItemClickListener(object : MyAdapterFood.onItemClickListener{
            override fun onItemClick(position: Int) {

                //Toast.makeText(this@MainActivity, "You clicked on item no. $position", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@MainActivity,SelectingType::class.java)
                startActivity(intent)

            }


        })
    }
}
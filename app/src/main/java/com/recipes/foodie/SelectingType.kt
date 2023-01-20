package com.recipes.foodie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SelectingType : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Burger>
    lateinit var imageId : Array<Int>
    lateinit var ingredients : Array<String>
    lateinit var burger : Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selecting_type)

        imageId = arrayOf(
            R.drawable.bigmac,
            R.drawable.cheeseburger,
            R.drawable.cheesycaramelised,
            R.drawable.buttermilkchickenburger,
            R.drawable.crispychickenburger,
            R.drawable.pizzaburger

        )

        ingredients = arrayOf(
            "Big M",
            "Cheeseburger",
            "Cheesy Caramelized",
            "Buttermilk Chicken Burger",
            "Crispy Chicken Burger",
            "Pizza Burger"
        )

        burger = arrayOf(
            getString(R.string.big_mac),
            getString(R.string.cheeseburger),
            getString(R.string.cheesy_caramelized),
            getString(R.string.buttermilk_chicken_burger),
            getString(R.string.crispy_chicken_burger),
            getString(R.string.pizza_burger)
        )

        newRecyclerView = findViewById(R.id.TypesOfBurgers)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Burger>()
        getUserNeed()
    }

    private fun getUserNeed() {

        for(index in imageId.indices) {

            val itemview = Burger(imageId[index], ingredients[index])
            newArrayList.add(itemview)
        }

        var adapter = MyAdapter(newArrayList)
        newRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {

                //Toast.makeText(this@MainActivity, "You clicked on item no. $position", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@SelectingType,HowToCook::class.java)
                intent.putExtra("ingredients",newArrayList[position].Ingredients)
                intent.putExtra("imageId",newArrayList[position].BurgerType)
                intent.putExtra("burger",burger[position])
                startActivity(intent)

            }





        })
    }
}
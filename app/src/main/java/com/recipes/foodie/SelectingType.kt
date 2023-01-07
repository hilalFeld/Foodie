package com.recipes.foodie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceActivity.Header
import android.widget.HeaderViewListAdapter
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
            R.drawable.chickenbarbecue,
            R.drawable.crispychickenburger,
            R.drawable.pizzaburger

        )

        ingredients = arrayOf(
            "Enter ingredients",
            "Enter ingredients",
            "Enter ingredients",
            "Enter ingredients",
            "Enter ingredients",
            "Enter ingredients"
        )

        burger = arrayOf(
            "Sauce Ingredients:\n" +
            "3 tbsp. mayonnaise \n" +
                    "3 tbsp. shallots, finely diced\n" +
                    "3 tbsp. dill pickles, finely diced \n" +
                    "3 tbsp. tomato ketchup \n" +
                    "1 tbsp. Dijon mustard  \n" +
                    "1/2 tsp. onion powder\n" +
                    "1/2 tsp. garlic powder\n" +
                    "1/2 tsp. sweet paprika \n" +
                    "1 tsp. white wine vinegar ",
            "Here is the way to cook",
            "Here is the way to cook",
            "Here is the way to cook",
            "Here is the way to cook",
            "Here is the way to cook"
        )

        newRecyclerView = findViewById(R.id.TypesOfBurgers)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Burger>()
        getUserNeed()
    }

    private fun getUserNeed() {

        for(index in imageId.indices) {

            val burger = Burger(imageId[index], ingredients[index])
            newArrayList.add(burger)
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
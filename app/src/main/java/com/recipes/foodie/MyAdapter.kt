package com.recipes.foodie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(private val burgerList : ArrayList<Burger>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener {

        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {

        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder { // onCreateViewHolder is called when you need a new View

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) { // if there is an available Recycled View that can be provided and be bound with new data, then onBindViewHolder is called

        val currentItem = burgerList[position]
        holder.burgerImage.setImageResource(currentItem.BurgerType)
        holder.burgerIngredients.text = currentItem.Ingredients
    }

    override fun getItemCount(): Int {
return        return burgerList.size // the adapter will know how many items are there in the recyclerView - the size of the ArrayList
    }

    class MyViewHolder(itemView: View, listener:onItemClickListener) : RecyclerView.ViewHolder(itemView){

        val burgerImage : ShapeableImageView = itemView.findViewById(R.id.BurgerImage)
        val burgerIngredients : TextView = itemView.findViewById(R.id.BurgerDescription)

        init {

            itemView.setOnClickListener {

                listener.onItemClick(adapterPosition)
            }
        }
    }
}
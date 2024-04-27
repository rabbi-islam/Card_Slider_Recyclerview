package com.example.cardSliderUsingRecyclerView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class DataAdapter (private val context: Context, private val dataList: List<DataModel>) :
    RecyclerView.Adapter<DataAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var phoneImage: ImageView

        init {
            phoneImage = view.findViewById(R.id.phone_image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.image_container, parent, false))
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.phoneImage.setImageResource(dataList[position].image)



        // Calculate the size adjustment based on the item's position
        // Calculate the scale adjustment based on the item's position
//        val scaleAdjustment = if (position == 0) {
//            0.9f // 20% larger
//        } else {
//            0.8f // 20% smaller
//        }
//        holder.itemView.scaleX = scaleAdjustment
//        holder.itemView.scaleY = scaleAdjustment

    }
}
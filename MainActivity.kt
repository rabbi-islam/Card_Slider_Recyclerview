package com.example.cardSliderUsingRecyclerView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dataAdapter: DataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.my_recycler)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val list: List<DataModel> = listOf(
            DataModel(R.drawable.alphabet),
            DataModel(R.drawable.numbers),
            DataModel(R.drawable.poco),
            DataModel(R.drawable.apple),
            DataModel(R.drawable.vivo)
        )
        dataAdapter = DataAdapter(this, list)
        //recyclerView.addItemDecoration(ItemDecoration(10))
        val screenWidth = resources.displayMetrics.widthPixels
        val centerX = resources.displayMetrics.widthPixels / 2
        val offset = (screenWidth / 2) - (850 / 2)
        recyclerView.setPadding(offset, 0, offset, 0)
        recyclerView.clipToPadding = false
        recyclerView.adapter = dataAdapter

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                // Loop through visible items to calculate scale adjustment
                for (i in 0 until recyclerView.childCount) {
                    val child = recyclerView.getChildAt(i)
                    val position = recyclerView.getChildAdapterPosition(child)
                    val childCenterX = (child.left + child.right) / 2
                    val distanceFromCenter = Math.abs(centerX - childCenterX).toFloat()

                    // Calculate scale adjustment based on distance from center
                    val scaleAdjustment =
                        1 - distanceFromCenter / centerX // Adjust scale factor as needed

                    // Apply scale adjustment to the item
                    child.scaleX = scaleAdjustment
                    child.scaleY = scaleAdjustment
                }
            }


        })
    }


}
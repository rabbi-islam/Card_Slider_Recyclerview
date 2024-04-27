package com.example.cardSliderUsingRecyclerView

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ItemDecoration(private val gapSize: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.left = gapSize
        outRect.right = gapSize
        // Optionally add gaps at the beginning and end of the list:
        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.left = gapSize * 2 // Double gap for the first item
        }
        if (parent.getChildAdapterPosition(view) == parent.adapter!!.itemCount - 1) {
            outRect.right = gapSize * 2 // Double gap for the last item
        }
    }
}
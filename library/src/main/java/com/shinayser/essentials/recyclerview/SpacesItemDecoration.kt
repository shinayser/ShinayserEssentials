package com.shinayser.essentials.recyclerview

import android.graphics.Rect
import androidx.recyclerview.widget.RecyclerView
import android.view.View

/**
 * Created by Daniel Oliveira on 26/02/2016.
 */
open class SpacesItemDecoration(private val space: Int) : androidx.recyclerview.widget.RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: androidx.recyclerview.widget.RecyclerView, state: androidx.recyclerview.widget.RecyclerView.State) {

        outRect.left = space / 2
        outRect.right = space / 2
        outRect.bottom = space

        // Add top margin only for the first item to avoid double space between items
        //            if(parent.getChildPosition(view) == 0)
        //                outRect.top = space;

    }
}

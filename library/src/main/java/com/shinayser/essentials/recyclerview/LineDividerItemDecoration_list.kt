package com.shinayser.essentials.recyclerview

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Daniel Oliveira on 26/02/2016.
 */
open class LineDividerItemDecoration_list(context: Context, val separator: Drawable) : androidx.recyclerview.widget.RecyclerView.ItemDecoration() {

    override fun onDrawOver(c: Canvas, parent: androidx.recyclerview.widget.RecyclerView, state: androidx.recyclerview.widget.RecyclerView.State) {
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight

        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)

            val params = child.layoutParams as androidx.recyclerview.widget.RecyclerView.LayoutParams

            val top = child.bottom + params.bottomMargin
            val bottom = top + separator.intrinsicHeight

            separator.setBounds(left, top, right, bottom)
            separator.draw(c)
        }
    }


}

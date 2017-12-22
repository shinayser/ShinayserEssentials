package com.shinayser.essentials.recyclerview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View

class LineDividerItemDecoration_grid(context: Context, val divider: Drawable) : RecyclerView.ItemDecoration() {

    private var mOrientation: Int = 0

    init {
//        val a = context.obtainStyledAttributes(ATTRS)
//        a.recycle()
        setOrientation(GRID)
    }

    private fun setOrientation(orientation: Int) {
        if (orientation != HORIZONTAL_LIST && /*orientation != VERTICAL_LIST && */ orientation != GRID) {
            throw IllegalArgumentException("invalid orientation")
        }
        mOrientation = orientation
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {

        when (mOrientation) {
//            VERTICAL_LIST -> drawVertical(c, parent)
            HORIZONTAL_LIST -> drawHorizontal(c, parent)
            else -> {
                drawVertical(c, parent)
                drawHorizontal(c, parent)
            }
        }
    }

    private fun drawVertical(c: Canvas, parent: RecyclerView) {
        if (parent.childCount == 0) return

        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight

        val child = parent.getChildAt(0)
        if (child.height == 0) return

        val params = child.layoutParams as RecyclerView.LayoutParams
        var top = child.bottom + params.bottomMargin + divider.intrinsicHeight
        var bottom = top + divider.intrinsicHeight

        val parentBottom = parent.height - parent.paddingBottom
        while (bottom < parentBottom) {
            divider.setBounds(left, top, right, bottom)
            divider.draw(c)

            top += divider.intrinsicHeight + params.topMargin + child.height + params.bottomMargin + divider.intrinsicHeight
            bottom = top + divider.intrinsicHeight
        }
    }

    private fun drawHorizontal(c: Canvas, parent: RecyclerView) {
        val top = parent.paddingTop
        val bottom = parent.height - parent.paddingBottom

        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)
            val params = child.layoutParams as RecyclerView.LayoutParams
            val left = child.right + params.rightMargin + divider.intrinsicHeight
            val right = left + divider.intrinsicWidth
            divider.setBounds(left, top, right, bottom)
            divider.draw(c)
        }
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
//        if (mOrientation == VERTICAL_LIST) {
//            outRect.set(0, 0, 0, divider.intrinsicHeight)
//        } else
        if (mOrientation == HORIZONTAL_LIST) {
            outRect.set(0, 0, divider.intrinsicWidth, 0)
        } else {
            outRect.set(0, 0, divider.intrinsicWidth, divider.intrinsicHeight)
        }
    }

    companion object {
//        private val ATTRS = intArrayOf(android.R.attr.listDivider)

        val HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL
        //        val VERTICAL_LIST = LinearLayoutManager.VERTICAL
        val GRID = 2
    }
}
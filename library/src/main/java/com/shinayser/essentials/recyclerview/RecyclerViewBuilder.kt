package com.shinayser.essentials.recyclerview

import android.content.Context
import android.databinding.ViewDataBinding
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.shinayser.essentials.R
import com.shinayser.essentials.util.fromResDrawableTinted
import com.shinayser.essentials.util.fromResInteger
import org.jetbrains.anko.displayMetrics

/**
 * Created by denox on 22/12/2017.
 */
class RecyclerViewBuilder(private var recycler: RecyclerView) {

    var spacing = 0
    var layoutType: RecyclerLayoutType? = null
    var layoutAnimation = 0
    var adapter: RecyclerView.Adapter<*>? = null
    var divider: Drawable? = null

    fun <ITEM, BINDER : ViewDataBinding> onBindViewHolder(itemLayoutRes: Int, list: MutableList<ITEM>, f: (item: ITEM, holder: SimpleViewHolder<BINDER>) -> Unit) {
        adapter = object : SimpleRecyclerAdapter<ITEM, BINDER>(recycler.context, itemLayoutRes, list) {

            override fun onBind(item: ITEM, holder: SimpleViewHolder<BINDER>) {
                f(item, holder)
            }

        }
    }

    fun colorDivider(color: Int = Color.BLACK) {
        divider = R.drawable.divider_drawable.fromResDrawableTinted(recycler.context, color)
    }

    fun build() {
        val context = recycler.context

        //Spacing///////////////////////////////////////////////////////////////////////////////////
        if (spacing > 0) {
            val spacingInPixel = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, spacing.toFloat(), context.displayMetrics)
            recycler.addItemDecoration(SpacesItemDecoration(spacingInPixel.toInt()))
        }

        //LayoutType////////////////////////////////////////////////////////////////////////////////
        when (layoutType) {
            is Linear -> {
                recycler.layoutManager = LinearLayoutManager(context)

                divider?.let {
                    recycler.addItemDecoration(LineDividerItemDecoration_list(context, it))
                }

            }

            is CustomSpanGrid -> {
                val gridType = layoutType as CustomSpanGrid
                if (gridType.spanCount != null) {
                    recycler.layoutManager = GridLayoutManager(context, gridType.spanCount!!)

                    divider?.let {
                        //                        if (gridType.spanCount!! > 1) {
//                            recycler.addItemDecoration(LineDividerItemDecoration_grid(context, it))
//                        } else {
                        recycler.addItemDecoration(LineDividerItemDecoration_list(context, it))
//                        }
                    }

                } else {
                    val spanCount = R.integer.recycler_view_builder_span_count.fromResInteger(context)
                    recycler.layoutManager = GridLayoutManager(context, spanCount)

                    divider?.let {
                        //                        if (spanCount > 1) {
//                            recycler.addItemDecoration(LineDividerItemDecoration_grid(context, it))
//                        } else {
                        recycler.addItemDecoration(LineDividerItemDecoration_list(context, it))
//                        }
                    }

                }

            }

            is DefaultGrid -> {
                val defaultGrid = layoutType as DefaultGrid
                val spanCount = R.integer.recycler_view_builder_span_count.fromResInteger(context) * defaultGrid.multiplier
                recycler.layoutManager = GridLayoutManager(context, spanCount)

                divider?.let {
                    //                    if (spanCount > 1) {
//                        recycler.addItemDecoration(LineDividerItemDecoration_grid(context, it))
//                    } else {
                    recycler.addItemDecoration(LineDividerItemDecoration_list(context, it))
//                    }
                }

            }

        }

        //Layout Animation//////////////////////////////////////////////////////////////////////////
        if (layoutAnimation != 0) {
            recycler.layoutAnimation = AnimationUtils.loadLayoutAnimation(context, layoutAnimation)
            recycler.scheduleLayoutAnimation()
        }

        //Adapter
        adapter?.let {
            recycler.adapter = this.adapter
        }


    }

}

fun RecyclerView.init(f: RecyclerViewBuilder.() -> Unit) = RecyclerViewBuilder(this).apply(f).build()


sealed class RecyclerLayoutType
class Linear : RecyclerLayoutType()
data class DefaultGrid(var multiplier: Int = 1) : RecyclerLayoutType()
data class CustomSpanGrid(var spanCount: Int? = null) : RecyclerLayoutType()


abstract class SimpleRecyclerAdapter<ITEM, BINDER : ViewDataBinding>(
        val context: Context,
        val viewRes: Int,
        var list: MutableList<ITEM>) : RecyclerView.Adapter<SimpleViewHolder<BINDER>>() {

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SimpleViewHolder<BINDER> = SimpleViewHolder(View.inflate(context, viewRes, null))

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: SimpleViewHolder<BINDER>?, position: Int) {
        onBind(list[position], holder!!)
    }

    override fun getItemId(position: Int) = list[position]?.hashCode()?.toLong() ?: 0

    abstract fun onBind(item: ITEM, holder: SimpleViewHolder<BINDER>)

}



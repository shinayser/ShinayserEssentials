package com.shinayser.essentials.recyclerview

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.View

class SimpleViewHolder<T : ViewDataBinding>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var last: Any? = null

    var binding: T
        internal set

    init {
        binding = DataBindingUtil.bind(itemView)!!
    }

}
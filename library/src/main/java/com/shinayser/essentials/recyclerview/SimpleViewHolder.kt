package com.shinayser.essentials.recyclerview

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import android.view.View

class SimpleViewHolder<T : ViewDataBinding>(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {

    var last: Any? = null

    var binding: T
        internal set

    init {
        binding = DataBindingUtil.bind(itemView)!!
    }

}
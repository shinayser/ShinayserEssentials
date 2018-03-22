package com.shinayser.essentials.util

import android.view.View
import android.widget.AdapterView

/**
 * Created by danieloliveira on 22/03/18.
 */


fun AdapterView<*>.onItemSelected(lambda: (parent: AdapterView<*>?, view: View?, position: Int, id: Long) -> Unit) {

    this.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(parent: AdapterView<*>?) {}

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            lambda(parent, view, position, id)
        }

    }
}
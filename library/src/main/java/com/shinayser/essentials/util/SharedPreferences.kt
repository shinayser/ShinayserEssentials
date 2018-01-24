package com.shinayser.essentials.util

import android.annotation.SuppressLint
import android.content.SharedPreferences

/**
 * Created by Daniel Oliveira on 19/12/2017.
 */

@SuppressLint("ApplySharedPref")
fun SharedPreferences.editAndCommit(block: SharedPreferences.Editor.() -> Unit) {
    edit().apply {
        this.block()
    }.commit()
}

fun SharedPreferences.editAndApply(block: SharedPreferences.Editor.() -> Unit) {
    edit().apply {
        this.block()
    }.apply()
}
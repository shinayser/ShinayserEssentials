package com.shinayser.essentials.util

import android.animation.Animator
import android.animation.ObjectAnimator
import android.support.v7.widget.SwitchCompat
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.*

/**
 * Created by denox on 10/11/2017.
 */
fun View.visible() { visibility = View.VISIBLE }
fun View.gone() { visibility = View.GONE }
fun View.invisible() { visibility = View.INVISIBLE }

fun View.findTextView(resId: Int): TextView = findViewById(resId)
fun View.findEditText(resId: Int): EditText = findViewById(resId)
fun View.findImageView(resId: Int): ImageView = findViewById(resId)
fun View.findSwitchCompat(resId: Int): SwitchCompat = findViewById(resId)
fun View.findSpinner(resId: Int): Spinner = findViewById(resId)
fun View.findCheckBox(resId: Int): CheckBox = findViewById(resId)
fun View.findButton(resId: Int): Button = findViewById(resId)
fun View.findImageButton(resId: Int): ImageButton = findViewById(resId)
fun View.findToolbar(resId: Int): Toolbar = findViewById(resId)

fun View.propertyAnimation(property: String, duration: Long, fromValue: Float, toValue: Float, listener: Animator.AnimatorListener? = null) {
    val objectAnimation = ObjectAnimator.ofFloat(this, property, fromValue, toValue)
    objectAnimation.duration = duration
    listener?.let { objectAnimation.addListener(listener) }
    objectAnimation.start()
}

fun View.propertyAnimation(property: String, duration: Long, fromValue: Int, toValue: Int, listener: Animator.AnimatorListener? = null) {
    val objectAnimation = ObjectAnimator.ofInt(this, property, fromValue, toValue)
    objectAnimation.duration = duration
    listener?.let { objectAnimation.addListener(listener) }
    objectAnimation.start()
}
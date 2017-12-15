package com.shinayser.essentials.util

import android.animation.Animator
import android.view.View
import com.daimajia.androidanimations.library.YoYo

/**
 * Created by denox on 15/12/2017.
 */
fun View.yoyoAnimation(technique: com.daimajia.androidanimations.library.Techniques, duration: Long = 300, listener: Animator.AnimatorListener? = null): View {
    if (listener != null) {
        YoYo.with(technique).duration(duration).withListener(listener).playOn(this)
    } else {
        YoYo.with(technique).duration(duration).playOn(this)
    }

    return this
}

fun View.yoyoAnimation(technique: com.daimajia.androidanimations.library.Techniques, duration: Long = 300, listener: AnimatorAdapterBuilder.() -> Unit): View {
    return yoyoAnimation(technique, duration, AnimatorAdapterBuilder().apply(listener))
}

//fun View.yoyoAnimation(technique: com.daimajia.androidanimations.library.Techniques, listener: AnimatorAdapterBuilder.() -> Unit): View {
//    return yoyoAnimation(technique, listener = AnimatorAdapterBuilder().apply(listener))
//}


private typealias Listener = (Animator?) -> Unit

class AnimatorAdapterBuilder : Animator.AnimatorListener {

    var animationRepeat: Listener? = null
    var animationEnd: Listener? = null
    var animationCancel: Listener? = null
    var animationStart: Listener? = null

    override fun onAnimationRepeat(animation: Animator?) {
        animationRepeat?.invoke(animation)
    }

    override fun onAnimationEnd(animation: Animator?) {
        animationEnd?.invoke(animation)
    }

    override fun onAnimationCancel(animation: Animator?) {
        animationCancel?.invoke(animation)
    }

    override fun onAnimationStart(animation: Animator?) {
        animationStart?.invoke(animation)
    }

    fun AnimatorAdapterBuilder.atEnd(listener: Listener) {
        animationEnd = listener
    }

    fun AnimatorAdapterBuilder.atRepeat(listener: Listener) {
        animationRepeat = listener
    }

    fun AnimatorAdapterBuilder.atCancel(listener: Listener) {
        animationCancel = listener
    }

    fun AnimatorAdapterBuilder.atStart(listener: Listener) {
        animationStart = listener
    }

}


fun animatorAdapter(block: AnimatorAdapterBuilder.() -> Unit): AnimatorAdapterBuilder {
    val animator = AnimatorAdapterBuilder()
    animator.block()
    return animator
}
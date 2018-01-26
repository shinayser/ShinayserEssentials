package com.shinayser.essentials.simplifiedconditions

import android.os.Build

/**
 * Created by Daniel Oliveira on 24/01/2018.
 */

inline fun onAPILevel(apiLevel: Int, lambda: () -> Unit): ExecutedCode {

    return if (Build.VERSION.SDK_INT >= apiLevel) {
        lambda()
        ExecutedCode(true)
    } else {
        ExecutedCode(false)
    }

}

inline fun onJellyBean(lambda: () -> Unit) = onAPILevel(Build.VERSION_CODES.JELLY_BEAN, lambda)
inline fun onJellyBeanMR1(lambda: () -> Unit) = onAPILevel(Build.VERSION_CODES.JELLY_BEAN_MR1, lambda)
inline fun onJellyBeanMR2(lambda: () -> Unit) = onAPILevel(Build.VERSION_CODES.JELLY_BEAN_MR2, lambda)
inline fun onKitkat(lambda: () -> Unit) = onAPILevel(Build.VERSION_CODES.KITKAT, lambda)
inline fun onLollipop(lambda: () -> Unit) = onAPILevel(Build.VERSION_CODES.LOLLIPOP, lambda)
inline fun onLollipopMR1(lambda: () -> Unit) = onAPILevel(Build.VERSION_CODES.LOLLIPOP_MR1, lambda)
inline fun onMarshmallow(lambda: () -> Unit) = onAPILevel(Build.VERSION_CODES.M, lambda)
inline fun onNougat(lambda: () -> Unit) = onAPILevel(Build.VERSION_CODES.N, lambda)
inline fun onNougatMR1(lambda: () -> Unit) = onAPILevel(Build.VERSION_CODES.N_MR1, lambda)
inline fun onOreo(lambda: () -> Unit) = onAPILevel(Build.VERSION_CODES.O, lambda)

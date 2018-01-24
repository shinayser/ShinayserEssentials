package com.shinayser.essentials.simplifiedconditions

/**
 * Created by daniel on 24/01/2018.
 */

inline fun ifNotNull(vararg params: Any?, lambda: () -> Unit) =
        if (params.all { it != null }) {
            lambda()
            ExecutedCode(true)
        } else {
            ExecutedCode(false)
        }

inline fun ifAnyNull(vararg params: Any?, lambda: () -> Unit) =
        if (params.any { it == null }) {
            lambda()
            ExecutedCode(true)
        } else {
            ExecutedCode(false)
        }

inline fun ifAllNull(vararg params: Any?, lambda: () -> Unit) =
        if (params.all { it == null }) {
            lambda()
            ExecutedCode(true)
        } else {
            ExecutedCode(false)
        }
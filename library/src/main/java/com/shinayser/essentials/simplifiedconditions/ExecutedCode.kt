package com.shinayser.essentials.simplifiedconditions

/**
 * Created by Daniel Oliveira on 24/01/2018.
 */
data class ExecutedCode(val executed: Boolean)

infix fun ExecutedCode.otherwise(lambda: () -> Unit) {

    if (!executed) {
        lambda()
    }

}
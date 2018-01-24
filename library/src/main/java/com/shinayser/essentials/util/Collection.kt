package com.shinayser.essentials.util

import java.util.ArrayList

/**
 * Created by Daniel Oliveira on 10/11/2017.
 */
fun <T> ArrayList<T>.replaceAt(index: Int, newObject: T) {
    removeAt(index)
    add(index, newObject)
}

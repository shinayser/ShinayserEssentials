package com.shinayser.essentials.util

import java.util.*

/**
 * Created by denox on 10/11/2017.
 */

private object Names {
    var names = arrayOf("Daniel", "Pedro", "Eduardo", "Hugo", "Marco", "Rafaela", "Petterson", "Fernando", "Allan", "Rogério", "Marcelo", "Gustavo", "Ramon", "Patrícia", "Vinícius", "Carlos", "Marcela", "Fernanda", "Carolina")
    var lastnames = arrayOf("Lima", "Oliveira", "Barbosa", "Motta", "Aurélio", "Bhaktin", "Rodrigues", "Henrique", "Andrade", "Santos", "Augusto", "Silva", "Fernandes")
    var vowels = arrayOf("a", "e", "i", "o", "u")
    var consonant = arrayOf("b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v", "w", "x", "y", "z")
}


fun randomInt(max: Int = Int.MAX_VALUE) = randomInt(min = 1, max = max)
fun randomInt(min: Int, max: Int): Int {
    var minAux = min
    var maxAux = max

    if (min > max) {
        maxAux = min
        minAux = min
    }

    return (Math.random() * (maxAux - minAux)).toInt() + minAux
}

fun randomLong(max: Long = Long.MAX_VALUE) = randomLong(min = 1L, max = max)
fun randomLong(min: Long, max: Long): Long {
    var minAux = min
    var maxAux = max

    if (min > max) {
        maxAux = min
        minAux = min
    }

    return (Math.random() * (maxAux - minAux)).toInt() + minAux
}

fun randomDouble(max: Double = Double.MAX_VALUE) = randomDouble(min = 1.0, max = max)
fun randomDouble(min: Double, max: Double): Double {
    var minAux = min
    var maxAux = max

    if (min > max) {
        maxAux = min
        minAux = min
    }

    return (Math.random() * (maxAux - minAux)) + minAux
}

fun randomString(startsWithVowel: Boolean = false, maxLenght: Int): String {

    var toReturn = ""
    if (startsWithVowel) {
        //Starts with vowel
        toReturn += Names.vowels[randomInt(Names.vowels.size) - 1].toUpperCase()

        for (i in 1 until maxLenght) {
            toReturn += if (i % 2 == 0) {
                Names.vowels[randomInt(Names.vowels.size) - 1]
            } else {
                Names.consonant[randomInt(Names.consonant.size) - 1]
            }
        }

    } else {

        //Starts with consonant
        toReturn += Names.consonant[randomInt(Names.consonant.size) - 1].toUpperCase()

        for (i in 1 until maxLenght) {
            toReturn += if (i % 2 == 0) {
                Names.consonant[randomInt(Names.consonant.size) - 1]
            } else {
                Names.vowels[randomInt(Names.vowels.size) - 1]
            }
        }
    }


    return toReturn
}

fun randomDate() =
        Calendar.getInstance().apply {
            dayOfMonth = randomInt(1, 30)
            month = randomInt(1, 11)
            year = randomInt(1900, Calendar.getInstance().get(Calendar.YEAR))
            hour = randomInt(24) - 1
            minute = randomInt(60) - 1
            second = randomInt(60) - 1
        }.time!!


fun randomName(): String = Names.names[randomInt(Names.names.size) - 1]
fun randomFullName(): String = Names.names[randomInt(Names.names.size) - 1] + " " + Names.lastnames[randomInt(Names.lastnames.size) - 1]
fun randomStringFromArray(strings: Array<String>) = strings[randomInt(strings.size) - 1]
fun <T> randomFrom(vararg itens: T) = itens[(Math.random() * itens.size).toInt()]

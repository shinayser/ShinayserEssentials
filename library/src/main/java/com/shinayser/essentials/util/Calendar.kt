package com.shinayser.essentials.util

import java.util.*

/**
 * Created by denox on 10/11/2017.
 */
var Calendar.year: Int
    get() = this.get(Calendar.YEAR)
    set(value) = this.set(Calendar.YEAR, value)

var Calendar.month: Int
    get() = this.get(Calendar.MONTH)
    set(value) = this.set(Calendar.MONTH, value)

var Calendar.hour: Int
    get() = this.get(Calendar.HOUR_OF_DAY)
    set(value) = this.set(Calendar.HOUR_OF_DAY, value)

var Calendar.dayOfMonth: Int
    get() = this.get(Calendar.DAY_OF_MONTH)
    set(value) = this.set(Calendar.DAY_OF_MONTH, value)

var Calendar.minute: Int
    get() = this.get(Calendar.MINUTE)
    set(value) = this.set(Calendar.MINUTE, value)

var Calendar.second: Int
    get() = this.get(Calendar.SECOND)
    set(value) = this.set(Calendar.SECOND, value)

var Calendar.milisecond: Int
    get() = this.get(Calendar.MILLISECOND)
    set(value) = this.set(Calendar.MILLISECOND, value)
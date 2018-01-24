package com.shinayser.essentials.util

import android.database.Cursor

/**
 * Created by Daniel Oliveira on 10/11/2017.
 */
fun Cursor.getStringOrNull(columnName: String): String? {
    return if (!this.isNull(this.getColumnIndex(columnName))) {
        this.getString(this.getColumnIndex(columnName))
    } else {
        null
    }
}

fun Cursor.getIntOrNull(columnName: String): Int? {
    return if (!this.isNull(this.getColumnIndex(columnName))) {
        this.getInt(this.getColumnIndex(columnName))
    } else {
        null
    }
}

fun Cursor.getDoubleOrNull(columnName: String): Double? {
    return if (!this.isNull(this.getColumnIndex(columnName))) {
        this.getDouble(this.getColumnIndex(columnName))
    } else {
        null
    }
}

fun Cursor.getFloatOrNull(columnName: String): Float? {
    return if (!this.isNull(this.getColumnIndex(columnName))) {
        this.getFloat(this.getColumnIndex(columnName))
    } else {
        null
    }
}

fun Cursor.getLongOrNull(columnName: String): Long? {
    return if (!this.isNull(this.getColumnIndex(columnName))) {
        this.getLong(this.getColumnIndex(columnName))
    } else {
        null
    }
}

fun Cursor.getBlobOrNull(columnName: String): ByteArray? {
    return if (!this.isNull(this.getColumnIndex(columnName))) {
        this.getBlob(this.getColumnIndex(columnName))
    } else {
        null
    }
}
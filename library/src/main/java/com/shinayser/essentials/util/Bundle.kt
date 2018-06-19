package com.shinayser.essentials.util

import android.os.Bundle
import android.os.Parcelable
import org.jetbrains.anko.AnkoException
import java.io.Serializable
import kotlin.reflect.KProperty

/**
 * Created by Daniel Oliveira on 19/06/2018.
 */
operator fun <T, R> Bundle.getValue(thisRef: T, property: KProperty<*>): R {
	val name = property.name
	return this.get(name) as R
}


operator fun <T, V : Any> Bundle.setValue(thisRef: T, property: KProperty<*>, value: V) {

	when (value) {
		is Boolean -> putBoolean(property.name, value)
		is Byte -> putByte(property.name, value)
		is Char -> putChar(property.name, value)
		is Short -> putShort(property.name, value)
		is Int -> putInt(property.name, value)
		is Long -> putLong(property.name, value)
		is Float -> putFloat(property.name, value)
		is Double -> putDouble(property.name, value)
		is String -> putString(property.name, value)
		is CharSequence -> putCharSequence(property.name, value)
		is Parcelable -> putParcelable(property.name, value)
		is Serializable -> putSerializable(property.name, value)
		is BooleanArray -> putBooleanArray(property.name, value)
		is ByteArray -> putByteArray(property.name, value)
		is CharArray -> putCharArray(property.name, value)
		is DoubleArray -> putDoubleArray(property.name, value)
		is FloatArray -> putFloatArray(property.name, value)
		is IntArray -> putIntArray(property.name, value)
		is LongArray -> putLongArray(property.name, value)
		is Array<*> -> {

			@Suppress("UNCHECKED_CAST")
			when {
				value.isArrayOf<Parcelable>() -> putParcelableArray(property.name, value as Array<out Parcelable>)
				value.isArrayOf<CharSequence>() -> putCharSequenceArray(property.name, value as Array<out CharSequence>)
				value.isArrayOf<String>() -> putStringArray(property.name, value as Array<out String>)
				else -> throw AnkoException("Unsupported bundle component (${value.javaClass})")
			}
		}
		is ShortArray -> putShortArray(property.name, value)
		is Bundle -> putBundle(property.name, value)
		else -> throw AnkoException("Unsupported bundle component (${value.javaClass})")
	}

}
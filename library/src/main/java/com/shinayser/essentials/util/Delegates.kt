package com.shinayser.essentials.util

import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

interface ReadOnlyDelegateProvider<T, R> {
	//Pay attention to the "operator" modifier. The IDE does not add this operator automatically,
	//so you must add it by hand or the delegate will not work
	operator fun provideDelegate(thisRef: T, prop: KProperty<*>): ReadOnlyProperty<T, R>
}

interface ReadWriteDelegateProvider<T, R> {
	//Pay attention to the "operator" modifier. The IDE does not add this operator automatically,
	//so you must add it by hand or the delegate will not work
	operator fun provideDelegate(thisRef: T, prop: KProperty<*>): ReadWriteProperty<T, R>
}
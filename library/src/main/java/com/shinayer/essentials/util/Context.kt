package com.shinayer.essentials.util

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import org.jetbrains.anko.bundleOf

/**
 * Created by denox on 10/11/2017.
 */
//Fragment creation
fun Context.fragmentOf(fragmentName: String, bundle: Bundle? = null): Fragment = Fragment.instantiate(this, fragmentName, bundle)
fun Context.fragmentOf(fragmentName: String, vararg pairs: Pair<String, Any>) = fragmentOf(fragmentName, bundleOf(*pairs))
inline fun <reified T> Context.fragmentOf(vararg pairs: Pair<String, Any>): T = fragmentOf(T::class.java.name, bundleOf(*pairs)) as T
inline fun <reified T> Context.fragmentOf(bundle: Bundle? = null): T = fragmentOf(T::class.java.name, bundle) as T
fun Fragment.fragmentOf(fragmentName: String, bundle: Bundle? = null): Fragment = Fragment.instantiate(activity, fragmentName, bundle)
fun Fragment.fragmentOf(fragmentName: String, vararg pairs: Pair<String, Any>) = fragmentOf(fragmentName, bundleOf(*pairs))
inline fun <reified T> Fragment.fragmentOf(vararg pairs: Pair<String, Any>): T = fragmentOf(T::class.java.name, bundleOf(*pairs)) as T
inline fun <reified T> Fragment.fragmentOf(bundle: Bundle? = null): T = fragmentOf(T::class.java.name, bundle) as T
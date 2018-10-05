package com.shinayser.essentials.util

import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AlertDialog
import org.jetbrains.anko.bundleOf

/**
 * Created by Daniel Oliveira on 10/11/2017.
 */
//Fragment creation
fun Context.fragmentOf(fragmentName: String, bundle: Bundle? = null): androidx.fragment.app.Fragment = androidx.fragment.app.Fragment.instantiate(this, fragmentName, bundle)
fun Context.fragmentOf(fragmentName: String, vararg pairs: Pair<String, Any>) = fragmentOf(fragmentName, bundleOf(*pairs))
inline fun <reified T> Context.fragmentOf(vararg pairs: Pair<String, Any>): T = fragmentOf(T::class.java.name, bundleOf(*pairs)) as T
inline fun <reified T> Context.fragmentOf(bundle: Bundle? = null): T = fragmentOf(T::class.java.name, bundle) as T
fun androidx.fragment.app.Fragment.fragmentOf(fragmentName: String, bundle: Bundle? = null): androidx.fragment.app.Fragment = androidx.fragment.app.Fragment.instantiate(activity, fragmentName, bundle)
fun androidx.fragment.app.Fragment.fragmentOf(fragmentName: String, vararg pairs: Pair<String, Any>) = fragmentOf(fragmentName, bundleOf(*pairs))
inline fun <reified T> androidx.fragment.app.Fragment.fragmentOf(vararg pairs: Pair<String, Any>): T = fragmentOf(T::class.java.name, bundleOf(*pairs)) as T
inline fun <reified T> androidx.fragment.app.Fragment.fragmentOf(bundle: Bundle? = null): T = fragmentOf(T::class.java.name, bundle) as T

//Preferences
fun Context.getStringPreference(preference: String, defaultValue: String? = null): String? = PreferenceManager.getDefaultSharedPreferences(this).getString(preference, defaultValue)
fun Context.getIntPreference(preference: String, defaultValue: Int = -1): Int = PreferenceManager.getDefaultSharedPreferences(this).getInt(preference, defaultValue)
fun Context.getBooleanPreference(preference: String, defaultValue: Boolean = false): Boolean = PreferenceManager.getDefaultSharedPreferences(this).getBoolean(preference, defaultValue)
fun Context.getLongPreference(preference: String, defaultValue: Long = -1L): Long = PreferenceManager.getDefaultSharedPreferences(this).getLong(preference, defaultValue)
fun Context.saveStringPreference(preference: String, value: String?) = PreferenceManager.getDefaultSharedPreferences(this).edit().putString(preference, value).commit()
fun Context.saveIntPreference(preference: String, value: Int) = PreferenceManager.getDefaultSharedPreferences(this).edit().putInt(preference, value).commit()
fun Context.saveBooleanPreference(preference: String, value: Boolean) = PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean(preference, value).commit()
fun Context.saveLongPreference(preference: String, value: Long) = PreferenceManager.getDefaultSharedPreferences(this).edit().putLong(preference, value).commit()


//Other
fun Context.getVersionName(): String? {
    try {
        return this.packageManager.getPackageInfo(this.packageName, 0).versionName
    } catch (e: PackageManager.NameNotFoundException) {
        e.printStackTrace()
    }

    return null
}

fun Context.getVersionCode(): Int {
    try {
        return this.packageManager.getPackageInfo(this.packageName, 0).versionCode
    } catch (e: PackageManager.NameNotFoundException) {
        e.printStackTrace()
    }

    return -1
}

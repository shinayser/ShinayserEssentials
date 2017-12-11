package com.shinayser.essentials.util

import android.os.Bundle
import android.os.Parcelable
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import org.jetbrains.anko.bundleOf

/**
 * Created by denox on 10/11/2017.
 */
//Delegates
fun Fragment.extraString(key: String) = lazy { if (arguments.containsKey(key)) arguments.getString(key) else null!! }
fun Fragment.extraBoolean(key: String) = lazy { if (arguments.containsKey(key)) arguments.getBoolean(key) else null!! }
fun Fragment.extraDouble(key: String) = lazy { if (arguments.containsKey(key)) arguments.getDouble(key) else null!! }
fun Fragment.extraLong(key: String) = lazy { if (arguments.containsKey(key)) arguments.getLong(key) else null!! }
fun Fragment.extraBundle(key: String) = lazy { arguments.getBundle(key)!! }
fun <T : Parcelable> Fragment.extraParcelable(key: String) = lazy { arguments.getParcelable<T>(key)!! }
fun <T> Fragment.extraSerializable(key: String) = lazy { (arguments.getSerializable(key) as T)!! }

fun Fragment.optionalString(key: String) = lazy { if (arguments.containsKey(key)) arguments?.getString(key) else null }
fun Fragment.optionalBoolean(key: String) = lazy { if (arguments.containsKey(key)) arguments?.getBoolean(key) else null }
fun Fragment.optionalDouble(key: String) = lazy { if (arguments.containsKey(key)) arguments?.getDouble(key) else null }
fun Fragment.optionalLong(key: String) = lazy { if (arguments.containsKey(key)) arguments?.getLong(key) else null }
fun Fragment.optionalBundle(key: String) = lazy { arguments?.getBundle(key) }
fun <T : Parcelable> Fragment.optionalParcelable(key: String) = lazy { arguments?.getParcelable<T>(key) }
fun <T> Fragment.optionalSerializable(key: String) = lazy { arguments?.getSerializable(key) as? T }

inline fun <reified T : DialogFragment> Fragment.showDialogFragment(vararg pairs: Pair<String, Any>) {
    showDialogFragment<T>(bundleOf(*pairs))
}

inline fun <reified T : DialogFragment> Fragment.showDialogFragment(bundle: Bundle? = null) {
    fragmentOf<T>(bundle).show(activity.supportFragmentManager, T::class.java.name)
}



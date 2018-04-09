package com.shinayser.essentials.util

import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.shinayser.essentials.BuildConfig
import org.jetbrains.anko.bundleOf

/**
 * Created by Daniel Oliveira on 10/11/2017.
 */
//Delegates
fun Fragment.extraString(key: String) = lazy { if (arguments?.containsKey(key) == true) arguments?.getString(key) else null!! }

fun Fragment.extraBoolean(key: String) = lazy { if (arguments?.containsKey(key) == true) arguments?.getBoolean(key) else null!! }
fun Fragment.extraDouble(key: String) = lazy { if (arguments?.containsKey(key) == true) arguments?.getDouble(key) else null!! }
fun Fragment.extraLong(key: String) = lazy { if (arguments?.containsKey(key) == true) arguments?.getLong(key) else null!! }
fun Fragment.extraInt(key: String) = lazy { if (arguments?.containsKey(key) == true) arguments?.getInt(key) else null!! }
fun Fragment.extraBundle(key: String) = lazy { arguments?.getBundle(key)!! }
fun <T : Parcelable> Fragment.extraParcelable(key: String) = lazy { arguments?.getParcelable<T>(key)!! }
fun <T> Fragment.extraSerializable(key: String) = lazy { (arguments?.getSerializable(key) as T)!! }

fun Fragment.optionalString(key: String) = lazy { if (arguments?.containsKey(key) == true) arguments?.getString(key) else null }
fun Fragment.optionalBoolean(key: String) = lazy { if (arguments?.containsKey(key) == true) arguments?.getBoolean(key) else null }
fun Fragment.optionalDouble(key: String) = lazy { if (arguments?.containsKey(key) == true) arguments?.getDouble(key) else null }
fun Fragment.optionalLong(key: String) = lazy { if (arguments?.containsKey(key) == true) arguments?.getLong(key) else null }
fun Fragment.optionalBundle(key: String) = lazy { arguments?.getBundle(key) }
fun <T : Parcelable> Fragment.optionalParcelable(key: String) = lazy { arguments?.getParcelable<T>(key) }
fun <T> Fragment.optionalSerializable(key: String) = lazy { arguments?.getSerializable(key) as? T }


inline fun <reified T : DialogFragment> Fragment.showDialogFragment(fragmentManager: FragmentManager = activity!!.supportFragmentManager, vararg pairs: Pair<String, Any>) {
	showDialogFragment<T>(fragmentManager, bundleOf(*pairs));
}

inline fun <reified T : DialogFragment> Fragment.showDialogFragment(fragmentManager: FragmentManager = activity!!.supportFragmentManager, bundle: Bundle? = null) {
	fragmentOf<T>(bundle).show(fragmentManager, T::class.java.name)
}



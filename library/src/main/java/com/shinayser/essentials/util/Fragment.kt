package com.shinayser.essentials.util

import android.os.Bundle
import android.os.Parcelable
import androidx.core.os.bundleOf

/**
 * Created by Daniel Oliveira on 10/11/2017.
 */
//Delegates
fun androidx.fragment.app.Fragment.extraString(key: String) = lazy { arguments!!.getString(key)!! }

fun androidx.fragment.app.Fragment.extraBoolean(key: String) = lazy { arguments!!.getBoolean(key)!! }
fun androidx.fragment.app.Fragment.extraDouble(key: String) = lazy { arguments?.getDouble(key)!! }
fun androidx.fragment.app.Fragment.extraLong(key: String) = lazy { arguments?.getLong(key)!! }
fun androidx.fragment.app.Fragment.extraInt(key: String) = lazy { arguments?.getInt(key)!! }
fun androidx.fragment.app.Fragment.extraBundle(key: String) = lazy { arguments?.getBundle(key)!! }
fun <T : Parcelable> androidx.fragment.app.Fragment.extraParcelable(key: String) = lazy { arguments?.getParcelable<T>(key)!! }
fun <T> androidx.fragment.app.Fragment.extraSerializable(key: String) = lazy { (arguments?.getSerializable(key) as T)!! }

fun androidx.fragment.app.Fragment.optionalString(key: String) = lazy { if (arguments?.containsKey(key) == true) arguments?.getString(key) else null }
fun androidx.fragment.app.Fragment.optionalBoolean(key: String) = lazy { if (arguments?.containsKey(key) == true) arguments?.getBoolean(key) else null }
fun androidx.fragment.app.Fragment.optionalDouble(key: String) = lazy { if (arguments?.containsKey(key) == true) arguments?.getDouble(key) else null }
fun androidx.fragment.app.Fragment.optionalLong(key: String) = lazy { if (arguments?.containsKey(key) == true) arguments?.getLong(key) else null }
fun androidx.fragment.app.Fragment.optionalBundle(key: String) = lazy { arguments?.getBundle(key) }
fun <T : Parcelable> androidx.fragment.app.Fragment.optionalParcelable(key: String) = lazy { arguments?.getParcelable<T>(key) }
fun <T> androidx.fragment.app.Fragment.optionalSerializable(key: String) = lazy { arguments?.getSerializable(key) as? T }


inline fun <reified T : androidx.fragment.app.DialogFragment> androidx.fragment.app.Fragment.showDialogFragment(fragmentManager: androidx.fragment.app.FragmentManager = activity!!.supportFragmentManager, vararg pairs: Pair<String, Any>) {
	showDialogFragment<T>(fragmentManager, bundleOf(*pairs));
}

inline fun <reified T : androidx.fragment.app.DialogFragment> androidx.fragment.app.Fragment.showDialogFragment(fragmentManager: androidx.fragment.app.FragmentManager = activity!!.supportFragmentManager, bundle: Bundle? = null) {
	fragmentOf<T>(bundle).show(fragmentManager, T::class.java.name)
}



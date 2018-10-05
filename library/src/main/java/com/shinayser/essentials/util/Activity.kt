package com.shinayser.essentials.util

import android.app.Activity
import android.os.Bundle
import android.os.Parcelable
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * Created by Daniel Oliveira on 10/11/2017.
 */

//Delegates
fun Activity.extraString(key: String) = lazy { if (intent.extras.containsKey(key)) intent.extras.getString(key) else null!! }

fun Activity.extraBoolean(key: String) = lazy { if (intent.extras.containsKey(key)) intent.extras.getBoolean(key) else null!! }
fun Activity.extraDouble(key: String) = lazy { if (intent.extras.containsKey(key)) intent.extras.getDouble(key) else null!! }
fun Activity.extraLong(key: String) = lazy { if (intent.extras.containsKey(key)) intent.extras.getLong(key) else null!! }
fun Activity.extraBundle(key: String) = lazy { intent.extras.getBundle(key)!! }
fun <T : Parcelable> Activity.extraParcelable(key: String) = lazy { intent.extras.getParcelable<T>(key)!! }
fun <T> Activity.extraSerializable(key: String) = lazy { (intent.extras.getSerializable(key) as T)!! }

fun Activity.optionalString(key: String) = lazy { intent.extras?.getString(key) }
fun Activity.optionalBoolean(key: String) = lazy { intent.extras?.getBoolean(key) }
fun Activity.optionalDouble(key: String) = lazy { intent.extras?.getDouble(key) }
fun Activity.optionalLong(key: String) = lazy { intent.extras?.getLong(key) }
fun Activity.optionalBundle(key: String) = lazy { intent.extras?.getBundle(key) }
fun <T : Parcelable> Activity.optionalParcelable(key: String) = lazy { intent.extras?.getParcelable<T>(key) }
fun <T> Activity.optionalSerializable(key: String) = lazy { intent.extras?.getSerializable(key) as? T }

inline fun <reified T : androidx.fragment.app.DialogFragment> androidx.fragment.app.FragmentActivity.showDialogFragment(vararg pairs: Pair<String, Any>) {
	showDialogFragment<T>(bundleOf(*pairs))
}

inline fun <reified T : androidx.fragment.app.DialogFragment> androidx.fragment.app.FragmentActivity.showDialogFragment(bundle: Bundle? = null) {
	fragmentOf<T>(bundle).show(supportFragmentManager, T::class.java.name)
}

fun <T : ViewDataBinding> Activity.bindContentView(res: Int): T {
	return DataBindingUtil.setContentView(this, res)
}
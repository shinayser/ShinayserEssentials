package com.shinayer.essentials.util

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import org.jetbrains.anko.bundleOf

/**
 * Created by denox on 10/11/2017.
 */
inline fun <reified T : DialogFragment> Fragment.showDialogFragment(vararg pairs: Pair<String, Any>) {
    showDialogFragment<T>(bundleOf(*pairs))
}

inline fun <reified T : DialogFragment> Fragment.showDialogFragment(bundle: Bundle? = null) {
    fragmentOf<T>(bundle).show(activity.supportFragmentManager, T::class.java.name)
}
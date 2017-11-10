package com.shinayer.essentials.util

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentActivity
import org.jetbrains.anko.bundleOf

/**
 * Created by denox on 10/11/2017.
 */
inline fun <reified T : DialogFragment> FragmentActivity.showDialogFragment(vararg pairs: Pair<String, Any>) {
    showDialogFragment<T>(bundleOf(*pairs))
}

inline fun <reified T : DialogFragment> FragmentActivity.showDialogFragment(bundle: Bundle? = null) {
    fragmentOf<T>(bundle).show(supportFragmentManager, T::class.java.name)
}

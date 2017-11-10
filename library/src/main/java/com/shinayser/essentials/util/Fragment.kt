package com.shinayser.essentials.util

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
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

inline fun Fragment.childFragmentTransaction(block: FragmentTransaction.() -> Any): FragmentManager {
    childFragmentManager.onTransaction(block)
    return childFragmentManager
}

inline fun Fragment.childFragmentTransactionNow(block: FragmentTransaction.() -> Any): FragmentManager {
    childFragmentManager.onTransactionNow(block)
    return childFragmentManager
}

inline fun Fragment.childFragmentTransactionAllowingStateLoss(block: FragmentTransaction.() -> Any): FragmentManager {
    childFragmentManager.onTransactionAllowingStateLoss(block)
    return childFragmentManager
}

inline fun Fragment.childFragmentTransactionNowAllowingStateLoss(block: FragmentTransaction.() -> Any): FragmentManager {
    childFragmentManager.onTransactionNowAllowingStateLoss(block)
    return childFragmentManager
}
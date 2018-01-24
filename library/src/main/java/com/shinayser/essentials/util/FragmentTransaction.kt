package com.shinayser.essentials.util

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction

/**
 * Created by Daniel Oliveira on 10/11/2017.
 */
inline fun <reified T> FragmentManager.find() = findFragmentByTag(T::class.java.name) as T

inline fun FragmentManager.onTransaction(block: FragmentTransaction.() -> Any): FragmentManager {
    val transaction = beginTransaction()
    transaction.block()
    transaction.commit()
    return this
}

inline fun FragmentManager.onTransactionNow(block: FragmentTransaction.() -> Any): FragmentManager {
    val transaction = beginTransaction()
    transaction.block()
    transaction.commitNow()
    return this
}

inline fun FragmentManager.onTransactionAllowingStateLoss(block: FragmentTransaction.() -> Any): FragmentManager {
    val transaction = beginTransaction()
    transaction.block()
    transaction.commitAllowingStateLoss()
    return this
}

inline fun FragmentManager.onTransactionNowAllowingStateLoss(block: FragmentTransaction.() -> Any): FragmentManager {
    val transaction = beginTransaction()
    transaction.block()
    transaction.commitNowAllowingStateLoss()
    return this
}


/////Fragment activity
inline fun FragmentActivity.fragmentTransaction(block: FragmentTransaction.() -> Any): FragmentManager {
    supportFragmentManager.onTransaction(block)
    return supportFragmentManager
}

inline fun FragmentActivity.fragmentTransactionNow(block: FragmentTransaction.() -> Any): FragmentManager {
    supportFragmentManager.onTransactionNow(block)
    return supportFragmentManager
}

inline fun FragmentActivity.fragmentTransactionAllowingStateLoss(block: FragmentTransaction.() -> Any): FragmentManager {
    supportFragmentManager.onTransactionAllowingStateLoss(block)
    return supportFragmentManager
}

inline fun FragmentActivity.fragmentTransactionNowAllowingStateLoss(block: FragmentTransaction.() -> Any): FragmentManager {
    supportFragmentManager.onTransactionNowAllowingStateLoss(block)
    return supportFragmentManager
}

inline fun FragmentActivity.addFragmentTransaction(containerId: Int, fragment: Fragment, tag: String? = null) {

    this.fragmentTransaction {
        if (tag == null) {
            add(containerId, fragment, fragment::class.java.name)
        } else {
            add(containerId, fragment, tag)
        }
    }

}

inline fun FragmentActivity.addFragmentTransactionNow(containerId: Int, fragment: Fragment, tag: String? = null) {

    this.fragmentTransactionNow {
        if (tag == null) {
            add(containerId, fragment, fragment::class.java.name)
        } else {
            add(containerId, fragment, tag)
        }
    }

}


//////////Fragment

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
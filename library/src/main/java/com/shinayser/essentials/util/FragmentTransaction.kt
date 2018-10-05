package com.shinayser.essentials.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

/**
 * Created by Daniel Oliveira on 10/11/2017.
 */
inline fun <reified T> androidx.fragment.app.FragmentManager.find() = findFragmentByTag(T::class.java.name) as T

inline fun androidx.fragment.app.FragmentManager.onTransaction(block: androidx.fragment.app.FragmentTransaction.() -> Any): androidx.fragment.app.FragmentManager {
    val transaction = beginTransaction()
    transaction.block()
    transaction.commit()
    return this
}

inline fun androidx.fragment.app.FragmentManager.onTransactionNow(block: androidx.fragment.app.FragmentTransaction.() -> Any): androidx.fragment.app.FragmentManager {
    val transaction = beginTransaction()
    transaction.block()
    transaction.commitNow()
    return this
}

inline fun androidx.fragment.app.FragmentManager.onTransactionAllowingStateLoss(block: androidx.fragment.app.FragmentTransaction.() -> Any): androidx.fragment.app.FragmentManager {
    val transaction = beginTransaction()
    transaction.block()
    transaction.commitAllowingStateLoss()
    return this
}

inline fun androidx.fragment.app.FragmentManager.onTransactionNowAllowingStateLoss(block: androidx.fragment.app.FragmentTransaction.() -> Any): androidx.fragment.app.FragmentManager {
    val transaction = beginTransaction()
    transaction.block()
    transaction.commitNowAllowingStateLoss()
    return this
}


/////Fragment activity
inline fun androidx.fragment.app.FragmentActivity.fragmentTransaction(block: androidx.fragment.app.FragmentTransaction.() -> Any): androidx.fragment.app.FragmentManager {
    supportFragmentManager.onTransaction(block)
    return supportFragmentManager
}

inline fun androidx.fragment.app.FragmentActivity.fragmentTransactionNow(block: androidx.fragment.app.FragmentTransaction.() -> Any): androidx.fragment.app.FragmentManager {
    supportFragmentManager.onTransactionNow(block)
    return supportFragmentManager
}

inline fun androidx.fragment.app.FragmentActivity.fragmentTransactionAllowingStateLoss(block: androidx.fragment.app.FragmentTransaction.() -> Any): androidx.fragment.app.FragmentManager {
    supportFragmentManager.onTransactionAllowingStateLoss(block)
    return supportFragmentManager
}

inline fun androidx.fragment.app.FragmentActivity.fragmentTransactionNowAllowingStateLoss(block: androidx.fragment.app.FragmentTransaction.() -> Any): androidx.fragment.app.FragmentManager {
    supportFragmentManager.onTransactionNowAllowingStateLoss(block)
    return supportFragmentManager
}

inline fun androidx.fragment.app.FragmentActivity.addFragmentTransaction(containerId: Int, fragment: androidx.fragment.app.Fragment, tag: String? = null) {

    this.fragmentTransaction {
        if (tag == null) {
            add(containerId, fragment, fragment::class.java.name)
        } else {
            add(containerId, fragment, tag)
        }
    }

}

inline fun androidx.fragment.app.FragmentActivity.addFragmentTransactionNow(containerId: Int, fragment: androidx.fragment.app.Fragment, tag: String? = null) {

    this.fragmentTransactionNow {
        if (tag == null) {
            add(containerId, fragment, fragment::class.java.name)
        } else {
            add(containerId, fragment, tag)
        }
    }

}


//////////Fragment

inline fun androidx.fragment.app.Fragment.childFragmentTransaction(block: androidx.fragment.app.FragmentTransaction.() -> Any): androidx.fragment.app.FragmentManager {
    childFragmentManager.onTransaction(block)
    return childFragmentManager
}

inline fun androidx.fragment.app.Fragment.childFragmentTransactionNow(block: androidx.fragment.app.FragmentTransaction.() -> Any): androidx.fragment.app.FragmentManager {
    childFragmentManager.onTransactionNow(block)
    return childFragmentManager
}

inline fun androidx.fragment.app.Fragment.childFragmentTransactionAllowingStateLoss(block: androidx.fragment.app.FragmentTransaction.() -> Any): androidx.fragment.app.FragmentManager {
    childFragmentManager.onTransactionAllowingStateLoss(block)
    return childFragmentManager
}

inline fun androidx.fragment.app.Fragment.childFragmentTransactionNowAllowingStateLoss(block: androidx.fragment.app.FragmentTransaction.() -> Any): androidx.fragment.app.FragmentManager {
    childFragmentManager.onTransactionNowAllowingStateLoss(block)
    return childFragmentManager
}
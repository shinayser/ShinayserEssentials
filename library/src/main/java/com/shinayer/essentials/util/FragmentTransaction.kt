package com.shinayer.essentials.util

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction

/**
 * Created by denox on 10/11/2017.
 */
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
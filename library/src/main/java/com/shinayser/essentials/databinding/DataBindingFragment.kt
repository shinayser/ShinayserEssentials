package com.shinayser.essentials.databinding

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Daniel Oliveira on 18/11/2016.
 */

abstract class DataBindingFragment<T : ViewDataBinding>(private var retainThisInstance : Boolean = true) : Fragment() {

    protected lateinit var mBind: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.retainInstance = retainThisInstance
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBind = DataBindingUtil.inflate(inflater, getLayoutRes(), null, false)
        return mBind.root
    }

    abstract fun getLayoutRes(): Int

}

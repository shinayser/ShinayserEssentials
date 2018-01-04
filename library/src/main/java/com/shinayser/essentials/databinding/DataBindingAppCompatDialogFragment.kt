package com.shinayser.essentials.databinding

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by denox on 18/11/2016.
 */

abstract class DataBindingAppCompatDialogFragment<T : ViewDataBinding> : AppCompatDialogFragment() {

    protected lateinit var mBind: T

    abstract val layoutRes: Int


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBind = DataBindingUtil.inflate(inflater!!, layoutRes, null, false)
        return mBind.root
    }

    override fun onDestroyView() {
        if (dialog != null && retainInstance)
            dialog.setDismissMessage(null)
        super.onDestroyView()
    }

}

package com.shinayser.essentials.databinding

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Daniel Oliveira on 18/11/2016.
 */

abstract class DataBindingBottomSheetDialogFragment<T : ViewDataBinding> : BottomSheetDialogFragment() {

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

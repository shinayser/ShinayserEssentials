package com.shinayser.essentials.databinding

import android.content.Context
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import android.os.Bundle
import androidx.appcompat.app.AppCompatDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shinayser.essentials.util.ResTrait

/**
 * Created by Daniel Oliveira on 18/11/2016.
 */

abstract class DataBindingAppCompatDialogFragment<T : ViewDataBinding> : AppCompatDialogFragment(), ResTrait {
    override fun getContext(): Context = activity!!

    protected lateinit var mBind: T

    abstract val layoutRes: Int


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBind = DataBindingUtil.inflate(inflater, layoutRes, null, false)
        return mBind.root
    }

    override fun onDestroyView() {
        if (dialog != null && retainInstance)
            dialog.setDismissMessage(null)
        super.onDestroyView()
    }

}

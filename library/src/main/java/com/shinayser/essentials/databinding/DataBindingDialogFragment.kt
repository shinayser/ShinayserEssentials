package com.shinayser.essentials.databinding

import android.app.Dialog
import android.content.Context
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import com.shinayser.essentials.util.ResTrait

/**
 * Created by Daniel Oliveira on 18/11/2016.
 */

abstract class DataBindingDialogFragment<T : ViewDataBinding> : androidx.fragment.app.DialogFragment(), ResTrait {
	override fun getContext(): Context = activity!!


	protected lateinit var mBind: T

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		mBind = DataBindingUtil.inflate<T>(inflater, layoutRes, null, false)
		return mBind.root
	}

	override fun onDestroyView() {
		if (dialog != null && retainInstance)
			dialog.setDismissMessage(null)
		super.onDestroyView()
	}

	override fun onCreateDialog(savedInstanceState: Bundle?) = Dialog(activity).apply {
		requestWindowFeature(Window.FEATURE_NO_TITLE)
	}

	abstract val layoutRes: Int

}

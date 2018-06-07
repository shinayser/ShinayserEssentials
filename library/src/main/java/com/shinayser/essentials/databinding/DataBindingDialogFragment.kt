package com.shinayser.essentials.databinding

import android.app.Dialog
import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import com.shinayser.essentials.util.ResTrait

/**
 * Created by Daniel Oliveira on 18/11/2016.
 */

abstract class DataBindingDialogFragment<T : ViewDataBinding>() : DialogFragment(), ResTrait {
	override fun getApplicationContext(): Context = activity!!.applicationContext


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

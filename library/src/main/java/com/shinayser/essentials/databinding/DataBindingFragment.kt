package com.shinayser.essentials.databinding

import android.content.Context
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shinayser.essentials.util.ResTrait

/**
 * Created by Daniel Oliveira on 18/11/2016.
 */

abstract class DataBindingFragment<T : ViewDataBinding>(private var retainThisInstance: Boolean = true) : androidx.fragment.app.Fragment(), ResTrait {
	override fun getContext(): Context = activity!!

	protected lateinit var mBind: T

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		this.retainInstance = retainThisInstance
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		mBind = DataBindingUtil.inflate(inflater, getLayoutRes(), null, false)
		return mBind.root
	}

	abstract fun getLayoutRes(): Int

}

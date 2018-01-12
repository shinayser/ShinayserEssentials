package com.shinayser.essentials.adapter

import android.widget.SeekBar

/**
 * Created by denox on 12/01/2018.
 */

class SeekBarChangeAdapter : SeekBar.OnSeekBarChangeListener {

    private var onProgressChanged : ((seekBar: SeekBar?, progress: Int, fromUser: Boolean) -> Boolean)? = null
    private var onStartTrackingTouch : ((seekBar: SeekBar?) -> Unit)? = null
    private var onStopTrackingTouch : ((seekBar: SeekBar?) -> Unit)? = null

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        onProgressChanged?.invoke(seekBar, progress, fromUser)
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
        onStartTrackingTouch?.invoke(seekBar)
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
        onStopTrackingTouch?.invoke(seekBar)
    }


    fun onProgressChanged( lambda : (seekBar: SeekBar?, progress: Int, fromUser: Boolean) -> Boolean){
        onProgressChanged = lambda
    }

    fun onStartTrackingTouch( lambda : (seekBar: SeekBar?) -> Unit ){
        onStartTrackingTouch = lambda
    }

    fun onStopTrackingTouch( lambda : (seekBar: SeekBar?) -> Unit ){
        onStopTrackingTouch = lambda
    }

}


fun seekBarChangeAdapter( builder : SeekBarChangeAdapter.() -> Unit ): SeekBarChangeAdapter {

    val seekBarChangeAdapter = SeekBarChangeAdapter()
    seekBarChangeAdapter.builder()
    return seekBarChangeAdapter

}
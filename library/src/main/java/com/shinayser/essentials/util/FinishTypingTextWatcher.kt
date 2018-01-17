package com.shinayser.essentials.util

import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.mcxiaoke.koi.ext.cancelAll

/**
 * Created by denox on 18/12/2017.
 */
typealias FinishedTypingListener = (String) -> Unit

class FinishTypingTextWatcher(private val delay: Long, val listener: FinishedTypingListener) : TextWatcher {

    var handler = Handler()

    override fun afterTextChanged(s: Editable?) {

        handler.postDelayed({
            listener.invoke(s.toString())
        }, delay)


    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        handler.cancelAll()
    }

}

fun EditText.onFinishedTyping(delay: Long = 600, listener: FinishedTypingListener) : FinishTypingTextWatcher {
    return FinishTypingTextWatcher(delay, listener).also {
        this.addTextChangedListener(it)
    }
}
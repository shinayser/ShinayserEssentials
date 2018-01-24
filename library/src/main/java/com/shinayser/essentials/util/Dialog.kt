package com.shinayser.essentials.util

import android.R
import android.content.Context
import android.content.DialogInterface
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.widget.ArrayAdapter

/**
 * Created by Daniel Oliveira on 19/12/2017.
 */
fun Fragment.showMultiselectDialog(title: String? = null, itens: Array<String>, checkedItens: BooleanArray?, listener: (dialog: DialogInterface, which: Int, isChecked: Boolean) -> Unit) {
    activity.showMultiselectDialog(title, itens, checkedItens, listener)
}

fun Context.showMultiselectDialog(title: String? = null, itens: Array<String>, checkedItens: BooleanArray?, listener: (dialog: DialogInterface, which: Int, isChecked: Boolean) -> Unit) {
    AlertDialog.Builder(this)
            .setTitle(title)
            .setMultiChoiceItems(itens, checkedItens, listener)
            .show()
}

fun Context.showSingleSelectDialog(title: String? = null, itens: Array<String>, checkedItem: Int, listener: (dialog: DialogInterface, which: Int) -> Unit) {
    AlertDialog.Builder(this)
            .setTitle(title)
            .setSingleChoiceItems(itens, checkedItem, listener)
            .setPositiveButton("Ok") { dialog, which ->
                dialog.dismiss()
            }
            .show()
}

fun Context.showListSelectionDialog(title: String? = null, itens: Array<String>, theme : Int = 0, listener: (dialog: DialogInterface, which: Int) -> Unit) {
    AlertDialog.Builder(this, theme)
            .setTitle(title)
            .setAdapter(ArrayAdapter<String>(this, R.layout.simple_list_item_1, itens), listener)
            .show()
}
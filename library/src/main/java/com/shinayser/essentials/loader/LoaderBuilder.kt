package com.shinayser.essentials.loader

import android.database.Cursor
import android.os.Bundle
import android.support.v4.app.LoaderManager
import android.support.v4.content.Loader

        /**
         * Created by Daniel Oliveira on 19/01/2018.
         */

typealias LoaderCreation<TYPE> = (id: Int, args: Bundle?) -> Loader<TYPE>
typealias LoaderFinished<TYPE> = (loader: Loader<TYPE>?, data: TYPE) -> Unit
typealias LoaderReset<TYPE> = (loader: Loader<TYPE>?) -> Unit

class LoaderBuilder<TYPE> : LoaderManager.LoaderCallbacks<TYPE> {

    lateinit var loaderCreation: LoaderCreation<TYPE>
    var loaderFinished: LoaderFinished<TYPE>? = null
    var loaderReset: LoaderReset<TYPE>? = null


    override fun onCreateLoader(id: Int, args: Bundle?): Loader<TYPE> {
        return loaderCreation.invoke(id, args)
    }

    override fun onLoadFinished(loader: Loader<TYPE>?, data: TYPE) {
        loaderFinished?.invoke(loader, data)
    }

    override fun onLoaderReset(loader: Loader<TYPE>?) {
        loaderReset?.invoke(loader)
    }


    fun loaderCreation(loaderCreation: LoaderCreation<TYPE>) {
        this.loaderCreation = loaderCreation
    }

    fun loadFinished(loaderFinished: LoaderFinished<TYPE>) {
        this.loaderFinished = loaderFinished
    }

    fun loaderReset(loaderReset: LoaderReset<TYPE>) {
        this.loaderReset = loaderReset
    }

}

fun <TYPE> createLoader(lambda: LoaderBuilder<TYPE>.() -> Unit): LoaderBuilder<TYPE> {
    return LoaderBuilder<TYPE>().apply(lambda)
}

fun createCursorLoader(lambda: LoaderBuilder<Cursor>.() -> Unit): LoaderBuilder<Cursor> {
    return createLoader(lambda)
}
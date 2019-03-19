package com.smartcentury.logistics.main.base

import java.lang.ref.Reference
import java.lang.ref.WeakReference
/**
 * Created by Simon on 2019/2/18
 * Note: Presenter 基类
 */
abstract class BasePresenter<V> {
    private lateinit var mViewRef: Reference<V?>
    fun attachView(v: V?) {
        mViewRef = WeakReference<V>(v)
    }

    fun getView(): V? {
        return mViewRef.get()
    }

    open fun detachView() {
        mViewRef.clear()
    }
}
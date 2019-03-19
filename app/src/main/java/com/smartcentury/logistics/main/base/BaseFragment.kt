package com.smartcentury.logistics.main.base

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.smartcentury.logistics.main.interfaces.IInitData
import com.smartcentury.logistics.main.interfaces.IInitView

/**
 * Created by Simon on 2019/1/4
 * Note: Fragment 基类
 */
@Suppress("UNCHECKED_CAST")
abstract class BaseFragment<V, T : BasePresenter<V>> : Fragment(), IInitData, IInitView {

    private var loadingDialog: Dialog? = null
    protected lateinit var mPresenter: T
    var mContext : Context?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = activity
        initData()
        mPresenter = createPresenter()
        mPresenter.attachView(this as V)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(createViewLayoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }



    override fun initData() {}

    override fun initView() {}

    protected abstract fun createPresenter(): T
    protected abstract fun createViewLayoutId(): Int
}
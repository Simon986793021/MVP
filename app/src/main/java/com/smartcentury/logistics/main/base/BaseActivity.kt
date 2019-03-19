package com.smartcentury.logistics.main.base

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.smartcentury.logistics.main.interfaces.IInitData
import com.smartcentury.logistics.main.interfaces.IInitView

/**
 * Created by Simon on 2019/1/4
 * Note: Activity 基类
 */
@Suppress("UNCHECKED_CAST")
abstract class BaseActivity<V, T : BasePresenter<V>> : AppCompatActivity(), IInitData, IInitView {
    lateinit var mPresenter: T
    private var loadingDialog: Dialog? = null
    private lateinit var mContext: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext=this
        //允许为空，不是所有都要实现MVP模式
        if (createPresenter() != null) {
            mPresenter = this.createPresenter()!!
            mPresenter.attachView(this as V)
        }
        setContentView(provideContentViewId())//布局
        initView()
        initData()
    }



    override fun onDestroy() {
        super.onDestroy()
        if (mPresenter != null) {
            mPresenter!!.detachView() //销毁时移除View
        }
    }

    /**
     * 显示Loading对话框
     */
//    fun showLoadingDialog() {
//        if (loadingDialog == null) {
//            initLoadingDialog()
//        }
//        loadingDialog?.show()
//    }


    /**
     * 关闭Loading对话框
     */
//    fun disLoadingDialog() {
//        loadingDialog?.dismiss()
//    }



    protected abstract fun createPresenter(): T?  // 用于创建presenter
    protected abstract fun provideContentViewId(): Int //用于引入布局文件
    override fun initData() {}
    override fun initView() {}
}
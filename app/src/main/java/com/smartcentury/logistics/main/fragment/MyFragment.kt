package com.smartcentury.logistics.main.fragment

import com.smartcentury.logistics.R
import com.smartcentury.logistics.main.base.BaseFragment
import com.smartcentury.logistics.main.presenter.MyFgPresenter
import com.smartcentury.logistics.main.view.IMyFgView

/**
 * Created by Simon on 2019/2/18
 * Note: 个人中心fragment
 */
class MyFragment : BaseFragment<IMyFgView, MyFgPresenter>(){

    override fun initView() {
    }


    override fun createPresenter(): MyFgPresenter {
        return MyFgPresenter()
    }

    override fun createViewLayoutId(): Int {
        return R.layout.fragment_my
    }


}
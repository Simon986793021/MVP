package com.smartcentury.logistics.main.fragment

import com.smartcentury.logistics.R
import com.smartcentury.logistics.main.presenter.HomeFgPresenter
import com.smartcentury.logistics.main.base.BaseFragment
import com.smartcentury.logistics.main.view.IHomeFgView

/**
 * Created by Simon on 2019/1/4
 * Note: 首页Fragment
 */
class HomeFragment : BaseFragment<IHomeFgView, HomeFgPresenter>(), IHomeFgView {
    override fun initView() {
        super.initView()
    }

    override fun createPresenter(): HomeFgPresenter {
        return HomeFgPresenter()
    }

    override fun createViewLayoutId(): Int {
        return R.layout.fragment_home
    }

}
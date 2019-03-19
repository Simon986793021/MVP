package com.smartcentury.logistics.main.fragment

import com.smartcentury.logistics.R
import com.smartcentury.logistics.main.base.BaseFragment
import com.smartcentury.logistics.main.presenter.MessagePresenter
import com.smartcentury.logistics.main.view.IMessageFgView

/**
 * Created by Simon on 2019/2/18
 * Note: 消息Fragment
 */
class MessageFragment : BaseFragment<IMessageFgView, MessagePresenter>() {
    override fun initView() {
    }

    override fun createPresenter(): MessagePresenter {
        return MessagePresenter()
    }

    override fun createViewLayoutId(): Int {
        return R.layout.fragment_message
    }
}
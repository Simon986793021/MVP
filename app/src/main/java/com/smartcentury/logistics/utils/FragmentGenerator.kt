package com.smartcentury.logistics.utils

import android.annotation.SuppressLint
import android.content.Context
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import com.smartcentury.logistics.R
import com.smartcentury.logistics.main.fragment.HomeFragment
import com.smartcentury.logistics.main.fragment.MessageFragment
import com.smartcentury.logistics.main.fragment.MyFragment
import kotlinx.android.synthetic.main.home_tab_content.view.*

/**
 * Created by Simon on 2019/1/4
 * Note: 生成底部导航fragment
 */
object FragmentGenerator {
    val mTabRes =
        intArrayOf(R.mipmap.home_normal, R.mipmap.message_normal,R.mipmap.my_normal)
    val mTabResSel =
        intArrayOf(R.mipmap.home_selected, R.mipmap.message_selcted,R.mipmap.my_selected)
     private val tabTitle = arrayOf("首页","消息", "我的")

    fun getFragments(): ArrayList<Fragment> {
        val fragments = arrayListOf<Fragment>(HomeFragment(), MessageFragment(), MyFragment())
        return fragments
    }

    @SuppressLint("InflateParams")
    fun getTabView(context: Context, position: Int): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.home_tab_content, null, false)
        view.tv_home_tab_title.text = tabTitle[position]
        view.iv_home_tab_image.setImageResource(mTabRes[position])
        return view
    }
}
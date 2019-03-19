package com.smartcentury.logistics

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import com.smartcentury.logistics.utils.FragmentGenerator.getFragments
import com.smartcentury.logistics.utils.FragmentGenerator.getTabView
import com.smartcentury.logistics.utils.FragmentGenerator.mTabRes
import com.smartcentury.logistics.utils.FragmentGenerator.mTabResSel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mFragmensts: ArrayList<Fragment>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        setContentView(R.layout.activity_main)
            mFragmensts = getFragments()
        initView()
    }

    private fun initView() {
        bottom_tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                onTabItemSelected(p0!!.position)
                for (i in 0 until bottom_tab_layout.tabCount) {
                    val view: View? = bottom_tab_layout.getTabAt(i)?.customView
                    val imageView: ImageView? = view?.findViewById(R.id.iv_home_tab_image)
                    if (i == p0.position) imageView?.setImageResource(mTabResSel[i]) else imageView?.setImageResource(
                        mTabRes[i]
                    )
                }
            }
        })
        for (i in 0..2) {
            bottom_tab_layout.addTab(bottom_tab_layout.newTab().setCustomView(getTabView(this, i)))
        }

    }

    private fun onTabItemSelected(position: Int) {
        var fragment: Fragment? = null
        when (position) {
            0 -> {
                fragment = mFragmensts[0]
            }
            1 -> {
                fragment = mFragmensts[1]
            }
            2 -> {
                fragment = mFragmensts[2]
            }
            3 -> {
                fragment = mFragmensts[3]
            }
        }
        supportFragmentManager.beginTransaction().replace(R.id.home_container, fragment!!).commit()
    }
}

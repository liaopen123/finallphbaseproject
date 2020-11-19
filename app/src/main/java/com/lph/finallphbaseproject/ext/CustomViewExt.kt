package com.lph.finallphbaseproject.ext

import android.app.Activity
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.lph.finallphbaseproject.ui.fragment.HomeFragment
import com.lph.finallphbaseproject.ui.fragment.MeFragment
import com.lph.finallphbaseproject.ui.fragment.ProjectFragment
import com.lph.finallphbaseproject.ui.fragment.TreeArrFragment


/**
 * 隐藏软键盘
 */
fun hideSoftKeyboard(activity: Activity?) {
    activity?.let { act ->
        val view = act.currentFocus
        view?.let {
            val inputMethodManager =
                act.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(
                view.windowToken,
                InputMethodManager.HIDE_NOT_ALWAYS
            )
        }
    }
}


fun ViewPager2.initMain(fragment: Fragment): ViewPager2 {
    //是否可滑动
    this.isUserInputEnabled = false
    this.offscreenPageLimit = 5
    //设置适配器
    adapter = object : FragmentStateAdapter(fragment) {
        override fun createFragment(position: Int): Fragment {
            when (position) {
                0 -> {
                    return HomeFragment()
                }
                1 -> {
                    return ProjectFragment()
                }
                2 -> {
                    return TreeArrFragment()
                }
                3 -> {
                    return MeFragment()
                }

                else -> {
                    return HomeFragment()
                }
            }
        }
        override fun getItemCount() = 5
    }
    return this
}


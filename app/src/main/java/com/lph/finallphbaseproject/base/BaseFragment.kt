package com.lph.finallphbaseproject.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.lph.baselib.base.fragment.BaseVMDBFragment
import com.lph.baselib.viewmodel.BaseViewModel
import com.lph.finallphbaseproject.ext.hideLoadingExt
import com.lph.finallphbaseproject.ext.hideSoftKeyboard
import com.lph.finallphbaseproject.ext.showLoadingExt

abstract class BaseFragment<VM : BaseViewModel, DB : ViewDataBinding> : BaseVMDBFragment<VM, DB>() {

//    //Application全局的ViewModel，里面存放了一些账户信息，基本配置信息等
//    val appViewModel: AppViewModel by lazy { getAppViewModel<AppViewModel>() }
//
//    //Application全局的ViewModel，用于发送全局通知操作
//    val eventViewModel: EventViewModel by lazy { getAppViewModel<EventViewModel>() }

    /**
     * 当前Fragment绑定的视图布局
     */
    abstract override fun layoutId(): Int


    abstract override fun initView(savedInstanceState: Bundle?)

    /**
     * 懒加载 只有当前fragment视图显示时才会触发该方法
     */
    override fun lazyLoadData() {}

    /**
     * 创建LiveData观察者 Fragment执行onViewCreated后触发
     */
    override fun createObserver() {}

    /**
     * Fragment执行onViewCreated后触发
     */
    override fun initData() {

    }

    /**
     * 打开等待框
     */
    override fun showLoading(message: String) {
        showLoadingExt(message)
    }

    /**
     * 关闭等待框
     */
    override fun dismissLoading() {
        hideLoadingExt()
    }

    override fun onPause() {
        super.onPause()
        hideSoftKeyboard(activity)
    }
}
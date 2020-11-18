package com.lph.finallphbaseproject.base

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.ViewDataBinding
import com.kingja.loadsir.callback.Callback
import com.kingja.loadsir.core.LoadSir
import com.lph.baselib.base.activity.BaseDBVMActivity
import com.lph.baselib.viewmodel.BaseViewModel


abstract class BaseActivity<VM : BaseViewModel, DB : ViewDataBinding> : BaseDBVMActivity<VM, DB>() {

//    //Application全局的ViewModel，里面存放了一些账户信息，基本配置信息等
//    val appViewModel: AppViewModel by lazy { getAppViewModel<AppViewModel>()}
//
//    //Application全局的ViewModel，用于发送全局通知操作
//    val eventViewModel: EventViewModel by lazy { getAppViewModel<EventViewModel>() }

    abstract override fun layoutId(): Int

    abstract override fun initView(savedInstanceState: Bundle?)


    val loadSir by lazy{
     LoadSir.getDefault().register(getLoadSirWrapper()) { onReload() }
    }
    /**
     * 创建liveData观察者
     */
    override fun createObserver() {}

    /**
     * 打开等待框
     */
    override fun showLoading(message: String) {
//        showLoadingExt(message)
    }

    /**
     * 关闭等待框
     */
    override fun dismissLoading() {
//        dismissLoadingExt()
    }

//    /**
//     * 在任何情况下本来适配正常的布局突然出现适配失效，适配异常等问题，只要重写 Activity 的 getResources() 方法
//     */
//    override fun getResources(): Resources {
//        AutoSizeCompat.autoConvertDensityOfGlobal(super.getResources())
//        return super.getResources()
//    }
    /**
     *  空实现 activity 可以自己实现 重试的code
     */
    override fun onReload() {}

    open fun getLoadSirWrapper():Any{
        Toast.makeText(this, "base", Toast.LENGTH_SHORT).show()
        return this
    }
}
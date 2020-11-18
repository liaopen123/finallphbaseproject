package com.lph.baselib.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * 作者　: hegaojian
 * 时间　: 2019/12/12
 * 描述　: ViewModel的基类 使用ViewModel类，放弃AndroidViewModel，原因：用处不大 完全有其他方式获取Application上下文
 */
open class BaseViewModel : ViewModel() {

    var loadingVM :MutableLiveData<Boolean> = MutableLiveData()

    fun showLoading(){
        loadingVM.value = true
    }

    fun hideLoading(){
        loadingVM.value = false
    }
}
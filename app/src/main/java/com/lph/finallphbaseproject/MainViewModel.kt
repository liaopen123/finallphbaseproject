package com.lph.finallphbaseproject

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lph.baselib.ext.request
import com.lph.baselib.network.bean.*
import com.lph.baselib.network.exception.ExceptionHandle
import com.lph.baselib.viewmodel.BaseViewModel
import com.lph.finallphbaseproject.data.repository.request.HttpRequestCoroutine
import com.lph.lphmvvmbaseproject.data.model.bean.HomeBannerBean
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainViewModel : BaseViewModel(){
    //方式1  自动脱壳过滤处理请求结果，判断结果是否成功
    var loginResult = MutableLiveData<ProjectResponse<ArrayList<HomeBannerBean>>>()
     val mTitle by lazy {
        MutableLiveData<String>()
    }

    fun notifyTitle(newTitle:String){
        mTitle.value = newTitle
    }

    fun getData(){
        request({HttpRequestCoroutine.getBanner()},loginResult)
    }






    fun <T>request(block:suspend ()->ProjectResponse<T>,resultViewModel:MutableLiveData<ProjectResponse<T>>,isShowDialog: Boolean=true){
        viewModelScope.launch {
            kotlin.runCatching {
                if (isShowDialog) showLoading()
                block()
            }.onSuccess {
                resultViewModel.value = it
                if (isShowDialog) hideLoading()
            }.onFailure {
                showError(ExceptionHandle.handleException(it).errorMsg)
                if (isShowDialog) hideLoading()
            }

        }
    }

}
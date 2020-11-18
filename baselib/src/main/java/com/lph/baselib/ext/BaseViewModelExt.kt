package com.lph.baselib.ext

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lph.baselib.network.bean.BaseResponse
import com.lph.baselib.network.bean.ResultState
import com.lph.baselib.network.bean.paresException
import com.lph.baselib.network.bean.paresResult
import com.lph.baselib.viewmodel.BaseViewModel
import kotlinx.coroutines.*



/**
 * net request 不校验请求结果数据是否是成功
 * @param block 请求体方法
 * @param resultState 请求回调的ResultState数据
 * @param isShowDialog 是否显示加载框
 * @param loadingMessage 加载框提示内容
 */
fun <T> BaseViewModel.request(
    block: suspend () -> BaseResponse<T>,
    resultState: MutableLiveData<ResultState<T>>,
    isShowDialog: Boolean = false,
    loadingMessage: String = "请求网络中..."
): Job {
    return viewModelScope.launch {
        runCatching {
            if (isShowDialog) resultState.value = ResultState.onAppLoading(loadingMessage)
            //请求体
            block()
        }.onSuccess {
            resultState.paresResult(it)
        }.onFailure {
            resultState.paresException(it)
        }
    }
}


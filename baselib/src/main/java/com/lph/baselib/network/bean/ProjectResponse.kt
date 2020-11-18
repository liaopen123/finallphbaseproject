package com.lph.baselib.network.bean

/**
 * 用来实现是否成功的逻辑
 */
data class ProjectResponse <T>(var errorCode:String,var errorMessage:String,var data:T):
    BaseResponse<T>(){
    override fun isSuccess()=errorCode=="0000"

    override fun getResponseData(): T {
        return data
    }

    override fun getResponseCode()=errorCode

    override fun getResponseMessage()=errorMessage
}
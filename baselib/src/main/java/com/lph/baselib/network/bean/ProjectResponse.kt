package com.lph.baselib.network.bean

/**
 * 用来实现是否成功的逻辑
 */
data class ProjectResponse <T>(var errorCode:Int,var errorMessage:String,var data:T){
     fun isSuccess()=errorCode==0

     fun getResponseData(): T {
        return data
    }

     fun getResponseCode()=errorCode

     fun getResponseMessage()=errorMessage


}
package com.lph.baselib.network.bean

abstract class BaseResponse<T> {
    abstract fun  isSuccess():Boolean
    abstract  fun getResponseData():T
    abstract  fun getResponseCode():Int
    abstract  fun getResponseMessage():String
}
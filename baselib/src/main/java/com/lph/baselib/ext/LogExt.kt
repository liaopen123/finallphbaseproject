package com.lph.baselib.ext

import android.app.Activity
import android.util.Log

const val TAG = "JetpackMvvm"

var jetpackMvvmLog = true

fun Activity.loge(message:String){
    Log.e(this.localClassName,message)
}
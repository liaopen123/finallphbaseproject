package com.lph.finallphbaseproject.base

import android.app.Application
import com.kingja.loadsir.core.LoadSir
import com.tencent.mmkv.MMKV

class App : Application() {

    companion object {
        lateinit var INSTANCE: Application
    }


    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        initMMKV()
        initLoadSir()


    }


    private fun initMMKV() {
        MMKV.initialize(this.filesDir.absolutePath + "/mmkv")
    }


    private fun initLoadSir() {
        LoadSir.beginBuilder()
            .addCallback(LoadingCallback())//加载
            .addCallback(EmptyCallback())//空
            .setDefaultCallback(SuccessCallback::class.java)//设置默认加载状态页
            .commit()
    }


}
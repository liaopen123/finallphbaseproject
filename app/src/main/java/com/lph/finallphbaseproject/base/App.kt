package com.lph.finallphbaseproject.base

import android.app.Application
import com.kingja.loadsir.core.LoadSir
import com.lph.finallphbaseproject.widget.loadsir.callback.*
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
            .addCallback(ErrorCallback())
            .addCallback(EmptyCallback())
            .addCallback(LoadingCallback())
            .addCallback(TimeoutCallback())
            .addCallback(CustomCallback())
            .setDefaultCallback(LoadingCallback::class.java)
            .commit()


    }


}
package com.lph.finallphbaseproject

import androidx.lifecycle.MutableLiveData
import com.lph.baselib.viewmodel.BaseViewModel

class MainViewModel : BaseViewModel(){

     val mTitle by lazy {
        MutableLiveData<String>()
    }

    fun notifyTitle(newTitle:String){
        mTitle.value = newTitle
    }

}
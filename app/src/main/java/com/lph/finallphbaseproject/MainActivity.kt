package com.lph.finallphbaseproject

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.lph.baselib.ext.loge
import com.lph.baselib.network.bean.BaseResponse
import com.lph.baselib.network.bean.ResultState
import com.lph.finallphbaseproject.base.BaseActivity
import com.lph.finallphbaseproject.data.repository.request.HttpRequestCoroutine
import com.lph.finallphbaseproject.databinding.ActivityMainBinding
import com.lph.finallphbaseproject.ext.hideLoadingExt
import com.lph.finallphbaseproject.widget.loadsir.callback.LoadingCallback
import com.lph.lphmvvmbaseproject.data.model.bean.HomeBannerBean
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {


    override fun layoutId() = R.layout.activity_main

    override fun initView(savedInstanceState: Bundle?) {
        mDataBinding.vm = mViewModel
        loadSir.showCallback(LoadingCallback::class.java)
    }


    override fun createObserver() {
        val mTitleObserver = Observer<String> { t ->
            Toast.makeText(this, "${t.toString()}", Toast.LENGTH_SHORT).show()
        }
        mViewModel.mTitle.observe(this, mTitleObserver)

    }

    override fun onStart() {
        super.onStart()
        mViewModel.notifyTitle("gaga")
        mViewModel.getData()



        }
    }


    fun <T>request(block:suspend()->BaseResponse<T>, ):Job{


    }

//    override fun getLoadSirWrapper(): Any {
//        Toast.makeText(this, "main", Toast.LENGTH_SHORT).show()
//       var view = findViewById<View>(R.id.ll_container)
//        return view
//    }
}
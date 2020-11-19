package com.lph.finallphbaseproject

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.lph.finallphbaseproject.base.BaseActivity
import com.lph.finallphbaseproject.databinding.ActivityMainBinding
import com.lph.finallphbaseproject.widget.loadsir.callback.LoadingCallback

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {


    override fun layoutId() = R.layout.activity_main

    override fun initView(savedInstanceState: Bundle?) {
        mDataBinding.vm = mViewModel
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




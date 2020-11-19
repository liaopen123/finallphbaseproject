package com.lph.finallphbaseproject.ext

import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.afollestad.materialdialogs.customview.getCustomView
import com.afollestad.materialdialogs.lifecycle.lifecycleOwner
import com.lph.finallphbaseproject.R


private var loadingDialog: MaterialDialog? = null

fun AppCompatActivity.showLoadingExt(message: String = "网络请求中") {
    if (!this.isFinishing) {

//        if (loadingDialog==null) {
        loadingDialog ?: let {
            loadingDialog = MaterialDialog(this).apply {
                cancelable(true)
                cancelOnTouchOutside(true)
                cornerRadius(12f)
                customView(R.layout.layout_custom_progress_dialog_view)
                lifecycleOwner(this@showLoadingExt)
            }


//        }
        }
        loadingDialog?.getCustomView()?.run {
            this.findViewById<TextView>(R.id.loading_tips).text = message
        }
        loadingDialog?.show()
    }
}

fun AppCompatActivity.hideLoadingExt() {
    loadingDialog?.dismiss()
    loadingDialog = null
}


fun Fragment.showLoadingExt(message: String = "网络请求中") {
    activity?.let {
        if (!it.isFinishing) {

//        if (loadingDialog==null) {
            loadingDialog ?: apply {
                loadingDialog = MaterialDialog(it).apply {
                    cancelable(true)
                    cancelOnTouchOutside(true)
                    cornerRadius(12f)
                    customView(R.layout.layout_custom_progress_dialog_view)
                    lifecycleOwner(this@showLoadingExt)
                }


//        }
            }
            loadingDialog?.getCustomView()?.run {
                this.findViewById<TextView>(R.id.loading_tips).text = message
            }
            loadingDialog?.show()
        }


    }

}

fun Fragment.hideLoadingExt() {
    loadingDialog?.dismiss()
    loadingDialog = null
}

package com.luxuanxuan.louboutin.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.View
import androidx.annotation.LayoutRes
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.afollestad.materialdialogs.customview.getCustomView

abstract class BaseDialog(val context: Context?) {

  private var dialog: MaterialDialog? = null

  var view: View? = null

  init {
    createDialog()
  }

  fun setContentView(@LayoutRes layout: Int) {
    dialog?.customView(layout, dialogWrapContent = true, noVerticalPadding = true)
    this.view = dialog?.getCustomView()
  }

  fun showDialog() {
    dialog?.show()
  }

  open fun setCanceledOnTouchOutside(isCancel: Boolean) {
    dialog?.cancelOnTouchOutside(false)
  }

  @SuppressLint("ResourceType")
  private fun createDialog() {
    dialog = MaterialDialog(context!!)
    dialog?.cornerRadius(0f)
    onCreateDialog()
  }

  abstract fun onCreateDialog()

  open fun dismiss() {
    dialog?.dismiss()
  }

  fun navigateTo(activity: Class<*>) {
    val intent = Intent(context, activity)
    context?.startActivity(intent)
  }
}
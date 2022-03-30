package com.luxuanxuan.louboutin.component.toolbar

import android.app.Activity
import android.content.Context
import androidx.appcompat.widget.Toolbar
import com.luxuanxuan.louboutin.R

class LouboutinToolbar {

  lateinit var activity: Activity
  private var listener: LouboutinToolbarListener? = null

  fun setupToolBarActivity() {
    val toolbar = activity.findViewById<Toolbar>(R.id.toolbar)
    if (toolbar != null) {
      toolbar.setNavigationOnClickListener {
        listener?.onNavigationClick()
      }
    }

  }

  fun setToolbarListener(listener: LouboutinToolbarListener) {
    this.listener = listener
  }

  interface LouboutinToolbarListener {
    fun onNavigationClick()
  }
}
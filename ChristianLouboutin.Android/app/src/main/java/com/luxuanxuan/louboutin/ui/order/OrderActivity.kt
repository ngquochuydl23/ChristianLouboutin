package com.luxuanxuan.louboutin.ui.order

import android.os.Bundle
import com.luxuanxuan.louboutin.R
import com.luxuanxuan.louboutin.ui.BaseActivity

class OrderActivity : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_order)

    initView()
  }

  private fun initView() {
    getLouboutinToolbar()
  }
}
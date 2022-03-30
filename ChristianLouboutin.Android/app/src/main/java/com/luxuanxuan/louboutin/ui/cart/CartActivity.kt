package com.luxuanxuan.louboutin.ui.cart

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.luxuanxuan.louboutin.R
import com.luxuanxuan.louboutin.repository.carts
import com.luxuanxuan.louboutin.ui.BaseActivity
import com.luxuanxuan.louboutin.ui.checkout.CheckoutActivity
import kotlinx.android.synthetic.main.activity_cart.*

class CartActivity : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_cart)

    initView()
  }

  private fun initView(){
    getLouboutinToolbar()

    cartRecyclerView.layoutManager = LinearLayoutManager(this)
    cartRecyclerView.adapter = CartAdapter(carts)

    checkoutButton.setOnClickListener {
      navigateTo(CheckoutActivity::class.java)
    }
  }
}
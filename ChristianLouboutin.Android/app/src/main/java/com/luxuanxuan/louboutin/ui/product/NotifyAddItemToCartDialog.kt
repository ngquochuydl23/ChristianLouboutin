package com.luxuanxuan.louboutin.ui.product

import android.app.Activity
import android.widget.Button
import android.widget.TextView
import com.luxuanxuan.louboutin.R
import com.luxuanxuan.louboutin.models.ItemCartDto
import com.luxuanxuan.louboutin.ui.BaseDialog
import com.luxuanxuan.louboutin.ui.cart.CartActivity

class NotifyAddItemToCartDialog(val activity: Activity) : BaseDialog(activity) {

  private var newItemCart : ItemCartDto? = null

  private var countItemTextView : TextView? = null
  private var priceTextViewv : TextView? = null
  private var checkoutButton : Button? = null
  private var closeButton : Button? = null


  override fun onCreateDialog() {
    setContentView(R.layout.dialog_notify_add_item_to_cart)

    countItemTextView = view?.findViewById(R.id.countItemTextView)
    priceTextViewv = view?.findViewById(R.id.priceTextView)
    checkoutButton = view?.findViewById(R.id.checkoutButton)
    closeButton = view?.findViewById(R.id.closeButton)

    checkoutButton?.setOnClickListener {
      navigateTo(CartActivity::class.java)
      dismiss()
    }

    closeButton?.setOnClickListener {
      dismiss()
    }
  }

  fun setNewItemCart(newItemCart : ItemCartDto){
    this.newItemCart = newItemCart
    priceTextViewv?.text = "${newItemCart.productPrice}$"
  }
}
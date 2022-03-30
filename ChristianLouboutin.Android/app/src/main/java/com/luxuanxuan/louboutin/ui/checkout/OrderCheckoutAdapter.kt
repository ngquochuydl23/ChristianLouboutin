package com.luxuanxuan.louboutin.ui.checkout

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.luxuanxuan.louboutin.R
import com.luxuanxuan.louboutin.models.ItemOrderCheckoutDto
import com.luxuanxuan.louboutin.ui.BaseAdapterRecyclerView

class OrderCheckoutAdapter(val ordersCheckout: ArrayList<ItemOrderCheckoutDto>?) :
  BaseAdapterRecyclerView<OrderCheckoutAdapter.OrderCheckoutViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderCheckoutViewHolder {
    val view = getView(parent, viewType, R.layout.item_order_checkout)
    return OrderCheckoutViewHolder(view)
  }

  override fun onBindViewHolder(holder: OrderCheckoutViewHolder, position: Int) {
    val orderCheckout = ordersCheckout?.get(position)

    holder.productNameTextView.text = orderCheckout?.productName
    holder.productSelectedAttributes.text = orderCheckout?.productSelectedAttribute
    holder.productPriceTextView.text = "$${orderCheckout?.productPrice}"
    holder.itemCountTextView.text = "x ${orderCheckout?.itemCount}"
    Glide.with(context)
      .load(orderCheckout?.productImage)
      .into(holder.productImageView)
  }

  override fun getItemCount(): Int {
    return getSizeList(ordersCheckout)
  }

  inner class OrderCheckoutViewHolder(val itemView: View) : BaseHolder(itemView) {
    val productImageView = itemView.findViewById<ImageView>(R.id.productImageView)
    val itemCountTextView = itemView.findViewById<TextView>(R.id.itemCountTextView)
    val productNameTextView = itemView.findViewById<TextView>(R.id.productNameTextView)
    val productPriceTextView = itemView.findViewById<TextView>(R.id.productPriceTextView)
    val productSelectedAttributes = itemView.findViewById<TextView>(R.id.productSelectedAttributes)
  }
}
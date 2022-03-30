package com.luxuanxuan.louboutin.ui.cart

import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.luxuanxuan.louboutin.R
import com.luxuanxuan.louboutin.models.ItemCartDto
import com.luxuanxuan.louboutin.ui.BaseAdapterRecyclerView
import com.luxuanxuan.louboutin.ui.categorydetail.CategoryDetailActivity
import com.luxuanxuan.louboutin.ui.home.searchtab.CategoryAdapter

class CartAdapter(val carts: ArrayList<ItemCartDto>?) :
  BaseAdapterRecyclerView<CartAdapter.CartViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
    val view = getView(parent, viewType, R.layout.item_cart)
    return CartViewHolder(view)
  }

  override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
    val cart = carts?.get(position)

    holder.productNameTextView.text = cart?.productName
    holder.productSelectedAttributes.text = cart?.productSelectedAttribute
    holder.itemCountTextView.text = cart?.currentItemCount.toString()

    Glide.with(context)
      .load(cart?.productImage)
      .into(holder.productImageView)

    holder.priceTextView.text = "${cart?.productPrice}$"

    holder.increaseButton.setOnClickListener {
      cart!!.currentItemCount = cart.currentItemCount!! + 1
    }

    holder.decreaseButton.setOnClickListener {
      if (cart?.currentItemCount!! > 1) {
        cart.currentItemCount = cart.currentItemCount!! - 1
      }
    }
  }

  override fun getItemCount(): Int {
    return getSizeList(carts)
  }

  inner class CartViewHolder(itemView: View) : BaseHolder(itemView) {
    val productNameTextView = itemView.findViewById<TextView>(R.id.productNameTextView)
    val productImageView = itemView.findViewById<ImageView>(R.id.productImageView)
    val productSelectedAttributes = itemView.findViewById<TextView>(R.id.productSelectedAttributes)
    val priceTextView = itemView.findViewById<TextView>(R.id.priceTextView)
    val decreaseButton = itemView.findViewById<Button>(R.id.decreaseButton)
    val increaseButton = itemView.findViewById<Button>(R.id.increaseButton)
    val itemCountTextView = itemView.findViewById<TextView>(R.id.itemCountTextView)
  }

}
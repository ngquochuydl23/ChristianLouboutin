package com.luxuanxuan.louboutin.ui.product

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.luxuanxuan.louboutin.R
import com.luxuanxuan.louboutin.models.ItemProductDto
import com.luxuanxuan.louboutin.ui.BaseAdapterRecyclerView

class ProductAdapter(val products: ArrayList<ItemProductDto>?,val  horizontal : Boolean = false) :
  BaseAdapterRecyclerView<ProductAdapter.ProductViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
    var view : View
    if (horizontal) {
      view = getView(parent, viewType, R.layout.item_product_horizontal)
    } else {
      view = getView(parent, viewType, R.layout.item_product)
    }
    return ProductViewHolder(view)
  }

  override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
    val product = products?.get(position)

    holder.productNameTextView.text = product?.productName
    holder.containClick.setOnClickListener {
      navigateTo(ProductDetailActivity::class.java)
    }

    Glide.with(context)
      .load(product?.productImage)
      .into(holder.productImageView)

    holder.productPriceTextView.text = "${product?.price}$"
  }

  override fun getItemCount(): Int {
    return getSizeList(products)
  }

  inner class ProductViewHolder(itemView: View) : BaseHolder(itemView) {
    val containClick = itemView.findViewById<View>(R.id.containClick)
    val productImageView = itemView.findViewById<ImageView>(R.id.productImageView)
    val productNameTextView = itemView.findViewById<TextView>(R.id.productNameTextView)
    val productPriceTextView = itemView.findViewById<TextView>(R.id.productPriceTextView)
  }

}
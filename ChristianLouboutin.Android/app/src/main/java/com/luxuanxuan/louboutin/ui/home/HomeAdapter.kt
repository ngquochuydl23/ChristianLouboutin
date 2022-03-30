package com.luxuanxuan.louboutin.ui.home

import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.luxuanxuan.louboutin.R
import com.luxuanxuan.louboutin.models.ItemHomeDto
import com.luxuanxuan.louboutin.models.ItemProductDto
import com.luxuanxuan.louboutin.ui.BaseAdapterRecyclerView
import com.luxuanxuan.louboutin.ui.product.ProductAdapter
import com.luxuanxuan.louboutin.ui.product.ProductDetailActivity

class HomeAdapter(val itemsHome: ArrayList<ItemHomeDto>?) :
  BaseAdapterRecyclerView<HomeAdapter.HomeViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
    val view = getView(parent, viewType, R.layout.item_home)
    return HomeViewHolder(view)
  }

  override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
    val itemHome = itemsHome?.get(position)

    holder.itemHomeTitle.text = itemHome?.title

    itemHome?.subtitle?.let {
      holder.itemHomeSubtitle.text = it
    }

    holder.itemHomeContentRecyclerView.apply {
      layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
      when (itemHome?.type) {
        PRODUCTS -> adapter = ProductAdapter(itemHome.products, true)
      }
    }

    holder.shopNowButton.setOnClickListener {

    }
  }

  override fun getItemCount(): Int {
    return getSizeList(itemsHome)
  }

  inner class HomeViewHolder(itemView: View) : BaseHolder(itemView) {
    val itemHomeTitle = itemView.findViewById<TextView>(R.id.itemHomeTitle)
    val itemHomeSubtitle = itemView.findViewById<TextView>(R.id.itemHomeSubtitle)
    val itemHomeContentRecyclerView =
      itemView.findViewById<RecyclerView>(R.id.itemHomeContentRecyclerView)
    val shopNowButton = itemView.findViewById<Button>(R.id.shopNowButton)
  }

  companion object {
    val PRODUCTS = "product"
    val STORES = "stores"
  }
}
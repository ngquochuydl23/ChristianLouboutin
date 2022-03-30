package com.luxuanxuan.louboutin.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.luxuanxuan.louboutin.R
import com.luxuanxuan.louboutin.models.ItemBannerDto
import com.luxuanxuan.louboutin.ui.BaseAdapterRecyclerView
import com.luxuanxuan.louboutin.ui.BasePagerAdapter
import com.luxuanxuan.louboutin.ui.home.searchtab.CategoryAdapter
import com.zhpan.bannerview.BaseBannerAdapter
import com.zhpan.bannerview.BaseViewHolder

class BannerAdapter : BaseBannerAdapter<ItemBannerDto?>() {

  override fun bindData(
    holder: BaseViewHolder<ItemBannerDto?>,
    data: ItemBannerDto?,
    position: Int,
    pageSize: Int
  ) {
    val bannerImageView: ImageView = holder.findViewById(R.id.bannerImageView)
    Glide.with(bannerImageView.context)
      .load(data?.imageUrl)
      .into(bannerImageView)
  }

  override fun getLayoutId(viewType: Int): Int {
    return R.layout.item_banner
  }
}
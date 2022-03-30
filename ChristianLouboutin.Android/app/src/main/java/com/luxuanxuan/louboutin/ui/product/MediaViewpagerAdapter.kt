package com.luxuanxuan.louboutin.ui.product

import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.luxuanxuan.louboutin.R
import com.luxuanxuan.louboutin.models.ItemMediaDto
import com.luxuanxuan.louboutin.ui.BasePagerAdapter
import com.luxuanxuan.louboutin.ui.home.searchtab.CategoryAdapter
import com.luxuanxuan.louboutin.ui.product.media.ProductMediaActivity
import android.os.Parcel




class MediaViewpagerAdapter(
  val medias: ArrayList<ItemMediaDto>?,
  val allowToZoom: Boolean = false
) : BasePagerAdapter() {

  override fun isViewFromObject(view: View, `object`: Any): Boolean {
    return view == `object`
  }

  override fun instantiateItem(container: ViewGroup, position: Int): Any {
    val view = getView(container, R.layout.item_media)

    val media = medias?.get(position)
    val productMediaView =
      view.findViewById<ImageView>(R.id.productMediaView)

    val productGestureMediaView =
      view.findViewById<ImageView>(R.id.productGestureMediaView)

    if (allowToZoom) {
      productMediaView.visibility = View.GONE
      productGestureMediaView.visibility = View.VISIBLE

      Glide.with(context)
        .load(media?.url)
        .into(productGestureMediaView)

    } else {
      productMediaView.visibility = View.VISIBLE
      productGestureMediaView.visibility = View.GONE

      Glide.with(context)
        .load(media?.url)
        .into(productMediaView)

      productMediaView.setOnClickListener {
        Intent(context, ProductMediaActivity::class.java).let {

          it.putExtra(TabPositionKey, position)
          it.putParcelableArrayListExtra(Medias, medias)
          context.startActivity(it)
        }
      }
    }

    container.addView(view)
    return view
  }

  override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
    container.removeView(`object` as View)
  }

  override fun getCount(): Int {
    return medias?.size ?: 0
  }

  companion object {
    val TabPositionKey = "tab-position-key"
    val Medias = "medias"
  }
}
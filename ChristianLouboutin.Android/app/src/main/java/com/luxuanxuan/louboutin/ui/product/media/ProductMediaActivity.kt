package com.luxuanxuan.louboutin.ui.product.media

import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.luxuanxuan.louboutin.R
import com.luxuanxuan.louboutin.models.ItemMediaDto
import com.luxuanxuan.louboutin.ui.BaseActivity
import com.luxuanxuan.louboutin.ui.product.MediaViewpagerAdapter
import kotlinx.android.synthetic.main.activity_product_media.*

class ProductMediaActivity : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_product_media)

    initView()
  }

  private fun initView() {
    getLouboutinToolbar()

    val currentPosition = intent.getIntExtra(MediaViewpagerAdapter.TabPositionKey, 0)
    val medias = intent.getParcelableArrayListExtra<ItemMediaDto>(MediaViewpagerAdapter.Medias)

    mediasViewpager.adapter = MediaViewpagerAdapter(medias, allowToZoom = true)
    mediasViewpager.currentItem = currentPosition
    wormDotsIndicator.setViewPager(mediasViewpager)
  }
}
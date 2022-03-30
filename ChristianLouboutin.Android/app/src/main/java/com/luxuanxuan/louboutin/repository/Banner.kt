package com.luxuanxuan.louboutin.repository

import com.luxuanxuan.louboutin.models.ItemBannerDto

val banner1 = ItemBannerDto().apply {
  imageUrl = "https://www.theflowers.vn/wp-content/uploads/2013/08/banner-louboutin-lipstick-rmk.jpg"
}



val banner2 = ItemBannerDto().apply {
  imageUrl = "https://i.pinimg.com/originals/a9/bf/62/a9bf62b6594eda6c846663c365b5d7e5.jpg"

}

val banner3 = ItemBannerDto().apply {
  imageUrl = "https://asset1.ruecdn.com/images/content/events/516847/516847_banner_tablet.jpg"

}

val banners = arrayListOf(banner1,banner2,banner3)
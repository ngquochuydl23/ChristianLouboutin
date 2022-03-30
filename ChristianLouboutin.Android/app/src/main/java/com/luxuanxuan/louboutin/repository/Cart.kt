package com.luxuanxuan.louboutin.repository

import com.luxuanxuan.louboutin.models.ItemCartDto

val cart1 = ItemCartDto().apply {
  id = 1
  productName = "Christian Louboutin So Kate 120 Patent"
  productImage =
    "https://cdn-us.christianlouboutin.com/media/catalog/product/cache/50910a554f402a7e962c16653ab289e4/3/1/3130694bk01-3130694bk01-main_image-ecommerce-christianlouboutin-sokate-3130694_bk01_1_1200x1200.jpg"
  productPrice = 675.0
  productSelectedAttribute = "Color : Black\nSize : 38"
  currentItemCount = 1
}

val cart2 = ItemCartDto().apply {
  id = 1
  productName = "Christian Louboutin Iriza 100 Patent"
  productImage =
    "https://cdn-us.christianlouboutin.com/media/catalog/product/cache/50910a554f402a7e962c16653ab289e4/3/1/3130524bk01-3130524bk01-main_image-ecommerce-christianlouboutin-iriza-3130524_bk01_1_1200x1200.jpg"
  productPrice = 745.0
  productSelectedAttribute = "Color : Black\nSize : 38"
  currentItemCount = 1
}


val cart3 = ItemCartDto().apply {
  id = 1
  productName = "Christian Louboutin Galativi 100"
  productImage =
    "https://cdn-us.christianlouboutin.com/media/catalog/product/cache/50910a554f402a7e962c16653ab289e4/1/2/1200557cm47-1200557cm47-main_image-ecommerce-christianlouboutin-galativi-1200557_cm47_1_1200x1200.jpg"
  productPrice = 745.0
  productSelectedAttribute = "Size : 38"
  currentItemCount = 1
}

val carts = arrayListOf(cart1, cart2, cart3)
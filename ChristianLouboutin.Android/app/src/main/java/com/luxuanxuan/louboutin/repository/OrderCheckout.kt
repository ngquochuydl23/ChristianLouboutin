package com.luxuanxuan.louboutin.repository

import com.luxuanxuan.louboutin.models.ItemCartDto
import com.luxuanxuan.louboutin.models.ItemOrderCheckoutDto

val orderck1 = ItemOrderCheckoutDto().apply {
  id = 1
  productName = "Christian Louboutin So Kate 120 Patent"
  productPrice = 745.0
  productSelectedAttribute = "Color : Black\nSize : 38"
  productImage =
    "https://cdn-us.christianlouboutin.com/media/catalog/product/cache/50910a554f402a7e962c16653ab289e4/3/1/3130694bk01-3130694bk01-main_image-ecommerce-christianlouboutin-sokate-3130694_bk01_1_1200x1200.jpg"
  itemCount = 1
}

val orderck2 = ItemOrderCheckoutDto().apply{
  id = 1
  productName = "Christian Louboutin Iriza 100 Patent"
  productImage =
    "https://cdn-us.christianlouboutin.com/media/catalog/product/cache/50910a554f402a7e962c16653ab289e4/3/1/3130524bk01-3130524bk01-main_image-ecommerce-christianlouboutin-iriza-3130524_bk01_1_1200x1200.jpg"
  productPrice = 745.0
  productSelectedAttribute = "Color : Black\nSize : 38"
  itemCount = 1
}


val orderck3 = ItemOrderCheckoutDto().apply {
  id = 1
  productName = "Christian Louboutin Galativi 100"
  productImage =
    "https://cdn-us.christianlouboutin.com/media/catalog/product/cache/50910a554f402a7e962c16653ab289e4/1/2/1200557cm47-1200557cm47-main_image-ecommerce-christianlouboutin-galativi-1200557_cm47_1_1200x1200.jpg"
  productPrice = 745.0
  productSelectedAttribute = "Size : 38"
  itemCount = 1
}

val ordersCheckout = arrayListOf(orderck1, orderck2, orderck3)
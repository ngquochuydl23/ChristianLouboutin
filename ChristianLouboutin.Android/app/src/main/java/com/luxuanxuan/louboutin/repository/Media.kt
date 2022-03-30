package com.luxuanxuan.louboutin.repository

import com.luxuanxuan.louboutin.models.ItemAttributeDto
import com.luxuanxuan.louboutin.models.ItemChildAttributeDto
import com.luxuanxuan.louboutin.models.ItemMediaDto
import com.luxuanxuan.louboutin.models.ItemProductInfoDto

val media1 = ItemMediaDto().apply {
  id = 1
  url =
    "https://cdn-us.christianlouboutin.com/media/catalog/product/cache/5bcdb24aa9c15018a5ab3af437bdd937/3/1/3130694bk01-3130694bk01-main_image-ecommerce-christianlouboutin-sokate-3130694_bk01_1_1200x1200.jpg"
  type = "image"
}

val media2 = ItemMediaDto().apply {
  id = 1
  url =
    "https://cdn-us.christianlouboutin.com/media/catalog/product/cache/5bcdb24aa9c15018a5ab3af437bdd937/3/1/3130694bk01-3130694bk01-hover-ecommerce-christianlouboutin-sokate-3130694_bk01_2_1200x1200.jpg"
  type = "image"
}

val media3 = ItemMediaDto().apply {
  id = 1
  url =
    "https://cdn-us.christianlouboutin.com/media/catalog/product/cache/5bcdb24aa9c15018a5ab3af437bdd937/3/1/3130694bk01-3130694bk01-additional_1-ecommerce-christianlouboutin-sokate-3130694_bk01_3_1200x1200.jpg"
  type = "image"
}

val media4 = ItemMediaDto().apply {
  id = 1
  url =
    "https://static-eu.christianlouboutin.com/media/catalog/product/cache/50910a554f402a7e962c16653ab289e4/3/1/3191411bk01-3191411bk01-additional_2-ecommerce-christianlouboutin-kate-3191411_bk01_4_1200x1200.jpg"
  type = "image"
}

val media5 = ItemMediaDto().apply {
  id = 3
  url =
    "https://static-eu.christianlouboutin.com/media/catalog/product/cache/50910a554f402a7e962c16653ab289e4/3/1/3191411bk01-3191411bk01-hover-ecommerce-christianlouboutin-kate-3191411_bk01_2_1200x1200.jpg"
  type = "image"
}

val medias = arrayListOf(media1, media2, media3, media4, media5)

val attribute1 = ItemAttributeDto().apply {
  id = 1
  isRequire = true
  name = "Color"
  childs = arrayListOf(
    ItemChildAttributeDto().apply {
      soldOut = false
      hasImage = true
      name = "Nude"
      imageUrl =
        "https://images.us.christianlouboutin.com/media/catalog/product/cache/1/thumbnail/1200x/602f0fa2c1f0d1ba5e241f914e856ff9/3/1/3/0/christianlouboutin-sokate-3130694_PK1A_1_1200x1200_1541591834.jpg"
    },

    ItemChildAttributeDto().apply {
      soldOut = false
      hasImage = true
      name = "Red"
      imageUrl =
        "https://cdn-us.christianlouboutin.com/media/catalog/product/cache/50910a554f402a7e962c16653ab289e4/3/1/3130694r251-3130694r251-main_image-ecommerce-christianlouboutin-sokate-3130694_r251_1_1200x1200.jpg"
    },
  )
}

val attribute2 = ItemAttributeDto().apply {
  id = 1
  isRequire = true
  name = "Size"
  childs = arrayListOf(
    ItemChildAttributeDto().apply {
      hasImage = false
      name = "35.5"
      soldOut = false
    },

    ItemChildAttributeDto().apply {
      hasImage = false
      name = "36"
      soldOut = false
    },

    ItemChildAttributeDto().apply {
      hasImage = false
      name = "37"
      soldOut = false
    },

    ItemChildAttributeDto().apply {
      hasImage = false
      name = "38"
      soldOut = false
    },

    ItemChildAttributeDto().apply {
      hasImage = false
      name = "39"
      soldOut = false
    },

    ItemChildAttributeDto().apply {
      hasImage = false
      name = "40"
      soldOut = true
    },

    ItemChildAttributeDto().apply {
      hasImage = false
      name = "40.5"
      soldOut = true
    },
  )
}

val attributes = arrayListOf(attribute1, attribute2)


val productInfo = ItemProductInfoDto().apply {
  id = 1
  title = "Product Information"
  content = "Reference : 3130694BK01\n" +
          "Color : BLACK\n" +
          "Material : Patent Leather\n" +
          "Heel Height : 120 mm\n" +
          "Collection : Fall Winter 13"
}

val productShipping = ItemProductInfoDto().apply {
  id = 1
  title = "Shipping"
  content = "you are available to sign for your order. If the driver is unable to obtain a signature a customer service representative wil call to arrange another delivery which will be subject to a fee."
}

val returnAndExchange = ItemProductInfoDto().apply {
  id = 1
  title = "Return & Exchange"
  content = "Merchandise must be returned to us within 30 days from the date of delivery\n" +
          "You can request your return by logging into your account, or by visiting our returns page. For direct assistance you may contact us at +1 888 856 8247 (1888-8LOUBIS).\n" +
          "We apologize but Online Orders can NOT be returned at a Boutique.\n" +
          "The red sole must be in perfect condition. Returning shoes of which the soles appear damaged may result in a fee\n" +
          "We offer free shipping on your exchange item(s)\n" +
          "See our Return policy"
}

val productInfos = arrayListOf(productInfo, productShipping, returnAndExchange)
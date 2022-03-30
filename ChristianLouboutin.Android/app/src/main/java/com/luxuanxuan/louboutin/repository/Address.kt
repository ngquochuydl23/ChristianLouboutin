package com.luxuanxuan.louboutin.repository

import com.luxuanxuan.louboutin.models.ItemAddressDto

val address1 = ItemAddressDto().apply {
  id = 1
  fullName = "Lu Xuan Xuan"
  address = "59 Xô Viết Nghệ Tĩnh, Phường 7, Thành phố Đà Lạt"
  phoneNumber = "0868684961"
  isDefault = true
}

val address2 = ItemAddressDto().apply {
  id = 1
  fullName = "Vũ Hoàng Uyên Nhi"
  address = "48 Vạn Thành, Phường 5, Thành phố Đà Lạt"
  phoneNumber = "0868684961"
  isDefault = false
}

val addresses = arrayListOf(address1, address2)
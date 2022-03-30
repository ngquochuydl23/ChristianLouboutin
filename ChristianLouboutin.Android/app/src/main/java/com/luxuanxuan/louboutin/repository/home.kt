package com.luxuanxuan.louboutin.repository

import com.luxuanxuan.louboutin.models.ItemHomeDto
import com.luxuanxuan.louboutin.ui.home.HomeAdapter.Companion.PRODUCTS

val homeItem = ItemHomeDto().apply {
  id = 1
  title = "New In"
  subtitle = "Hand-picked daily from the world's best brands and boutiques"
  type = PRODUCTS
  products = newIn
}

val bagsItem = ItemHomeDto().apply {
  id = 1
  title = "You may like handbags"
  subtitle = "Hand-picked daily from the world's best brands and boutiques"
  type = PRODUCTS
  products = Bags
}

val nailsItem = ItemHomeDto().apply {
  id = 1
  title = "Nails for you"
  subtitle = "Hand-picked daily from the world's best brands and boutiques"
  type = PRODUCTS
  products = Nails
}

val forMen = ItemHomeDto().apply {
  id = 1
  title = "New Lips"
  subtitle = "Say you do"
  type = PRODUCTS
  products = mens
}

val homes = arrayListOf(homeItem, bagsItem, nailsItem, forMen)
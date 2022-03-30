package com.luxuanxuan.louboutin.repository

import com.luxuanxuan.louboutin.models.SearchHistoryDto

val SearchHistory = SearchHistoryDto().apply {
  id = 1
  title = "High heels"
  subtitle = "Women"
}

val SearchHistory1 = SearchHistoryDto().apply {
  id = 2
  title = "Accessories"
  subtitle = "Women"
}

val SearchHistory2 = SearchHistoryDto().apply {
  id = 2
  title = "Bags"
  subtitle = "Women"
}

val listSearchHistory = arrayListOf(SearchHistory, SearchHistory1, SearchHistory2)
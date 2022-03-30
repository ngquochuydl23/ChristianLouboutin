package com.luxuanxuan.louboutin.ui.home.searchtab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.luxuanxuan.louboutin.R
import com.luxuanxuan.louboutin.ui.BaseFragment
import com.luxuanxuan.louboutin.ui.search.SearchActivity
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : BaseFragment() {

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_search, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val parentTabs = arrayListOf("Women", "Men", "The icons", "Beauty", "Louboutin World", "Store")
    val categoryParent = arrayListOf("New Arrivals", "High Heels", "Shoes", "Bags", "Assessories")
    tabParentLayout.setupWithViewPager(tabParentViewPager)
    tabParentViewPager.adapter = CategoryViewPagerAdapter(parentTabs, categoryParent)

    searchButton.setOnClickListener {
      navigateTo(SearchActivity::class.java)
    }
  }
}
package com.luxuanxuan.louboutin.ui.categorydetail

import android.os.Bundle
import com.luxuanxuan.louboutin.R
import com.luxuanxuan.louboutin.repository.listPumbs
import com.luxuanxuan.louboutin.ui.BaseActivity
import com.luxuanxuan.louboutin.ui.product.ProductAdapter
import kotlinx.android.synthetic.main.activity_category_detail.*
import kotlinx.android.synthetic.main.activity_category_detail.productsRecyclerView
import kotlinx.android.synthetic.main.fragment_search_result.*

class CategoryDetailActivity : BaseActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_category_detail)

    initView()
  }

  private fun initView() {
    getLouboutinToolbar()
    val parentTabs = arrayListOf("Hot Chick", "Kate", "So Kate", "Iriza", "Galativi", "Follies Strass", "Pigalle Follies")

    for (tab in parentTabs) {
      tabLayout.addTab(
        tabLayout.newTab().setText(tab)
      )
    }
    productsRecyclerView.adapter = ProductAdapter(listPumbs)
  }
}
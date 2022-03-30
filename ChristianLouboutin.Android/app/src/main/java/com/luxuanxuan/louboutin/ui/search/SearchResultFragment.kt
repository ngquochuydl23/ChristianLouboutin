package com.luxuanxuan.louboutin.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.luxuanxuan.louboutin.R
import com.luxuanxuan.louboutin.repository.listPumbs
import com.luxuanxuan.louboutin.ui.BaseFragment
import com.luxuanxuan.louboutin.ui.product.ProductAdapter
import kotlinx.android.synthetic.main.fragment_enter_seach.*
import kotlinx.android.synthetic.main.fragment_enter_seach.toolbar
import kotlinx.android.synthetic.main.fragment_search_result.*

class SearchResultFragment : BaseFragment() {

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_search_result, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    toolbar.setNavigationOnClickListener {
      currentActivity.finish()
    }

    productsRecyclerView.adapter = ProductAdapter(listPumbs)
  }
}
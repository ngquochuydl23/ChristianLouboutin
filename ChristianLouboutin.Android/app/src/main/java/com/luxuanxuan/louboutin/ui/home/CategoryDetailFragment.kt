package com.luxuanxuan.louboutin.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.luxuanxuan.louboutin.R
import com.luxuanxuan.louboutin.repository.categoryChild1
import com.luxuanxuan.louboutin.ui.BaseFragment
import com.luxuanxuan.louboutin.ui.home.searchtab.CategoryAdapter
import kotlinx.android.synthetic.main.fragment_category_detail.*


class CategoryDetailFragment : BaseFragment() {


  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_category_detail, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    toolbar.setNavigationOnClickListener {
      activity?.onBackPressed()
    }

    childCategoryRecyclerView.layoutManager = LinearLayoutManager(context)
    childCategoryRecyclerView.adapter = CategoryAdapter(categoryChild1).apply {
      setListener(object : CategoryAdapter.CategoryAdapterListener {
        override fun onItemClick(category: String?) {
          addFragmentToStack(CategoryDetailFragment(), CategoryDetailFragment.tag)
        }
      })
    }
  }

  companion object {
    val tag = "CategoryDetailFragment"
  }
}
package com.luxuanxuan.louboutin.ui.home.searchtab

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.luxuanxuan.louboutin.R
import com.luxuanxuan.louboutin.ui.BasePagerAdapter

class CategoryViewPagerAdapter(
  val parentTabs: ArrayList<String>,
  val categories: ArrayList<String>
) : BasePagerAdapter() {

  override fun isViewFromObject(view: View, `object`: Any): Boolean {
    return view == `object`
  }

  override fun instantiateItem(container: ViewGroup, position: Int): Any {
    val view = getView(container, R.layout.layout_category_content)

    val parentCategoryRecyclerView =
      view.findViewById<RecyclerView>(R.id.parentCategoryRecyclerView)

    parentCategoryRecyclerView.layoutManager = LinearLayoutManager(view.context)
    parentCategoryRecyclerView.adapter = CategoryAdapter(categories)
    container.addView(view)
    return view
  }

  override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
    container.removeView(`object` as View)
  }

  override fun getCount(): Int {
    return parentTabs.size
  }

  override fun getPageTitle(position: Int): CharSequence? {
    return parentTabs.get(position)
  }
}
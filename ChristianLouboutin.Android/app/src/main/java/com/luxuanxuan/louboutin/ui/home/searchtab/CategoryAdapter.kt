package com.luxuanxuan.louboutin.ui.home.searchtab

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.luxuanxuan.louboutin.R
import com.luxuanxuan.louboutin.ui.BaseAdapterRecyclerView
import com.luxuanxuan.louboutin.ui.categorydetail.CategoryDetailActivity

class CategoryAdapter(val categories: ArrayList<String>?) :
  BaseAdapterRecyclerView<CategoryAdapter.CategoryViewHolder>() {

  private var listener : CategoryAdapterListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
    val view = getView(parent, viewType, R.layout.item_category)
    return CategoryViewHolder(view)
  }

  override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
    val category = categories?.get(position)

    holder.categoryName.setText(category)
    holder.categoryName.setOnClickListener {
      //navigateTo(CategoryDetailActivity::class.java)
      listener?.onItemClick(category)
    }
  }

  override fun getItemCount(): Int {
    return getSizeList(categories)
  }

  fun setListener(listener : CategoryAdapterListener){
    this.listener = listener
  }

  inner class CategoryViewHolder(val itemView: View) : BaseHolder(itemView) {
    val categoryName = itemView.findViewById<TextView>(R.id.categoryName)
  }

  interface CategoryAdapterListener {
    fun onItemClick(category : String?)
  }
}
package com.luxuanxuan.louboutin.ui.product.attribute

import android.graphics.Rect
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.luxuanxuan.louboutin.R
import com.luxuanxuan.louboutin.models.ItemAttributeDto
import com.luxuanxuan.louboutin.models.ItemChildAttributeDto
import com.luxuanxuan.louboutin.models.SelectedAttribute
import com.luxuanxuan.louboutin.ui.BaseAdapterRecyclerView
import com.luxuanxuan.louboutin.ui.categorydetail.CategoryDetailActivity
import com.luxuanxuan.louboutin.ui.home.searchtab.CategoryAdapter

class AttributeAdapter(val attributes: ArrayList<ItemAttributeDto>?) :
  BaseAdapterRecyclerView<AttributeAdapter.AttributeViewHolder>() {

  private val SPAN_COUNT = 6
  var selectedAttributes: ArrayList<SelectedAttribute>

  init {
    selectedAttributes = arrayListOf()
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttributeViewHolder {
    val view = getView(parent, viewType, R.layout.item_attribute)
    return AttributeViewHolder(view)
  }

  override fun onBindViewHolder(holder: AttributeViewHolder, position: Int) {
    val attribute = attributes?.get(position)
    var selected: SelectedAttribute? = null

    holder.attributeName.text = attribute?.name + ": "

    selectChildAttributeView(holder, selected)

    val adapter = AttributeChildAdapter(attribute?.id, attribute?.childs).apply {
      setListener(object : AttributeChildAdapter.AttributeChildListener {
        override fun onItemSelected(attr: SelectedAttribute?) {
          selected = attr
          selectChildAttributeView(holder, selected)
        }
      })
    }

    holder.childAttributesRecyclerView.let {
      it.layoutManager = GridLayoutManager(context, SPAN_COUNT, RecyclerView.VERTICAL, false)
      it.addItemDecoration(object : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(
          outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
        ) {
          super.getItemOffsets(outRect, view, parent, state)

          val pos = parent.getChildAdapterPosition(view)
          if (pos >= SPAN_COUNT) {

            // Since this item is in the second row then
            // space the first row 25px
            outRect.top = 25
          }
        }
      })
      it.adapter = adapter
    }
  }

  override fun getItemCount(): Int {
    return getSizeList(attributes)
  }

  private fun selectChildAttributeView(view: AttributeViewHolder, selected: SelectedAttribute?) {
    if (selected != null) {
      view.attributeSelected.visibility = View.VISIBLE
      view.attributeSelected.text = selected.nameChildAttribute
    } else {
      view.attributeSelected.visibility = View.GONE
    }
  }

  inner class AttributeViewHolder(val itemView: View) : BaseHolder(itemView) {
    val attributeName = itemView.findViewById<TextView>(R.id.attributeName)
    val attributeSelected = itemView.findViewById<TextView>(R.id.attributeSelected)
    val childAttributesRecyclerView =
      itemView.findViewById<RecyclerView>(R.id.childAttributesRecyclerView)
  }

}
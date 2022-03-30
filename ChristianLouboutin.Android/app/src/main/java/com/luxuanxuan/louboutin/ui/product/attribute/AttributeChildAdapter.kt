package com.luxuanxuan.louboutin.ui.product.attribute

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.luxuanxuan.louboutin.R
import com.luxuanxuan.louboutin.models.ItemAttributeDto
import com.luxuanxuan.louboutin.models.ItemChildAttributeDto
import com.luxuanxuan.louboutin.models.SelectedAttribute
import com.luxuanxuan.louboutin.ui.BaseAdapterRecyclerView

class AttributeChildAdapter(
  val parentId: Int?,
  val childAttributes: ArrayList<ItemChildAttributeDto>?
) : BaseAdapterRecyclerView<AttributeChildAdapter.ChildAttributeViewHolder>() {

  private var listener: AttributeChildListener? = null
  private var lastCheckedPosition = -1

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildAttributeViewHolder {
    val view = getView(parent, viewType, R.layout.item_child_attribute)
    return ChildAttributeViewHolder(view)
  }

  override fun onBindViewHolder(holder: ChildAttributeViewHolder, position: Int) {
    val childAttribute = childAttributes?.get(position)

    if (childAttribute?.hasImage!!) {

      // Hide the text and show the image
      holder.childAttrImage.visibility = View.VISIBLE
      holder.childAttrName.visibility = View.GONE

      // Load image with Glide
      Glide.with(context)
        .load(childAttribute.imageUrl)
        .into(holder.childAttrImage)
    } else {

      //Hide the image and show the text
      holder.childAttrImage.visibility = View.GONE
      holder.childAttrName.visibility = View.VISIBLE
      holder.childAttrName.text = childAttribute.name
    }

    if (childAttribute.soldOut!!) {

      // If the attribute is sold out then
      // set shadow and set light gray text color
      holder.childAttrName.setTextColor(ContextCompat.getColor(context, R.color.lightgray))
      holder.soldOutView.visibility = View.VISIBLE
    } else {

      // If the attribute isn't sold out then
      // set black text color
      holder.childAttrName.setTextColor(ContextCompat.getColor(context, R.color.black))
      holder.soldOutView.visibility = View.GONE
    }

    holder.containClick.setOnClickListener {
      if (!childAttribute.soldOut!!) {
        if (lastCheckedPosition == position) {
          // If we click the item again, the item is unselect
          // remove lastItemView by setting `lastItemView` = null and `lastCheckedPosition` = -1

          lastCheckedPosition = -1
          listener?.onItemSelected(null)
        } else {

          // If the item is not selected, select this item
          lastCheckedPosition = position
          listener?.onItemSelected(
            SelectedAttribute(
              parentId,
              childAttribute.id,
              childAttribute.name
            )
          )
        }
        notifyDataSetChanged()
      }
    }

    if (lastCheckedPosition == position) {
      holder
        .containClick
        .setBackgroundDrawable(context.resources.getDrawable(R.drawable.rectangle_child_attribute_red))
    } else {
      holder
        .containClick
        .setBackgroundDrawable(context.resources.getDrawable(R.drawable.rectangle_child_attribute_black))
    }
  }

  override fun getItemCount(): Int {
    return getSizeList(childAttributes)
  }

  fun setListener(listener: AttributeChildListener) {
    this.listener = listener
  }

  inner class ChildAttributeViewHolder(itemView: View) : BaseHolder(itemView) {
    val childAttrImage = itemView.findViewById<ImageView>(R.id.childAttrImage)
    val childAttrName = itemView.findViewById<TextView>(R.id.childAttrName)
    val containClick = itemView.findViewById<View>(R.id.containClick)
    val soldOutView = itemView.findViewById<View>(R.id.soldOutView)
  }

  interface AttributeChildListener {
    fun onItemSelected(attr: SelectedAttribute?)
  }
}
package com.luxuanxuan.louboutin.ui.product.information

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.luxuanxuan.louboutin.R
import com.luxuanxuan.louboutin.models.ItemProductInfoDto
import com.luxuanxuan.louboutin.ui.BaseAdapterRecyclerView
import net.cachapa.expandablelayout.ExpandableLayout

class ProductInfoAdapter(val infos: ArrayList<ItemProductInfoDto>?) :
  BaseAdapterRecyclerView<ProductInfoAdapter.ProductInfoViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductInfoViewHolder {
    val view = getView(parent, viewType, R.layout.item_product_info)
    return ProductInfoViewHolder(view)
  }

  override fun onBindViewHolder(holder: ProductInfoViewHolder, position: Int) {
    val info = infos?.get(position)

    holder.expandableContent.setOnExpansionUpdateListener { expansionFraction, state ->
      when(state){
        ExpandableLayout.State.EXPANDING -> {
          holder.title.setCompoundDrawablesWithIntrinsicBounds(
            null,
            null,
            context.resources.getDrawable(R.drawable.ic_arrow_down),
            null
          )
        }
        ExpandableLayout.State.COLLAPSED -> {
          holder.title.setCompoundDrawablesWithIntrinsicBounds(
            null,
            null,
            context.resources.getDrawable(R.drawable.ic_arrow_right),
            null
          )
        }
      }
    }
    holder.title.apply {
      text = info?.title
      setOnClickListener {
        if (holder.expandableContent.isExpanded) {
          holder.expandableContent.collapse()
        } else {
          holder.expandableContent.expand()
        }
      }
    }

    holder.content.text = info?.content
  }

  override fun getItemCount(): Int {
    return getSizeList(infos)
  }

  inner class ProductInfoViewHolder(itemView: View) : BaseHolder(itemView) {
    val title = itemView.findViewById<TextView>(R.id.title)
    val expandableContent = itemView.findViewById<ExpandableLayout>(R.id.expandableContent)
    val content = itemView.findViewById<TextView>(R.id.content)
  }

}
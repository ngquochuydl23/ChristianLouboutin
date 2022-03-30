package com.luxuanxuan.louboutin.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SpacesItemDecoration(val spanCount: Int, val spacing: Int) : RecyclerView.ItemDecoration() {

  override fun getItemOffsets(
    outRect: Rect,
    view: View,
    parent: RecyclerView,
    state: RecyclerView.State
  ) {
    super.getItemOffsets(outRect, view, parent, state)

    val position = parent.getChildAdapterPosition(view)
    val column = position % spanCount

    outRect.left = spacing - column * spacing / spanCount
    outRect.right = (column + 1) * spacing / spanCount

    if (position < spanCount) {
      outRect.top = spacing
    }
    outRect.bottom = spacing
  }
}
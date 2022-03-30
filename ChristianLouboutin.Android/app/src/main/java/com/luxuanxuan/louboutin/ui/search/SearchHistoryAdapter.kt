package com.luxuanxuan.louboutin.ui.search

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.luxuanxuan.louboutin.R
import com.luxuanxuan.louboutin.models.SearchHistoryDto
import com.luxuanxuan.louboutin.ui.BaseAdapterRecyclerView

class SearchHistoryAdapter(val searchHistories: ArrayList<SearchHistoryDto>?, ) :
  BaseAdapterRecyclerView<SearchHistoryAdapter.SearchHistoryViewHolder>() {

  var listener : SearchHistoryClick? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchHistoryViewHolder {
    val view = getView(parent, viewType, R.layout.item_seach_history)
    return SearchHistoryViewHolder(view)
  }

  override fun onBindViewHolder(holder: SearchHistoryViewHolder, position: Int) {
    val searchHistory = searchHistories?.get(position)

    holder.searchHistoryTitle.setText(searchHistory?.title)
    holder.searchHistorySubtitle.setText(searchHistory?.subtitle)

    holder.containClick.setOnClickListener {
      listener?.onClickItem()
    }

    holder.closeButton.setOnClickListener {
      listener?.onRemoveItem(position)
    }
  }

  override fun getItemCount(): Int {
    return getSizeList(searchHistories)
  }

  inner class SearchHistoryViewHolder(itemView: View) : BaseHolder(itemView) {
    val containClick = itemView.findViewById<View>(R.id.containClick)
    val searchHistoryTitle = itemView.findViewById<TextView>(R.id.searchHistoryTitle)
    val searchHistorySubtitle = itemView.findViewById<TextView>(R.id.searchHistorySubtitle)
    val closeButton = itemView.findViewById<View>(R.id.closeButton)
  }

  interface SearchHistoryClick {
    fun onRemoveItem(position: Int)
    fun onClickItem()
  }
}
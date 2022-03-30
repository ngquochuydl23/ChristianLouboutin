package com.luxuanxuan.louboutin.ui.search

import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.luxuanxuan.louboutin.R
import com.luxuanxuan.louboutin.repository.listSearchHistory
import com.luxuanxuan.louboutin.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_enter_seach.*
import kotlinx.android.synthetic.main.fragment_enter_seach.toolbar
import kotlinx.android.synthetic.main.fragment_sign_in.*

class EnterSeachFragment : BaseFragment(), TextView.OnEditorActionListener {

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_enter_seach, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    toolbar.setOnClickListener {
      activity?.onBackPressed()
    }

    enterKeyword.requestFocus()

    searchHistoryRecyclerView.layoutManager = LinearLayoutManager(context)

    val newAdapter = SearchHistoryAdapter(listSearchHistory).apply {
      listener = object : SearchHistoryAdapter.SearchHistoryClick {
        override fun onRemoveItem(position: Int) {}
        override fun onClickItem() {
          navigateToSearchResult()
        }
      }
    }
    searchHistoryRecyclerView.adapter = newAdapter
  }

  override fun onEditorAction(textView: TextView?, actionId: Int, event: KeyEvent?): Boolean {
    if (actionId == EditorInfo.IME_ACTION_SEARCH) {
      navigateToSearchResult()
      return true
    }
    return false
  }

  private fun navigateToSearchResult() {
    enterKeyword.clearFocus()
    addFragmentToStack(SearchResultFragment())
  }
}
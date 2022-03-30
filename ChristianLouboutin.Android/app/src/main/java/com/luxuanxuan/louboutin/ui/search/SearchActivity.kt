package com.luxuanxuan.louboutin.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.luxuanxuan.louboutin.R
import com.luxuanxuan.louboutin.ui.BaseActivity

class SearchActivity : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_search)

    // `EnterSeachFragment()` is a default fragment in `SearchActivity`
    addFragmentToActivity(EnterSeachFragment())
  }
}
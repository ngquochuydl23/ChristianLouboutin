package com.luxuanxuan.louboutin.ui

import android.app.Activity
import android.content.Intent
import android.view.View
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.google.android.material.appbar.AppBarLayout
import com.luxuanxuan.louboutin.R
import com.luxuanxuan.louboutin.component.toolbar.LouboutinToolbar

abstract class BaseActivity : AppCompatActivity(), LouboutinToolbar.LouboutinToolbarListener {

  fun navigateTo(activity: Class<*>) {
    val intent = Intent(this, activity)
    startActivity(intent)
  }

  fun navigateTo(activity: Class<*>, allowFinish: Boolean = false) {
    val intent = Intent(this, activity)
    startActivity(intent)

    if (allowFinish) {
      finish()
    }
  }

  fun addFragmentToActivity(fragment: Fragment) {
    supportFragmentManager.commit {
      add(R.id.fragmentContainer, fragment)
      show(fragment)
    }
  }

  fun addFragmentWithBackStack(
    @IdRes fragmentContainer: Int,
    fragment: Fragment,
    tag: String? = null
  ) {
    supportFragmentManager.commit {
      add(fragmentContainer, fragment)
      addToBackStack(tag ?: fragment.tag)
    }
  }

  fun getLouboutinToolbar() {
    LouboutinToolbar().apply {
      activity = this@BaseActivity
      setToolbarListener(this@BaseActivity)
      setupToolBarActivity()
    }
  }

  override fun onNavigationClick() {
    finish()
  }

  open fun collapsingToolbarLayout(title: String?) {
    val collapseTitle = findViewById<TextView>(R.id.collapseTitle)
    val toolbar = findViewById<Toolbar>(R.id.toolbar)
    val appBarLayout = findViewById<AppBarLayout>(R.id.appBarLayout)

    toolbar.setNavigationOnClickListener {
      finish()
    }

    collapseTitle.visibility = View.GONE
    collapseTitle.text = title

    appBarLayout.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
      var scrollRange = -1
      var isShow = false
      override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
        if (scrollRange == -1)
          scrollRange = appBarLayout?.totalScrollRange!!
        if (verticalOffset + scrollRange == 0) {
          isShow = true
          collapseTitle.visibility = View.VISIBLE
        } else if (isShow) {
          isShow = false
          collapseTitle.visibility = View.GONE
        }
      }
    })
  }
}
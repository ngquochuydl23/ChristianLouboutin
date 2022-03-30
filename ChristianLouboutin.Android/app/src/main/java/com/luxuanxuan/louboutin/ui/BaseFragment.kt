package com.luxuanxuan.louboutin.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commit
import com.luxuanxuan.louboutin.R
import com.luxuanxuan.louboutin.component.toolbar.LouboutinToolbar

abstract class BaseFragment : Fragment(), LouboutinToolbar.LouboutinToolbarListener {

  protected lateinit var currentActivity : FragmentActivity

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    currentActivity = requireActivity()
  }

  @SuppressLint("CommitTransaction")
  fun addFragmentToStack(fragment: Fragment) {
    addFragmentToStack(fragment, null)
  }

  fun addFragmentToStack(fragment: Fragment, tag : String?) {
    if (!fragment.isAdded) {
      fragmentManager?.commit {
        add(R.id.childFragmentContainer, fragment)
        addToBackStack(tag ?: fragment.tag)
      }
    }
  }

  fun navigateTo(activity: Class<*>){
    val intent = Intent(context,activity)
    startActivity(intent)
  }

  open fun onBackPressed() { }



  fun getLouboutinToolbar() {
    LouboutinToolbar().apply {
      activity = currentActivity
      setToolbarListener(this@BaseFragment)
      setupToolBarActivity()
    }
  }

  override fun onNavigationClick() {
    currentActivity.onBackPressed()
  }
}
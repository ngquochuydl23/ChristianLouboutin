package com.luxuanxuan.louboutin.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

abstract class BasePagerAdapter : PagerAdapter() {

  lateinit var context: Context

  fun getView(container: ViewGroup, layout : Int) : ViewGroup {
    context = container.context
    val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    return inflater.inflate(layout, container, false) as ViewGroup
  }

  fun navigateTo(activity: Class<*>) {
    val intent = Intent(context, activity)
    context.startActivity(intent)
  }
}
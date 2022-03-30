package com.luxuanxuan.louboutin.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView
import com.luxuanxuan.louboutin.R

abstract class BaseAdapterRecyclerView<T : RecyclerView.ViewHolder?> : RecyclerView.Adapter<T>() {

  lateinit var context: Context
  val EmptyList: Int = 0

  open fun getView(parent: ViewGroup, viewType: Int, layout: Int): View {
    context = parent.context
    return LayoutInflater.from(context).inflate(layout, parent, false)
  }

  fun <Model> getSizeList(list: ArrayList<Model>?): Int {
    if (!list.isNullOrEmpty())
      return list.size
    return EmptyList
  }

  fun <Model> removeItemAt(list: ArrayList<Model>?, position: Int) {
    list?.removeAt(position)
    notifyDataSetChanged()
  }

  fun <Model> addNewItem(list: ArrayList<Model>?, newItem: Model) {
    list?.add(newItem)
    notifyDataSetChanged()
  }

  fun navigateTo(activity: Class<*>) {
    val intent = Intent(context, activity)
    context.startActivity(intent)
  }

  abstract class BaseHolder(itemView: View) : RecyclerView.ViewHolder(itemView) { }
}
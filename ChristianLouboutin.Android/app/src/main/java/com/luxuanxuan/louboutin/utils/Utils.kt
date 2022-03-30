package com.luxuanxuan.louboutin.utils

import android.content.Context

class Util {
  companion object {
    fun Dp2px(context: Context, dp: Float) : Int{
      val scale = context.resources.displayMetrics.density
      return (dp * scale + 0.5f).toInt()
    }
  }
}
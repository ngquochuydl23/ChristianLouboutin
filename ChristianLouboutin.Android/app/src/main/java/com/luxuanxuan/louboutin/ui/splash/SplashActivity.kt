package com.luxuanxuan.louboutin.ui.splash

import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.luxuanxuan.louboutin.R
import com.luxuanxuan.louboutin.sharedreferences.SaveTokenSharedPreferences
import com.luxuanxuan.louboutin.ui.BaseActivity
import com.luxuanxuan.louboutin.ui.home.HomeActivity
import com.luxuanxuan.louboutin.ui.welcome.WelcomeActivity

class SplashActivity : BaseActivity() {

  private val DELAY_MILLIS : Long = 2500

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_splash)

    initView()
  }

  private fun initView(){
    setupWindow()
    val handler = Handler()
    handler.postDelayed(delayInMinutes, DELAY_MILLIS)
  }

  private fun setupWindow(){
    window.setFlags(
      WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
      WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
  }

  private val delayInMinutes = Runnable{
    val token = SaveTokenSharedPreferences(this).getData()

    // Get token from device
    // If token is null or empty then navigate to Login screen
    // Else navigate to Home Screen
    if(token.isNullOrEmpty()) {
      navigateTo(WelcomeActivity::class.java, allowFinish = true)
    }
    else navigateTo(HomeActivity::class.java, allowFinish = true)
  }
}
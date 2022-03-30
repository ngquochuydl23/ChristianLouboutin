package com.luxuanxuan.louboutin.ui.welcome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luxuanxuan.louboutin.R
import com.luxuanxuan.louboutin.ui.BaseActivity
import com.luxuanxuan.louboutin.ui.authenticate.AuthActivity
import com.luxuanxuan.louboutin.ui.home.HomeActivity
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_welcome)

    getStartedButton.setOnClickListener {
      navigateTo(HomeActivity::class.java)
    }

    loginOrRegisterButton.setOnClickListener {
      navigateTo(AuthActivity::class.java)
    }
  }
}
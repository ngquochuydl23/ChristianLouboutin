package com.luxuanxuan.louboutin.ui.authenticate

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.luxuanxuan.louboutin.R
import com.luxuanxuan.louboutin.ui.BaseActivity

class AuthActivity : BaseActivity() {

  private val signInFragment = SignInFragment()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_auth)

    // `SignInFragment()` is a default fragment in `AuthActivity`
    addFragmentToActivity(signInFragment)
  }
}
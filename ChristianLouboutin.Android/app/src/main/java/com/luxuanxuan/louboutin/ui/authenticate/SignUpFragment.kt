package com.luxuanxuan.louboutin.ui.authenticate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.luxuanxuan.louboutin.R
import com.luxuanxuan.louboutin.ui.BaseFragment
import com.luxuanxuan.louboutin.ui.home.HomeActivity
import kotlinx.android.synthetic.main.fragment_forgot_password.*
import kotlinx.android.synthetic.main.fragment_sign_up.*
import kotlinx.android.synthetic.main.fragment_sign_up.nextButton
import kotlinx.android.synthetic.main.fragment_sign_up.toolbar


class SignUpFragment : BaseFragment() {

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_sign_up, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)


    toolbar.setOnClickListener {
      activity?.onBackPressed()
    }

    nextButton.setOnClickListener {
      navigateTo(HomeActivity::class.java)
    }
  }
}
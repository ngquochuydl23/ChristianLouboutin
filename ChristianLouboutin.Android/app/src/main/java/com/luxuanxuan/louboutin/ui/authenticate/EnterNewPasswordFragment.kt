package com.luxuanxuan.louboutin.ui.authenticate

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.luxuanxuan.louboutin.R
import com.luxuanxuan.louboutin.ui.BaseFragment
import com.luxuanxuan.louboutin.ui.home.HomeActivity

import kotlinx.android.synthetic.main.fragment_enter_new_password.*
import kotlinx.android.synthetic.main.fragment_enter_new_password.nextButton
import kotlinx.android.synthetic.main.fragment_enter_new_password.toolbar
import kotlinx.android.synthetic.main.fragment_forgot_password.*


class EnterNewPasswordFragment : BaseFragment() {

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_enter_new_password, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    toolbar.setOnClickListener {
      activity?.onBackPressed()
    }
    nextButton.setOnClickListener {
      resetPasswordAction()
    }

  }

  private fun resetPasswordAction() {
    val newPassword = enterNewPassword.text.toString()
    val confirmNewPassword = enterAgainNewPassword.text.toString()

    navigateToHomeScreen()
  }

  private fun navigateToHomeScreen(){
    val intent = Intent(context, HomeActivity::class.java)
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    startActivity(intent)
    requireActivity().finish()
  }
}

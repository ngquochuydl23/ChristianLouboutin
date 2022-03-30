package com.luxuanxuan.louboutin.ui.authenticate

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.luxuanxuan.louboutin.R
import com.luxuanxuan.louboutin.ui.BaseFragment
import com.luxuanxuan.louboutin.ui.home.HomeActivity
import kotlinx.android.synthetic.main.fragment_forgot_password.*
import kotlinx.android.synthetic.main.fragment_sign_in.*
import kotlinx.android.synthetic.main.fragment_sign_in.toolbar


class SignInFragment : BaseFragment() {

  private val signUpFragment = SignUpFragment()
  private val forgotPassword = ForgotPasswordFragment()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_sign_in, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initialView()
  }

  private fun initialView() {
    toolbar.setOnClickListener {
      activity?.onBackPressed()
    }

    loginButton.setOnClickListener {
      signInAction()
    }

    createAnAccountClick.setOnClickListener {
      addFragmentToStack(signUpFragment)
    }

    forgotPasswordClick.setOnClickListener {
      addFragmentToStack(forgotPassword)
    }
  }

  private fun navigateToHomeScreen() {
    val intent = Intent(context, HomeActivity::class.java)
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    startActivity(intent)
    currentActivity.finish()
  }

  private fun signInAction() {
//    val email = enterEmail.text.toString()
//    val password = enterPassword.text.toString()

    navigateToHomeScreen()
  }
}

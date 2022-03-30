package com.luxuanxuan.louboutin.ui.authenticate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.luxuanxuan.louboutin.R
import com.luxuanxuan.louboutin.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_forgot_password.*


class ForgotPasswordFragment : BaseFragment() {

  private val confirmPasswordFragment = VerificationFragment()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_forgot_password, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    toolbar.setOnClickListener {
      activity?.onBackPressed()
    }

    nextButton.setOnClickListener {
      sendEmailToServer()
    }
  }

  private fun sendEmailToServer(){
    val email = enterEmailOrPhoneNumber.text.toString()
    addFragmentToStack(confirmPasswordFragment)
  }
}

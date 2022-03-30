package com.luxuanxuan.louboutin.ui.checkout

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.luxuanxuan.louboutin.R
import com.luxuanxuan.louboutin.models.ItemAddressDto
import com.luxuanxuan.louboutin.repository.ordersCheckout
import com.luxuanxuan.louboutin.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_checkout.*
import net.cachapa.expandablelayout.ExpandableLayout

class CheckoutActivity : BaseActivity() {

  var fullNameTextView: TextView? = null
  var addressTextView: TextView? = null
  var phonenumberTextView: TextView? = null
  var containClick: View? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_checkout)

    initView()
  }

  private fun initView() {
    getLouboutinToolbar()

    fullNameTextView = currentAddressView.findViewById(R.id.fullNameTextView)
    addressTextView = currentAddressView.findViewById(R.id.addressTextView)
    phonenumberTextView = currentAddressView.findViewById(R.id.phonenumberTextView)

    orderCheckoutRecyclerView.layoutManager = LinearLayoutManager(this)
    orderCheckoutRecyclerView.adapter = OrderCheckoutAdapter(ordersCheckout)

    currentAddressView.setOnClickListener {
      Intent(this, ChooseAddressActivity::class.java).let {
        startActivityForResult(it, ChooseAddressActivity.LAUNCH_CHOOSE_ADDRESS_ACTIVITY)
      }
    }
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if (requestCode == ChooseAddressActivity.LAUNCH_CHOOSE_ADDRESS_ACTIVITY
      && resultCode == Activity.RESULT_OK
    ) {
      val addressSelected =
        data?.getParcelableExtra<ItemAddressDto>(ChooseAddressActivity.CHOOSE_ADDRESS_RESULT)

      fullNameTextView?.text = addressSelected?.fullName
      addressTextView?.text = addressSelected?.address
      phonenumberTextView?.text = addressSelected?.phoneNumber
    }
  }
}
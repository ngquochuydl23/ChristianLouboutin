package com.luxuanxuan.louboutin.ui.checkout

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.luxuanxuan.louboutin.R
import com.luxuanxuan.louboutin.models.ItemAddressDto
import com.luxuanxuan.louboutin.repository.addresses
import com.luxuanxuan.louboutin.ui.BaseActivity
import com.luxuanxuan.louboutin.ui.settings.address.AddressAdapter
import kotlinx.android.synthetic.main.activity_choose_address.*

class ChooseAddressActivity : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_choose_address)

    initView()
  }

  private fun initView(){
    getLouboutinToolbar()

    addressRecyclerView.layoutManager = LinearLayoutManager(this)
    addressRecyclerView.adapter = AddressAdapter(addresses, true).apply {
      setListener(object : AddressAdapter.AddressAdapterListener {
        override fun onClickItem(address: ItemAddressDto) {
          Intent().let {

            it.putExtra(CHOOSE_ADDRESS_RESULT, address)
            setResult(Activity.RESULT_OK, it)
            finish()
          }
        }
      })
    }
  }

  companion object {
    val LAUNCH_CHOOSE_ADDRESS_ACTIVITY = 1
    val CHOOSE_ADDRESS_RESULT = "CHOOSE_ADDRESS_RESULT"
  }
}
package com.luxuanxuan.louboutin.ui.settings.address

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.luxuanxuan.louboutin.R
import com.luxuanxuan.louboutin.models.ItemAddressDto
import com.luxuanxuan.louboutin.ui.BaseAdapterRecyclerView

class AddressAdapter(val addresses: ArrayList<ItemAddressDto>?, val isChoose: Boolean = false) :
  BaseAdapterRecyclerView<AddressAdapter.AddressViewHolder>() {

  private var listener: AddressAdapterListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressViewHolder {
    val view = getView(parent, viewType, R.layout.item_address)
    return AddressViewHolder(view)
  }

  override fun onBindViewHolder(holder: AddressViewHolder, position: Int) {
    val address = addresses?.get(position)

    holder.fullNameTextView.text = address?.fullName
    holder.phonenumberTextView.text = address?.phoneNumber
    holder.addressTextView.text = address?.address

    holder.containClick.setOnClickListener {
      if (isChoose) {
        listener?.onClickItem(address!!)
      }
    }
  }

  override fun getItemCount(): Int {
    return getSizeList(addresses)
  }

  inner class AddressViewHolder(val itemView: View) : BaseHolder(itemView) {
    val fullNameTextView = itemView.findViewById<TextView>(R.id.fullNameTextView)
    val addressTextView = itemView.findViewById<TextView>(R.id.addressTextView)
    val phonenumberTextView = itemView.findViewById<TextView>(R.id.phonenumberTextView)
    val containClick = itemView.findViewById<View>(R.id.containClick)
  }

  interface AddressAdapterListener {
    fun onClickItem(address: ItemAddressDto)
  }

  fun setListener(listener: AddressAdapterListener) {
    this.listener = listener
  }
}
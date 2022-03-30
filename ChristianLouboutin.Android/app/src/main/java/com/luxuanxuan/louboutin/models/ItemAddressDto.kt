package com.luxuanxuan.louboutin.models

import android.os.Parcel
import android.os.Parcelable

class ItemAddressDto() : Parcelable{
  var id : Int? = 0
  var fullName : String? = null
  var phoneNumber : String? = null
  var address : String? = null
  var isDefault : Boolean? = null

  constructor(parcel: Parcel) : this() {
    id = parcel.readValue(Int::class.java.classLoader) as? Int
    fullName = parcel.readString()
    phoneNumber = parcel.readString()
    address = parcel.readString()
    isDefault = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
  }

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeValue(id)
    parcel.writeString(fullName)
    parcel.writeString(phoneNumber)
    parcel.writeString(address)
    parcel.writeValue(isDefault)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Parcelable.Creator<ItemAddressDto> {
    override fun createFromParcel(parcel: Parcel): ItemAddressDto {
      return ItemAddressDto(parcel)
    }

    override fun newArray(size: Int): Array<ItemAddressDto?> {
      return arrayOfNulls(size)
    }
  }
}
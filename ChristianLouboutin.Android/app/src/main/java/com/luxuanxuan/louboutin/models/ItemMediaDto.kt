package com.luxuanxuan.louboutin.models

import android.os.Parcel
import android.os.Parcelable

class ItemMediaDto() : Parcelable{
  var id : Int? = null
  var url : String? = null
  var type : String? = null

  constructor(parcel: Parcel) : this() {
    id = parcel.readValue(Int::class.java.classLoader) as? Int
    url = parcel.readString()
    type = parcel.readString()
  }

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeValue(id)
    parcel.writeString(url)
    parcel.writeString(type)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Parcelable.Creator<ItemMediaDto> {
    override fun createFromParcel(parcel: Parcel): ItemMediaDto {
      return ItemMediaDto(parcel)
    }

    override fun newArray(size: Int): Array<ItemMediaDto?> {
      return arrayOfNulls(size)
    }
  }
}
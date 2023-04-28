package com.example.hi3861app

import android.os.Parcel
import android.os.Parcelable

class IpPortInfo() : Parcelable {
    var ip : String? = "192.168.1.1"
    var port : Int  = 0

    constructor(parcel: Parcel) : this() {
        ip = parcel.readString()
        port = parcel.readInt()
    }

    constructor(ip: String,port : Int) : this() {
        this.ip = ip
        this.port = port
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(ip)
        parcel.writeInt(port)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<IpPortInfo> {
        override fun createFromParcel(parcel: Parcel): IpPortInfo {
            return IpPortInfo(parcel)
        }

        override fun newArray(size: Int): Array<IpPortInfo?> {
            return arrayOfNulls(size)
        }
    }
}
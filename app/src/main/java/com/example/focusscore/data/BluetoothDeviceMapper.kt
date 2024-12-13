package com.example.focusscore.data

import android.annotation.SuppressLint
import android.bluetooth.BluetoothDevice
import com.example.focusscore.domain.BtDevice

@SuppressLint("MissingPermission")
fun BluetoothDevice.toBtDevice(): BtDevice {
    return BtDevice(
        name = name,
        address = address
    )
}
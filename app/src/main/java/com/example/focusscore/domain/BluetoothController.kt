package com.example.focusscore.domain

import kotlinx.coroutines.flow.StateFlow

interface BluetoothController {
    val scannedDevices: StateFlow<List<BtDevice>>
    val pairedDevices: StateFlow<List<BtDevice>>

    fun startDiscovery()
    fun stopDiscovery()

    fun release()

}
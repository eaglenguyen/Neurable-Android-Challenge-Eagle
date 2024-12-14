package com.example.focusscore.presentation.bluetooth

import com.example.focusscore.domain.BtDevice

data class BlueToothUiState(
    val scannedDevices: List<BtDevice> = emptyList(),
    val pairedDevices: List<BtDevice> = emptyList(),
    val isLoading: Boolean = false,
    val connected: Boolean = false,
)

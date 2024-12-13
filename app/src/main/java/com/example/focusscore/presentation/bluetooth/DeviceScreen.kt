package com.example.focusscore.presentation.bluetooth

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.focusscore.data.bluetooth.BluetoothHandler
import com.example.focusscore.domain.BtDevice

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeviceScreen(
    onStartScan: () -> Unit,
    onStopScan: () -> Unit,
    onGoBack: () -> Unit,
    viewModel: BluetoothViewModel = hiltViewModel()
    ) {

    val context = LocalContext.current
    val state by viewModel.state.collectAsState()

    BluetoothHandler()

    if (state.isLoading) {
        Toast.makeText(context, "Connecting...", Toast.LENGTH_LONG).show()
    }
    if (state.connected) {
        Toast.makeText(context, "Connection Successful", Toast.LENGTH_LONG).show()
    }

    Scaffold(
        modifier = Modifier,
        topBar = {
            CenterAlignedTopAppBar(
                title = { },
                navigationIcon = {
                    IconButton(onGoBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                BluetoothDeviceList(
                    pairedDevices = state.pairedDevices,
                    scannedDevices = state.scannedDevices,
                    onClick = { viewModel.connectToDevice() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Button(onClick = onStartScan) {
                        Text(text = "Start Scan")
                    }
                    Button(onClick = onStopScan) {
                        Text(text = "Stop Scan")
                    }
                }
            }
        }
    )

}




@Composable
fun BluetoothDeviceList(
    pairedDevices: List<BtDevice>,
    scannedDevices: List<BtDevice>,
    onClick: (BtDevice) -> Unit,
    modifier: Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        item {
            Text(
                text = "Paired Devices",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier.padding(16.dp)
            )
        }
        items(pairedDevices) { device ->
            Text(
                text = device.name?: "(no name)",
                modifier = Modifier.fillMaxWidth()
                    .clickable{ onClick(device)}
                    .padding(16.dp)
            )
        }

        item {
            Text(
                text = "Scanned Devices",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier.padding(16.dp)
            )
        }
        items(scannedDevices) { device ->
            Text(
                text = device.name?: "(no name)",
                modifier = Modifier.fillMaxWidth()
                    .clickable{ onClick(device)}
                    .padding(16.dp)
            )
        }
    }
}
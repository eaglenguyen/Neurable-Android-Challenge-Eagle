package com.example.focusscore.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.focusscore.presentation.focus.FocusScoreScreen
import com.example.focusscore.presentation.bluetooth.BluetoothViewModel
import com.example.focusscore.presentation.focus.FocusScoreViewModel
import com.example.focusscore.presentation.bluetooth.DeviceScreen

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),
    btViewModel: BluetoothViewModel = hiltViewModel(),
    focusViewModel: FocusScoreViewModel = hiltViewModel()
    ){


    // val state by viewModel.state.collectAsState()


    NavHost(navController = navController, startDestination = FocusScoreScreen) {
        composable<FocusScoreScreen> {
            FocusScoreScreen(viewModel = focusViewModel,
                onBluetoothScreen = { navController.navigate(BlueToothScreen) }
            )
        }

        composable<BlueToothScreen> {
            DeviceScreen(
                onStartScan = { btViewModel.startScan() },
                onStopScan = { btViewModel.stopScan() },
                onGoBack = { navController.navigateUp() }
            )
        }
    }
}
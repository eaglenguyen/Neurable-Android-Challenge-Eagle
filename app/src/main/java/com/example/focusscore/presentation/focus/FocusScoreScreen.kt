package com.example.focusscore.presentation.focus

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun FocusScoreScreen(
    onBluetoothScreen: () -> Unit,
    viewModel: FocusScoreViewModel = hiltViewModel()
) {

    val state by viewModel.state.collectAsState()


    // Display the current focus score
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Focus Points",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier
                .size(120.dp)
                .background(color = Color.Blue, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "${state.focusScore}",
                fontSize = 50.sp,
                color = Color.White,
                style = MaterialTheme.typography.headlineMedium,
                fontFamily = FontFamily.SansSerif
            )
        }

        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "${state.focusScore}% of your daily goal"
        )
        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            ) {
            Button(
                onClick = {
                viewModel.focusScoreRandomized()
            }
            ) {
                if (state.startAndStop) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "Stop"
                    )
                    Text(
                        text = "Stop"
                    )
                } else {
                    Text(
                        text = "Start"
                    )
                }


        }

            Button(onClick = { viewModel.resetScore() }) {
                Text(
                    text = "Reset",

                )
            }
        }
        Spacer(modifier = Modifier.height(24.dp))

        Button(onBluetoothScreen) {
            Text(
                text = "Bluetooth"
            )
        }

    }
}

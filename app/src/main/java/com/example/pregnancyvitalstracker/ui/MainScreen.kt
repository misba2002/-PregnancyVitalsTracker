package com.example.pregnancyvitalstracker.ui

import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pregnancyvitalstracker.model.Vitals
import com.example.pregnancyvitalstracker.viewmodel.VitalsViewModel
import com.example.pregnancyvitalstracker.viewmodel.VitalsViewModelFactory

@Composable
fun MainScreen() {
    val context = LocalContext.current.applicationContext as Application
    val viewModel: VitalsViewModel = viewModel(factory = VitalsViewModelFactory(context))

    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Pregnancy Vitals Tracker") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { showDialog = true }) {
                Icon(Icons.Filled.Add, contentDescription = "Add Vitals")
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            val vitalsList by viewModel.vitalsList.collectAsState()

            if (vitalsList.isEmpty()) {
                Text("No vitals recorded yet.", style = MaterialTheme.typography.body1)
            } else {
                LazyColumn {
                    items(vitalsList) { vitals ->
                        VitalsCard(vitals = vitals)
                    }
                }
            }

            if (showDialog) {
                AddVitalsDialog(
                    onDismiss = { showDialog = false },
                    onSubmit = { vitals: Vitals ->
                        viewModel.insertVitals(vitals)
                        showDialog = false
                    }
                )
            }
        }
    }
}

package com.example.pregnancyvitalstracker.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.pregnancyvitalstracker.model.Vitals

@Composable
fun AddVitalsDialog(
    onDismiss: () -> Unit,
    onSubmit: (Vitals) -> Unit
) {
    var heartRate by remember { mutableStateOf("") }
    var bpSys by remember { mutableStateOf("") }
    var bpDia by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var kicks by remember { mutableStateOf("") }

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = MaterialTheme.shapes.medium,
            color = MaterialTheme.colors.surface,
            elevation = 8.dp,
            modifier = Modifier.padding(16.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Enter Vitals", style = MaterialTheme.typography.h6)

                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = heartRate,
                    onValueChange = { heartRate = it },
                    label = { Text("Heart Rate (bpm)") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = bpSys,
                    onValueChange = { bpSys = it },
                    label = { Text("Systolic BP") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = bpDia,
                    onValueChange = { bpDia = it },
                    label = { Text("Diastolic BP") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = weight,
                    onValueChange = { weight = it },
                    label = { Text("Weight (kg)") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = kicks,
                    onValueChange = { kicks = it },
                    label = { Text("Baby Kicks") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    TextButton(onClick = onDismiss) {
                        Text("Cancel")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = {
                            // Basic validation
                            if (
                                heartRate.isNotBlank() && bpSys.isNotBlank() && bpDia.isNotBlank() &&
                                weight.isNotBlank() && kicks.isNotBlank()
                            ) {
                                onSubmit(
                                    Vitals(
                                        heartRate = heartRate.toIntOrNull() ?: 0,
                                        bpSys = bpSys.toIntOrNull() ?: 0,
                                        bpDia = bpDia.toIntOrNull() ?: 0,
                                        weight = weight.toFloatOrNull() ?: 0f,
                                        kicks = kicks.toIntOrNull() ?: 0
                                    )
                                )
                            }
                        }
                    ) {
                        Text("Submit")
                    }
                }
            }
        }
    }
}

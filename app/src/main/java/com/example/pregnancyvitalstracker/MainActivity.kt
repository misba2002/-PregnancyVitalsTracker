package com.example.pregnancyvitalstracker

import com.example.pregnancyvitalstracker.data.WorkScheduler

import android.Manifest
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.ActivityResultLauncher
import com.example.pregnancyvitalstracker.ui.MainScreen
import com.example.pregnancyvitalstracker.ui.theme.PregnancyVitalsTrackerTheme



class MainActivity : ComponentActivity() {

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        // Optional: handle if permission was granted or denied
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 🔐 Request POST_NOTIFICATIONS permission on Android 13+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
        }
        setContent {
            PregnancyVitalsTrackerTheme {
                MainScreen() //This shows your vitals tracker screen
            }
        }


        WorkScheduler.scheduleReminder(applicationContext)

    }
}

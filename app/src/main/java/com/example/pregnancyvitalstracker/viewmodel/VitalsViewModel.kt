package com.example.pregnancyvitalstracker.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.pregnancyvitalstracker.data.VitalsDatabase
import com.example.pregnancyvitalstracker.model.Vitals
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class VitalsViewModel(application: Application) : AndroidViewModel(application) {

    private val dao = VitalsDatabase.getDatabase(application).vitalsDao()

    // Live vitals list using StateFlow
    val vitalsList: StateFlow<List<Vitals>> = dao.getAllVitals()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // Insert new vitals
    fun insertVitals(vitals: Vitals) {
        viewModelScope.launch {
            dao.insertVitals(vitals)
        }
    }
}

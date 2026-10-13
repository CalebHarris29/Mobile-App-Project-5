package com.example.project5.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.project5.data.AppDatabase
import com.example.project5.data.WaterLog
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class WaterViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = AppDatabase.getDatabase(application).waterDao()

    val allLogs: StateFlow<List<WaterLog>> = dao.getAllLogs()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun addLog(amountMl: Int, notes: String) {
        viewModelScope.launch {
            dao.insertLog(WaterLog(amountMl = amountMl, notes = notes))
        }
    }

    fun deleteLog(log: WaterLog) {
        viewModelScope.launch {
            dao.deleteLog(log)
        }
    }
}

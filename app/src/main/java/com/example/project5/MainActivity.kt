package com.example.project5

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project5.ui.WaterAdapter
import com.example.project5.ui.WaterViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val viewModel: WaterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etAmount = findViewById<EditText>(R.id.etAmount)
        val etNotes = findViewById<EditText>(R.id.etNotes)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val tvTotal = findViewById<TextView>(R.id.tvTotal)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val adapter = WaterAdapter { log ->
            viewModel.deleteLog(log)
            Toast.makeText(this, "Entry deleted", Toast.LENGTH_SHORT).show()
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        btnAdd.setOnClickListener {
            val amountStr = etAmount.text.toString().trim()
            val notesStr = etNotes.text.toString().trim()

            if (amountStr.isEmpty()) {
                etAmount.error = "Please enter amount"
                return@setOnClickListener
            }

            val amount = amountStr.toIntOrNull()
            if (amount == null || amount <= 0) {
                etAmount.error = "Please enter a valid amount"
                return@setOnClickListener
            }

            viewModel.addLog(amount, notesStr)
            etAmount.text?.clear()
            etNotes.text?.clear()
            Toast.makeText(this, "Water logged!", Toast.LENGTH_SHORT).show()
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.allLogs.collect { logs ->
                    adapter.submitList(logs)
                    val total = logs.sumOf { it.amountMl }
                    tvTotal.text = "Total Water Logged: $total ml"
                }
            }
        }
    }
}

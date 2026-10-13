package com.example.project5.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.project5.R
import com.example.project5.data.WaterLog
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class WaterAdapter(private val onDeleteClick: (WaterLog) -> Unit) :
    ListAdapter<WaterLog, WaterAdapter.WaterViewHolder>(WaterDiffCallback()) {

    class WaterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvAmount: TextView = itemView.findViewById(R.id.tvAmount)
        val tvDate: TextView = itemView.findViewById(R.id.tvDate)
        val tvNotes: TextView = itemView.findViewById(R.id.tvNotes)
        val btnDelete: Button = itemView.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WaterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_water_log, parent, false)
        return WaterViewHolder(view)
    }

    override fun onBindViewHolder(holder: WaterViewHolder, position: Int) {
        val log = getItem(position)
        holder.tvAmount.text = "${log.amountMl} ml"
        val sdf = SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.getDefault())
        holder.tvDate.text = sdf.format(Date(log.timestamp))
        if (log.notes.isNotBlank()) {
            holder.tvNotes.visibility = View.VISIBLE
            holder.tvNotes.text = log.notes
        } else {
            holder.tvNotes.visibility = View.GONE
        }
        holder.btnDelete.setOnClickListener {
            onDeleteClick(log)
        }
    }

    class WaterDiffCallback : DiffUtil.ItemCallback<WaterLog>() {
        override fun areItemsTheSame(oldItem: WaterLog, newItem: WaterLog): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: WaterLog, newItem: WaterLog): Boolean {
            return oldItem == newItem
        }
    }
}

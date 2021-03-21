package com.example.tp_homework

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class NumberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val title: TextView = itemView.findViewById<TextView>(com.example.tp_homework.R.id.title)

    fun bind(number: Int) {
        title.text = number.toString()
        title.setTextColor(if (number % 2 == 0) Color.RED else Color.BLUE)
    }

}
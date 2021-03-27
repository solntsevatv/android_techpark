package com.example.tp_homework

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NumberAdapter : RecyclerView.Adapter<NumberAdapter.NumberViewHolder>() {
    private var numbers: List<Int> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.number_item, parent, false)
        return NumberViewHolder(view)
    }

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        val num: Int = numbers[position]
        holder.bind(num)
    }

    override fun getItemCount(): Int {
       return numbers.size
    }

    fun updateNumbers(numbers: List<Int>) {
        this.numbers = numbers
    }

    class NumberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(com.example.tp_homework.R.id.title)

        fun bind(number: Int) {
            title.text = number.toString()
            title.setTextColor(if (number % 2 == 0) Color.RED else Color.BLUE)
        }

    }
}

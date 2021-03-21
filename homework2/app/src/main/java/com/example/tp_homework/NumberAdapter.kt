package com.example.tp_homework

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class NumberAdapter : RecyclerView.Adapter<NumberViewHolder>() {
    private var numbers: List<Int> = emptyList()
    private var itemListener: View.OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.number_item, parent, false)

//        val tV = view.findViewById<TextView>(R.id.title)
//        tV.setOnClickListener(itemListener)

        return NumberViewHolder(view)
    }

//    override fun getItemCount(): Int {
//        return data?.size
//    }


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

    fun NumberAdapter(itemListener: View.OnClickListener) {
        this.itemListener = itemListener
    }
}

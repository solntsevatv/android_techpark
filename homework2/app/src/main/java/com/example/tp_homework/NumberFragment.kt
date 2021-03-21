package com.example.tp_homework


import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment


class NumberFragment : Fragment(com.example.tp_homework.R.layout.number_fragment) {
    private val STATE: String = "state"
    var number = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            number = savedInstanceState.getInt(STATE)

        }
        val textView: TextView = view.findViewById(com.example.tp_homework.R.id.textViewNumItem)
        textView.text = number.toString()
        textView.setTextColor(if (number % 2 == 0) Color.RED else Color.BLUE)
    }

    fun setDisplayNumber(number: Int) {
        this.number = number
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(STATE, number)
    }
}
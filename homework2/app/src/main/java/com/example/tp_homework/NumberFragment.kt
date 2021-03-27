package com.example.tp_homework

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class NumberFragment : Fragment(R.layout.number_fragment) {
    companion object {
        private const val NUMBER_STATE: String = "state"
    }

    private var displayNumber: Int = 0
    fun setDisplayNumber(num: Int) {
        this.displayNumber = num
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            displayNumber = savedInstanceState.getInt(NUMBER_STATE)

        }
        val textView: TextView = view.findViewById(R.id.textViewNumItem)
        textView.text = displayNumber.toString()
        textView.setTextColor(if (displayNumber % 2 == 0) Color.RED else Color.BLUE)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(NUMBER_STATE, displayNumber)
    }
}
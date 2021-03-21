package com.example.tp_homework

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class NumberListFragment() : Fragment(com.example.tp_homework.R.layout.number_list_fragment) {
    private val ARRAY_STATE: String = "state"
    private var numbers: ArrayList<Int> = ArrayList()
    private val spanNumber: Int
        get() {
            return if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
                3
            else
                4
        }

    var numberAdapter: NumberAdapter = NumberAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            numbers = savedInstanceState.getIntegerArrayList(ARRAY_STATE) as ArrayList<Int>
        }
            val recyclerView = view.findViewById<RecyclerView>(com.example.tp_homework.R.id.numbers_list)
            recyclerView.layoutManager = GridLayoutManager(this.context, spanNumber)
            recyclerView.setItemViewCacheSize(20)
            recyclerView.adapter = numberAdapter

            initNumbers(if (numbers.size == 0) 100 else numbers.size)
            fillNumberList(numbers)


            val fab = view.findViewById<FloatingActionButton>(com.example.tp_homework.R.id.fab)
            fab.setOnClickListener {
                addNumber()
            }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putIntegerArrayList(ARRAY_STATE, numbers)
    }

    private fun fillNumberList(numbers: List<Int>) {
        numberAdapter.updateNumbers(numbers)
        numberAdapter.notifyDataSetChanged() // bad for now
    }

    private fun initNumbers(count: Int) {
        numbers.clear()
        for (i in 1..count) numbers.add(i)
    }

    fun addNumber() {
        numbers.add(numbers.size + 1)
        fillNumberList(numbers)
    }

    init {
        numberAdapter = NumberAdapter()
    }
}


package com.example.tp_homework

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NumberListFragment : Fragment(R.layout.number_list_fragment) {
    companion object {
        private const val ARRAY_SIZE_STATE: String = "state"
    }
    private var numbers: ArrayList<Int> = ArrayList(110)
    private var numberAdapter: NumberAdapter = NumberAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            initNumbers(savedInstanceState.getInt(ARRAY_SIZE_STATE))
        }
        else initNumbers(if (numbers.size == 0) 100 else numbers.size)

        view.findViewById<RecyclerView>(R.id.numbers_list).let {
            it.layoutManager = GridLayoutManager(this.context, resources.getInteger(R.integer.span_number))
            it.setItemViewCacheSize(20)
            it.adapter = numberAdapter
        }

        fillNumberList(numbers)

        val fab = view.findViewById<FloatingActionButton>(com.example.tp_homework.R.id.fab)
        fab.setOnClickListener {
            addNumber()
        }
    }

    private fun initNumbers(count: Int) {
        numbers.clear()
        for (i in 1..count) numbers.add(i)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(ARRAY_SIZE_STATE, numbers.size)
    }

    private fun fillNumberList(numbers: List<Int>) {
        numberAdapter.updateNumbers(numbers)
        numberAdapter.notifyDataSetChanged()
    }

    private fun addNumber() {
        numbers.add(numbers.size + 1)
        fillNumberList(numbers)
    }
}


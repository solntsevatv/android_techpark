package com.example.tp_homework

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var listFragment: NumberListFragment = NumberListFragment()
    var numberFragment: NumberFragment = NumberFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportFragmentManager.findFragmentById(R.id.numbers_list) == null && savedInstanceState == null) {
            Log.d("HEY", "null")
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_container, listFragment, null)
                    .commit()
        }
    }

    fun onNumberClick(view: View) {
        val textView = view as TextView
        val num: Int = textView.text.toString().toInt()
        numberFragment.setDisplayNumber(num)
        supportFragmentManager
                .beginTransaction()
                .remove(listFragment)
                .add(R.id.fragment_container, numberFragment, "numberFragment")
                .addToBackStack(null)
                .commit()
    }
}
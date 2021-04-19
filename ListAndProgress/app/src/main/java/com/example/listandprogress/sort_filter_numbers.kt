package com.example.listandprogress

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.sort_filter_numbers.*
import kotlin.random.Random

class sort_filter_numbers : AppCompatActivity() {

    private val unsorted = List(100) { Random.nextInt(0, 1000) };
    private val sorted  = unsorted.sorted();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sort_filter_numbers)

        var data = ArrayAdapter(this,android.R.layout.simple_list_item_1,unsorted)

        list_random_numbers.adapter = data;

        btn_sort_view_back.setOnClickListener {
            finish()
        }
        btn_sort_view_sort.setOnClickListener{
            list_random_numbers.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, sorted)
        }
        btn_sort_view_unsorted.setOnClickListener{
            list_random_numbers.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, unsorted)
        }



    }
}
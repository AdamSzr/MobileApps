package com.example.listandprogress

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.lazy_loading.*
import kotlin.random.Random

class lazy_loading: AppCompatActivity()  {

    var adapter = MyAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lazy_loading)
        addDataSet()
        initRecView()

        btn_lazy_back.setOnClickListener {
            finish()
        }
    }
    private  fun    addDataSet()
    {
        val unsorted = List(100) { Random.nextInt(97, 122) };
        val char_array  =  unsorted.map { it.toChar() }
        adapter.submitList(char_array)
    }


    private fun initRecView()
    {
        lazy_recic_view.apply {
            layoutManager = LinearLayoutManager(this@lazy_loading)
            adapter = this@lazy_loading.adapter
            addItemDecoration(CardSpacing(30))
        }
    }
}
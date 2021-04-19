package com.example.listandprogress

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_a1_list.setOnClickListener {
            var list_activity = Intent(this,sort_filter_numbers::class.java)
            startActivity(list_activity)
        }

        btn_a1_lazy.setOnClickListener {
            var lazy_activity = Intent(this,lazy_loading::class.java)
            startActivity(lazy_activity)
        }

        btn_a1_step.setOnClickListener {
            var stepProgress = Intent(this,step_one::class.java)
            startActivity(stepProgress)
        }
    }
}
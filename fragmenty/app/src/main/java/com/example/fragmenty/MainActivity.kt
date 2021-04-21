package com.example.fragmenty

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fragment_login = Intent(this,fragment_reg::class.java )
        var fragment_nested = Intent(this,Nested::class.java)

        btn_main_reg.setOnClickListener {
            startActivity(fragment_login)
        }
        btn_main_nested.setOnClickListener {
            startActivity(fragment_nested)
        }
    }
}
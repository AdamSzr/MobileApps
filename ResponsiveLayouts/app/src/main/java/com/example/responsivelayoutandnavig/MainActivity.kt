package com.example.responsivelayoutandnavig

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_a1_login.setOnClickListener{
            Intent(this,SecoundActivity::class.java).also {
                startActivity(it)
            }
        }
        btn_a1_reg.setOnClickListener{
            Intent(this,ThirdActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}
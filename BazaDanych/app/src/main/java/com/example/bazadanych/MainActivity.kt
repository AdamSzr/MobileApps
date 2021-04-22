package com.example.bazadanych

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var user_manager_intent = Intent(this,user_activity::class.java)

        main_btn_to_users.setOnClickListener {
            startActivity(user_manager_intent)
        }

    }
}
package com.example.responsivelayoutandnavig

import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.secound_activity.*

class SecoundActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.secound_activity)

        btn_a2_back.setOnClickListener{
            finish()
        }

        btn_a2_login.setOnClickListener {
           var end = Intent(this,ExitActivity::class.java)
            end.putExtra("Login",login_input.text.toString())
            end.putExtra("Password",password_input.text.toString())
            end.putExtra("isLogin","true")
            startActivity(end)
        }

    }
}
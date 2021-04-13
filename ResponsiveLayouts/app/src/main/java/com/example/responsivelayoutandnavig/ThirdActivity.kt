package com.example.responsivelayoutandnavig

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.third_activity.*

class ThirdActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.third_activity)

        btn_a3_back.setOnClickListener{
            finish()
        }
        btn_a3_reg.setOnClickListener {
            var end = Intent(this,ExitActivity::class.java)
            end.putExtra("Name",input_name.text.toString())
            end.putExtra("Surname",input_surname.text.toString())
            end.putExtra("Email",input_email.text.toString())
            end.putExtra("Password",input_passw.text.toString())
            startActivity(end)
        }
    }
}
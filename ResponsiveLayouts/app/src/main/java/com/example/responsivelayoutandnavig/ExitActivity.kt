package com.example.responsivelayoutandnavig

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.end_activity.*
import kotlinx.android.synthetic.main.third_activity.*
import kotlin.system.exitProcess

class ExitActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.end_activity)
        var data = intent

        if (data.getStringExtra("isLogin") == "true")
        {
            var login = data.getStringExtra("Login")
            var passw = data.getStringExtra("Password")
            end_text.text = "Login: ".plus(login).plus("\nPassword:").plus(passw)
        }
        else
        {
           var name = data.getStringExtra("Name")
           var sur = data.getStringExtra("Surname")
           var email = data.getStringExtra("Email")
           var passw = data.getStringExtra("Password")
           end_text.text = "Name: ".plus(name).plus("\nSurname: ")
                   .plus(sur).plus("\nE-mail: ").plus(email)
                   .plus("\nPassword: ").plus(passw)
        }


        btn_exit.setOnClickListener {
            finish()
            System.exit(0)
        }
    }
}
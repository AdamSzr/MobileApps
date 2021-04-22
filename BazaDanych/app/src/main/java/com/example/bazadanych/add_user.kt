package com.example.bazadanych

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import kotlin.math.log

class add_user : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)

        var text_input_name =  findViewById<TextInputEditText>(R.id.add_user_name_input)
        var text_input_surname =  findViewById<TextInputEditText>(R.id.add_user_surname_input)
        var text_input_age =  findViewById<TextInputEditText>(R.id.add_user_age_input)

        var button_submit =  findViewById<Button>(R.id.add_user_btn_submit)

        button_submit.setOnClickListener {
            var person = PersonModel(
                    text_input_name.text.toString(),
                    text_input_surname.text.toString(),
                    text_input_age.text.toString().toInt(),
            )
            var db = DataBaseHandler(this)
            db.insertUser(person)
            finish()
        }


    }
}
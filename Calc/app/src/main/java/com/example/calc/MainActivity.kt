package com.example.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberEvent(view: View) {
        var editText =  findViewById<EditText>(R.id.editText)
        var button_select = view as Button;
        var boardNewText =  editText.text.toString().plus(button_select.text);
        editText.setText( boardNewText )
    }
}
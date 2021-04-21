package com.example.fragmenty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class Nested : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nested)

        Log.i("tutaj jestem","message")
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.nested_fr,nested_1())
            commit()
        }
    }
}
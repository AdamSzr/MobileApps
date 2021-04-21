package com.example.fragmenty

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_activiy.*
import kotlinx.android.synthetic.main.fragment_fragment1.*

class fragment_reg: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_activiy)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_layout,fragment1())
            commit()
        }

    }

}
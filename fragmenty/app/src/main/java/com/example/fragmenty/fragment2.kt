package com.example.fragmenty

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_fragment2.*


class fragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      var v =  inflater.inflate(R.layout.fragment_fragment2, container, false)
       var tv = v.findViewById<TextView>(R.id.f2_tv)
        var b = this.arguments
        var name = b?.getString("name")
        var surname = b?.getString("surname")
        var str ="Name: $name, Surname: $surname"
        tv.text = str
        return v

    }

}
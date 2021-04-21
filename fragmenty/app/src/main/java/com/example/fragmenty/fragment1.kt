package com.example.fragmenty

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_activiy.*
import kotlinx.android.synthetic.main.fragment_fragment1.*

class fragment1 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var v =  inflater.inflate(R.layout.fragment_fragment1, container, false)
        var btn = v.findViewById<Button>(R.id.f1_btn_submit)

        btn.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("name",f1_ti_name.text.toString())
            bundle.putString("surname",f1_ti_surname.text.toString())
            var fragment_2 = fragment2()
            fragment_2.arguments = bundle
            fragmentManager?.beginTransaction()?.replace(R.id.fragment_layout,fragment_2 )?.commit()

        }
        //f1_btn_submit.text="123"
/*
        f1_btn_submit.setOnClickListener {

            var bundle = Bundle()
            bundle.putString("name",f1_ti_name.text.toString())

            var fragment_2 = fragment2()
            fragment_2.arguments = bundle
            fragmentManager?.beginTransaction()?.replace(R.id.fragment_layout,fragment_2 )?.commit()

        }
 */

        return v

    }


}
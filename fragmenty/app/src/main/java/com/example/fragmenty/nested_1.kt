package com.example.fragmenty

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class nested_1 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       var v =  inflater.inflate(R.layout.fragment_nested_1, container, false)

        fragmentManager?.beginTransaction().apply {
            this?.replace(R.id.nested_fr1_fragment,nested_2())
            this?.commit()
        }

        return v
    }
}
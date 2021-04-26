package com.example.asynctask

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TimingLogger
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        var async = Intent(this,Async::class.java)
        var normal = Intent(this,Normal::class.java)
       // insertDataToDB()

        btn_load_data_normal.setOnClickListener {
            startActivity(normal)
        }

        btn_load_data_async.setOnClickListener {
            startActivity(async)
        }

    }

    fun insertDataToDB()
    {
      var db =  DataBaseHandler(this)
        db.insertUser(PersonModel("Adam","Szreiber",32))
        db.insertUser(PersonModel("Jan","Kowalska",22))
        db.insertUser(PersonModel("Bartek","Mig",52))
        db.insertUser(PersonModel("Olek","Dabek",11))
        db.insertUser(PersonModel("Szymon","Maska",85))
        db.insertUser(PersonModel("Jakub","Roza",98))
        db.insertUser(PersonModel("Danuta","Woda",75))
        db.insertUser(PersonModel("Krzysztof","Broda",44))
        db.insertUser(PersonModel("Alicja","Bilbao",16))
        db.insertUser(PersonModel("Kasia","Olcha",18))
    }

}
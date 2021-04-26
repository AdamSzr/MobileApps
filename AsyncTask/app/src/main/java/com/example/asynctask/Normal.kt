package com.example.asynctask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_normal.*
import kotlin.random.Random

class Normal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal)
       // Log.i("TH Create:", Thread.currentThread().name )
       // normal_progress_bar.setProgress(30)

        normal_load_data_btn.setOnClickListener {
            var db= DataBaseHandler(this)
            var timer = MyTimingLogger("Sync version")

           // normal_progress_bar.setProgress(90)

            timer.addSplit("Sync Solution Start")

            var users =  db.getUsersCursor()
            var data  = ArrayList<PersonModel>()
            val count = users.count*1.0
            var percentage:Int = 0


            if (users.count > 0)
            {
                 do {

                     val user = PersonModel(
                             users.getString(users.getColumnIndex(COLUMN_NAME)),
                             users.getString(users.getColumnIndex(COLUMN_SURNAME)),
                             users.getInt(users.getColumnIndex(COLUMN_AGE)))


                     data.add(user)

                     percentage = ((users.position/count)*100).toInt()
                     normal_progress_bar.setProgress(percentage)


                }while (users.moveToNext())
            }


            var adapter = ArrayAdapter(this,R.layout.activity_list_view_row,data!!.map {
                it.toString()
            })
            normal_list_view.adapter = adapter

            timer.addSplit("Sync solution stop")
            timer.dumpToLog()
        }

    }
  fun publishProgress(value:Int){

    }
}
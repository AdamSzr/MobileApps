package com.example.asynctask

import android.database.Cursor
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_async.*

class Async : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async)

        async_load_data_btn.setOnClickListener {
            var asyncClass = GetDataAsync(this)
            asyncClass.execute(DataBaseHandler(this))
        }

    }



    @Suppress("DEPRECATION")
    internal class GetDataAsync(var arg:AppCompatActivity): AsyncTask<DataBaseHandler, Int, ArrayList<PersonModel>>() {


        lateinit var users :Cursor
        var data  = ArrayList<PersonModel>()
        lateinit var timer:MyTimingLogger


        override fun onPreExecute() {
            timer = MyTimingLogger("Async version")
            timer.addSplit("before onPreExecute")
            super.onPreExecute()
            timer.addSplit("after onPreExecute")
        }

        override fun doInBackground(vararg params: DataBaseHandler?): ArrayList<PersonModel> {
            timer.addSplit("before doInBackground")
            users =  params[0]!!.getUsersCursor()

            val count = users.count*1.0
            if (users.count > 0)
            {
                do {
                    val user = PersonModel(
                            users.getString(users.getColumnIndex(COLUMN_NAME)),
                            users.getString(users.getColumnIndex(COLUMN_SURNAME)),
                            users.getInt(users.getColumnIndex(COLUMN_AGE)))

                    data.add(user)
                    publishProgress(  ((users.position/count)*100).toInt()  )
                }while (users.moveToNext())
            }

            timer.addSplit("after doInBackground")
            return data
        }

        override fun onPostExecute(result: ArrayList<PersonModel>?) {
            timer.addSplit("before onPostExecute")
            super.onPostExecute(result)
            var adapter = ArrayAdapter(arg,R.layout.activity_list_view_row,result!!.map {
                it.toString()
            })
            arg.async_list_view.adapter = adapter

            timer.addSplit("afeter onPostExecute")
            timer.dumpToLog()
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)

            //Log.i("progress -> ",values[0].toString())
            values[0]?.let { arg.async_ProgressBar.setProgress(it) }

        }

    }
}
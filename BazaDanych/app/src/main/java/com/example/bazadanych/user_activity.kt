package com.example.bazadanych

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_user_activity.*

class user_activity : AppCompatActivity() {

    lateinit var users : Cursor
    lateinit var db :DataBaseHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_activity)

        this.db = DataBaseHandler(this)

        this.users = db.getUsersCursor()
        tryToSetView()


        user_view_back.setOnClickListener {
            if(users.moveToPrevious())
                setView(
                    PersonModel(
                        users.getString(users.getColumnIndex(COLUMN_NAME)),
                        users.getString(users.getColumnIndex(COLUMN_SURNAME)),
                        users.getInt(users.getColumnIndex(COLUMN_AGE)),
                    )
                )
        }

        user_view_next.setOnClickListener {
            if(users.moveToNext())
                setView(
                    PersonModel(
                        users.getString(users.getColumnIndex(COLUMN_NAME)),
                        users.getString(users.getColumnIndex(COLUMN_SURNAME)),
                        users.getInt(users.getColumnIndex(COLUMN_AGE)),
                    )
                )
        }

        var addUser_activity = Intent(this,add_user::class.java)
        add_user_btn.setOnClickListener {
            startActivity(addUser_activity)
        }

        user_view_delete.setOnClickListener {
            val userId = users.getInt(users.getColumnIndex(COLUMN_ID))
            this.db.deleteUser(userId)
            users=db.getUsersCursor()
            tryToSetView()
        }


    }

    fun tryToSetView()
    {
        if(users.count<=0)
            Toast.makeText(this,"0 - users yet.",Toast.LENGTH_SHORT).show()
        else
        {
            setView(
                PersonModel(
                    users.getString(users.getColumnIndex(COLUMN_NAME)),
                    users.getString(users.getColumnIndex(COLUMN_SURNAME)),
                    users.getInt(users.getColumnIndex(COLUMN_AGE)),
                )
            )
        }
    }


    override fun onResume() {
        super.onResume()
        this.users = db.getUsersCursor()
        tryToSetView()
    }

    fun setView(arg:PersonModel) {
        display_user_name.text = "Name - "+arg.name
        display_user_surname.text = "Surname - "+arg.surname
        display_user_age.text = "Age - "+arg.age
    }
}
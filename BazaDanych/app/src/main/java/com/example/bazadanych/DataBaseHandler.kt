package com.example.bazadanych

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast


const val DATABASE_NAME = "BD_LAB_6"
const val TABLE_NAME = "Users"

const val COLUMN_ID="id"
const val COLUMN_NAME="name"
const val COLUMN_SURNAME="surname"
const val COLUMN_AGE="age"

class DataBaseHandler(var context:Context):SQLiteOpenHelper(context, DATABASE_NAME,null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        var createTable = "CREATE TABLE $TABLE_NAME " +
                "( $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$COLUMN_NAME  VARCHAR(256)," +
                "$COLUMN_SURNAME  VARCHAR(256)," +
                "$COLUMN_AGE INTEGER )"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun deleteUser(userId:Int)
    {
        var query = "DELETE FROM $TABLE_NAME WHERE $COLUMN_ID=$userId"
        this.writableDatabase.execSQL(query)
    }

   fun insertUser(user:PersonModel){
       var db_writer = this.writableDatabase

       var values = ContentValues()
       values.put(COLUMN_NAME,user.name)
       values.put(COLUMN_SURNAME,user.surname)
       values.put(COLUMN_AGE,user.age)

       var answer = db_writer.insert(TABLE_NAME,null,values)
       if(answer == -1L)
           Toast.makeText(context,"db user insetion failed",Toast.LENGTH_SHORT).show()

       Toast.makeText(context,"db user insertion SUCCESS",Toast.LENGTH_SHORT).show()
    }

    fun getUsersCursor():Cursor {
       // val query = "SELECT * FROM $TABLE_NAME" //var cursor =  db.rawQuery(query,null)
        val db = this.readableDatabase
        var cursor = db.query(TABLE_NAME, arrayOf(COLUMN_ID, COLUMN_NAME, COLUMN_SURNAME, COLUMN_AGE),
            null,null,null,null,null)
        cursor.moveToFirst()
        return cursor
    }

    fun getUsers():ArrayList<PersonModel>{
        val list = ArrayList<PersonModel>()
        val query = "SELECT * FROM $TABLE_NAME"
        val db = this.readableDatabase
        val cursor =  db.rawQuery(query,null)



        if (cursor.moveToFirst())
        {
            do {
                list.add(PersonModel(
                        cursor.getString(cursor.getColumnIndex(COLUMN_NAME)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_SURNAME)),
                        cursor.getInt(cursor.getColumnIndex(COLUMN_AGE)),
                ))
            }while (cursor.moveToNext())

        }

        return list





































    }
}
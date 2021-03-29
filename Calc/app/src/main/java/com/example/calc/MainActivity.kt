package com.example.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.github.keelar.exprk.Expressions

class MainActivity : AppCompatActivity() {
    var mathFormula = "";


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberEvent(view: View) {
        var editText =  findViewById<EditText>(R.id.editText)
        var button_select = view as Button;
        var boardNewText =  editText.text.toString().plus(button_select.text);


        editText.setText( boardNewText )
    }

    fun setBoard(value:String){
        findViewById<EditText>(R.id.editText).setText(value)
    }
    fun clearBoard(view: View) {
        var editText =  findViewById<EditText>(R.id.editText)
        editText.setText("")
    }

    fun flipNumber(view: View) {
        var editText =  findViewById<EditText>(R.id.editText)

        if(editText.text[0] == '-')
            editText.setText(editText.text.substring(1))
        else
            editText.setText("-".plus(editText.text))
    }

    fun saveText(view: View){
        this.mathFormula =  findViewById<EditText>(R.id.editText).text.toString()
    }

    fun plusOperation(view: View) {
        saveText(view)
        setBoard( this.mathFormula.plus('+') )
    }

    fun minusOperation(view: View) {
        saveText(view)
        setBoard( this.mathFormula.plus('-') )
    }

    fun divOperation(view: View) {
        saveText(view)
        setBoard( this.mathFormula.plus('/') )
    }

    fun mulOperation(view: View) {
        saveText(view)
        setBoard( this.mathFormula.plus('*') )
    }

    fun modOperation(view: View) {
        saveText(view)
        setBoard( this.mathFormula.plus('%') )
    }

    fun calculateFormula(view: View) {
        saveText(view)
        setBoard( Expressions() .eval(mathFormula).toString())
        mathFormula=""
    }

    fun dotCharacter(view: View) {
        saveText(view)
        setBoard( this.mathFormula.plus('.') )
    }
}
package com.example.listandprogress

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shuhart.stepview.StepView
import kotlinx.android.synthetic.main.step_one.*

class step_one: AppCompatActivity()  {
    var index = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.step_one)

        step1_stepview.state
            .animationType(StepView.ANIMATION_ALL)
            .stepsNumber(3)
            .animationDuration(resources.getInteger(android.R.integer.config_shortAnimTime))
            .commit();


        var nextActivity =
            Intent(this,step_two::class.java)
                .putExtra("index",index+1);

        btn_step1_back.setOnClickListener {
            finish()
        }
        btn_step1_next.setOnClickListener {
            startActivity(nextActivity)
        }


    }
    /*
    private fun nextStep()
    {
        val hander= Handler()

        hander.postDelayed(Runnable {
            kotlin.run {
                stepindex++
                step1_textview.text = stepindex.toString()
                if(stepindex<4)
                {

                    step1_stepview.go(stepindex,true)
                    nextStep()
                }
            }
        },3000)
    }
    */
}
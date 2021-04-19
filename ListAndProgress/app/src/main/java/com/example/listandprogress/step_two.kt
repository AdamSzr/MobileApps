package com.example.listandprogress

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shuhart.stepview.StepView
import kotlinx.android.synthetic.main.step_one.*
import kotlinx.android.synthetic.main.step_two.*

class step_two: AppCompatActivity()  {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.step_two)
        var index = intent.getIntExtra("index",1);


        step2_stepview.state
            .animationType(StepView.ANIMATION_ALL)
            .stepsNumber(3)
            .animationDuration(resources.getInteger(android.R.integer.config_shortAnimTime))
            .commit();

        step2_stepview.go(index,false)

        btn_step2_back.setOnClickListener { finish() }

        var nextActivity =
            Intent(this,step_three::class.java)
                .putExtra("index",index+1);

        btn_step2_next.setOnClickListener { startActivity(nextActivity) }

    }
}
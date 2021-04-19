package com.example.listandprogress

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shuhart.stepview.StepView
import kotlinx.android.synthetic.main.step_three.*
import kotlinx.android.synthetic.main.step_two.*

class step_three: AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.step_three)

        var index = intent.getIntExtra("index",2);

        step3_stepview.state
            .animationType(StepView.ANIMATION_ALL)
            .stepsNumber(3)
            .animationDuration(resources.getInteger(android.R.integer.config_shortAnimTime))
            .commit();

        step3_stepview.go(index,false)

        btn_step3_back.setOnClickListener { finish() }

        var mainView =
            Intent(this,MainActivity::class.java)

        btn_step3_next.setOnClickListener { startActivity(mainView) }

    }
}
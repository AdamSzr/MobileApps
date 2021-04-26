package com.example.asynctask

import android.util.Log
import java.util.*

class TimerStartStop(var textToDisplay:String) {
    private var startDate: Long = 0
    private var endDate: Long = 0


   public fun start() {
            startDate = System.nanoTime()
    }

    public fun end() {
            endDate = System.nanoTime()
    }

    private fun isTimeInit()
    {
        if (startDate == 0L)
            throw  error("Timer wasnt's started yet")

        if (endDate == 0L)
            throw error("Timer wasnt's ended yet")
    }

    public fun time_elapsed_nano():Long{
        isTimeInit()

        return endDate - startDate
    }
    public fun time_elapsed_ms():Long{
        return time_elapsed_nano()/1_000_000
    }

    public  fun dump()
    {
        Log.i( this.textToDisplay, time_elapsed_ms().toString() +"ms")
    }

    override fun toString(): String {
        return this.textToDisplay + time_elapsed_ms().toString() +"ms"
    }



}
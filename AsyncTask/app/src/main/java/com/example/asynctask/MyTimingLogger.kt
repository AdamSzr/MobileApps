package com.example.asynctask

import android.util.Log

class MyTimingLogger() {
    private var timeLaps: MutableList<TimeLaps> = mutableListOf<TimeLaps>()
    lateinit var label:String
    var lastStop:Long = 0


   public constructor(label:String) : this() {
        lastStop=System.nanoTime()
        this.label = label
    }


    public fun addSplit( splitLabel: String){
        this.timeLaps.add(TimeLaps(getTimeElapsed(),splitLabel))
    }

    public fun dumpToLog()
    {
        Log.i(this.label,"begin\r\n")
        timeLaps.forEach {
            Log.i(this.label,it.toString())
        }
        Log.i(this.label,"end, ${getTotalTimeInMs()} ms")
    }

    public fun getDumpString():String{
        var stringBuilder = StringBuilder()
        stringBuilder.append(getFormatedRow("begin\r\n"))
        timeLaps.forEach {
            stringBuilder.append(it.toString())
        }
        stringBuilder.append(getFormatedRow("end, ${getTotalTimeInMs()} ms"))
        return stringBuilder.toString()
    }

    private  fun  getTotalElapsedTimeInNano():Long
    {
        var totalTime = 0L
        this.timeLaps.forEach {
            totalTime +=it.nanoTime
        }
        return totalTime
    }

    private fun getFormatedRow(textRow:String):String
    {
        return "$label: $textRow"
    }

    private fun convNanoSecToMs(nanoSec:Long):Long
    {
        return nanoSec/1_000_000
    }
    private fun getTotalTimeInMs():Long
    {
        return convNanoSecToMs(getTotalElapsedTimeInNano())
    }

    override fun toString(): String {
        return super.toString()
    }

    public  fun reset(newLabel:String)
    {
        this.label=newLabel
        this.timeLaps = mutableListOf<TimeLaps>()
    }

    private fun getTimeElapsed():Long{
        var now = System.nanoTime()
        var elapsed = now - lastStop
        lastStop = now
        return elapsed
    }


    class TimeLaps(var nanoTime:Long,var description:String){

        private  fun convToMs(nanoTime: Long):Long
        {
            return  nanoTime/1_000_000
        }

        override fun toString(): String {
            return "\t ${convToMs(nanoTime)} ms, $description\r\n"
        }

    }
}
package com.example.asynctask

class PersonModel {
    var id : Int  = 0
    var name: String =""
    var surname: String =""
    var age : Int  = 0

    constructor(name:String,surname:String,age:Int)
    {
        this.name=name
        this.surname=surname
        this.age=age
    }

    override fun toString(): String {
        return "${this.name} - ${this.surname} - ${this.age}"
    }
}
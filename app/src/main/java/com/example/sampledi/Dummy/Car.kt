package com.example.sampledi.Dummy

class Car(engine: Engine) {

    fun showCar() : String {
        return "This is my car"
    }

}

class Engine{
    fun startEngine() : String {
        return "This is my engine"
    }

}
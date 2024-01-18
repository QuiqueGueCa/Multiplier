package com.example.multiplier

data class NumBox(var id: Int = 1) {

    fun establishId(listSize: Int){
        id = listSize
    }

    fun multiplyNumber() : Int {
        id *= 2
        return id
    }
}
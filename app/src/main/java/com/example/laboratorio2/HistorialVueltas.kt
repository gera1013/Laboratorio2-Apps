package com.example.laboratorio2

import android.app.Application

class HistorialVueltas : Application(){

    companion object : LapHistroy{
        override fun add(element: Int) {
            lapHistory.add(element)
        }

        override fun del(elementIndex: Int) {
            lapHistory.removeAt(elementIndex)
        }

        override fun clear() {
            lapHistory.clear()
        }

        override val lapHistory: ArrayList<Int> = ArrayList()
    }


}
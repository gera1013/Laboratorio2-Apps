package com.example.laboratorio2

interface LapHistroy {
    val lapHistory: ArrayList<Int> // Historial de vueltas
    fun clear() // Limpiar historial
    fun add(element: Int) // Agregar elemento
    fun del(elementIndex: Int) // Elimina elemento en la posición
}
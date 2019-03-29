package com.example.laboratorio2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.widget.*

class vueltas : AppCompatActivity() {

    private lateinit var lista : ListView
    private var contadorVueltas = 0


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_vueltas)

        lista = findViewById(R.id.listaVueltas)

        val listaPredefinida = ArrayList<Int>()
        val inicio = findViewById<Button>(R.id.regresarInicio)
        val agregarVueltas = findViewById<Button>(R.id.agregarVueltas)
        val textoContador = findViewById<TextView>(R.id.contadorVueltas)
        val masVueltas = findViewById<Button>(R.id.agregarVuelta)
        val menosVueltas = findViewById<Button>(R.id.quitarVuelta)

        listaPredefinida.add(1)
        listaPredefinida.add(3)
        listaPredefinida.add(5)
        listaPredefinida.add(10)

        val adaptador = MyAdapter(this, listaPredefinida)
        lista.adapter = adaptador

        inicio.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        agregarVueltas.setOnClickListener{
            HistorialVueltas.add(contadorVueltas)
            val mensaje = Toast.makeText(applicationContext, "Se han añadido las vueltas al histrial", Toast.LENGTH_SHORT)
            mensaje.show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        masVueltas.setOnClickListener{
            contadorVueltas += 1
            textoContador.text = Integer.toString(contadorVueltas)
        }

        menosVueltas.setOnClickListener{
            contadorVueltas -= 1
            if (contadorVueltas >= 0) textoContador.text = Integer.toString(contadorVueltas)
            else{
                contadorVueltas = 0
                val mensaje = Toast.makeText(applicationContext, "No se pueden agregar menos de 0 vueltas", Toast.LENGTH_SHORT)
                mensaje.show()
            }
        }

        lista.setOnItemClickListener { _, _, position, _ ->
            val seleccion = listaPredefinida[position]
            contadorVueltas = seleccion
            textoContador.text = Integer.toString(contadorVueltas)
        }
    }
}

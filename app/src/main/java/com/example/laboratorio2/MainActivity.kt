package com.example.laboratorio2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var lista : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lista = findViewById(R.id.listaHistorial)

        val NuevoEntreno = findViewById<Button>(R.id.nuevoEntreno)
        val EliminarHistorial = findViewById<Button>(R.id.historial)

        val adaptador = MyAdapter(this, HistorialVueltas.lapHistory)
        lista.adapter = adaptador

        NuevoEntreno.setOnClickListener{
            val intent = Intent(this, vueltas::class.java)
            startActivity(intent)
        }

        EliminarHistorial.setOnClickListener{
            HistorialVueltas.clear()
            var mensaje = Toast.makeText(applicationContext, "Se eliminó el historial", Toast.LENGTH_SHORT)
            mensaje.show()
            lista.invalidateViews()
        }

        lista.setOnItemLongClickListener { _, _, position, _ ->
            HistorialVueltas.del(position)
            lista.invalidateViews()
            var mensaje = Toast.makeText(applicationContext, "Elemento eliminado del historial", Toast.LENGTH_SHORT)
            mensaje.show()
            true
        }
    }
}

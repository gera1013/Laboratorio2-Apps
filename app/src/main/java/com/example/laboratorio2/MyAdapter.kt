package com.example.laboratorio2

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MyAdapter(private val context: Context, private val dataSource: ArrayList<Int>) : BaseAdapter() {
    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View
    {
        val rowView = inflater.inflate(R.layout.lista_layout, parent, false)
        val nombre = rowView.findViewById(R.id.numeroVuelta) as TextView
        val numero = getItem(position) as Int
        var texto = ""
        if(numero > 1) texto = "$numero vueltas"
        else texto = "$numero vuelta"
        nombre.text = texto

        return rowView
    }

    override fun getItem(position: Int): Any
    {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long
    {
        return position.toLong()
    }

    override fun getCount(): Int
    {
        return dataSource.size
    }
}
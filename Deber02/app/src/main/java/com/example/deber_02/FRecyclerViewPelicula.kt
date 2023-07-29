package com.example.deber_02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

class FRecyclerViewPelicula(): AppCompatActivity() {
    var arreglo = BBaseDatosMemoria.obtenerPeliculas()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frecycler_view_pelicula)
        inicializarRecyclerView()
        val btnSerie = findViewById<Button>(R.id.btn_peliculas)
        btnSerie.setOnClickListener {
            val intent = Intent(this, FRecyclerViewSerie::class.java)
            startActivity(intent)
        }
    }

    fun inicializarRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(
            R.id.rv_serie
        )
        val adaptador = FRecyclerViewAdaptadorPelicula(
            this,
            arreglo
        )
        val m = androidx.recyclerview.widget
            .GridLayoutManager(this,3)
        val decoration = DividerItemDecoration(this, m.orientation)
        recyclerView.adapter = adaptador
        recyclerView.itemAnimator = androidx.recyclerview.widget
            .DefaultItemAnimator()
        recyclerView.layoutManager = m
        recyclerView.addItemDecoration(decoration)
        adaptador.notifyDataSetChanged()
    }
}
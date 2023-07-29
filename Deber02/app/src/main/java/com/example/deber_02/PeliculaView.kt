package com.example.deber_02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.w3c.dom.Text

class PeliculaView : AppCompatActivity() {
    var item = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        item = intent.getIntExtra("posicion",1)
        var pelicula = BBaseDatosMemoria.obtenerPeliculas()[item]
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pelicula_view)
        var img = findViewById<ImageView>(R.id.iv_pel)
        Glide.with(img.context).load(pelicula.getImagen()).into(img)
        var tx_titulo = findViewById<TextView>(R.id.text_titulo_pl)
        tx_titulo.setText("Título: " + pelicula.getTitulo())
        var tx_descripcion = findViewById<TextView>(R.id.text_descripcion_pl)
        tx_descripcion.setText("Descripción: " + pelicula.getDescripcion())
        var tx_duracion = findViewById<TextView>(R.id.text_duracion_pl)
        tx_duracion.setText("Duración: " + pelicula.getDuracion())
        var tx_genero = findViewById<TextView>(R.id.text_genero_pl)
        tx_genero.setText("Género: " + pelicula.getGenero())
    }
}
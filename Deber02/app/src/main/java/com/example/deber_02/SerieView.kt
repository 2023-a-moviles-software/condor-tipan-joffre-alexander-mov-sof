package com.example.deber_02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class SerieView : AppCompatActivity() {
    var item = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        item = intent.getIntExtra("posicion",1)
        var serie = BBaseDatosMemoria.obtenerSeries()[item]
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_serie_view)
        var img = findViewById<ImageView>(R.id.iv_ser)
        Glide.with(img.context).load(serie.getImagen()).into(img)
        var tx_titulo = findViewById<TextView>(R.id.text_titulo_ser)
        tx_titulo.setText("Título: " + serie.getTitulo())
        var tx_descripcion = findViewById<TextView>(R.id.text_descripcion_ser)
        tx_descripcion.setText("Descripción: " + serie.getDescripcion())
        var tx_temporadas = findViewById<TextView>(R.id.text_temporadas_ser)
        tx_temporadas.setText("Número de temporadas: " + serie.getNumeroTemporadas())
        var tx_capitulos = findViewById<TextView>(R.id.text_capitulos_ser)
        tx_capitulos.setText("Número de episodios: " + serie.getNumeroEpisodios())
    }
}
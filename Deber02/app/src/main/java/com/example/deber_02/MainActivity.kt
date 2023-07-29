package com.example.deber_02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnPerfil = findViewById<ImageButton>(R.id.ibtn_usuario)
        btnPerfil.setOnClickListener {
            val intent = Intent(this, FRecyclerViewPelicula::class.java)
            startActivity(intent)
        }
    }

}
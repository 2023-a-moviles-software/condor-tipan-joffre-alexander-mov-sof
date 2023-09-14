package com.example.examenibcrud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Firebase.initialize(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val botonIngresar = findViewById<Button>(R.id.btn_ingresar)
        botonIngresar.setOnClickListener {
            irActividad(ListViewSS::class.java)
        }
    }
    fun irActividad(
        clase:Class<*>
    ){
        val intent = Intent(this,clase)
        startActivity(intent)
    }
}
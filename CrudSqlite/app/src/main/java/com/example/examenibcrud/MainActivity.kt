package com.example.examenibcrud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        EBaseDeDatos.tablaSistema = ESqliteHelperSS(this)
        EBaseDeDatos.tablaPlaneta = ESqliteHelperPl(this)
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
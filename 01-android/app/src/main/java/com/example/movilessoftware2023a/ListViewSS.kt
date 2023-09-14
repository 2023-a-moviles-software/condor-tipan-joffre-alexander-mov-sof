package com.example.examenibcrud

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.movilessoftware2023a.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.Date

class ListViewSS : AppCompatActivity() {
    val arreglo: ArrayList<ISistemaSolar> = arrayListOf()
    var idItemSeleccionado = 0
    private lateinit var adaptor: ArrayAdapter<ISistemaSolar>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_ss)
        val listView = findViewById<ListView>(R.id.lv_sistemas)
        adaptor = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            arreglo
        )
        listView.adapter = adaptor
        adaptor.notifyDataSetChanged()
        registerForContextMenu(listView)
        val botonAnadir = findViewById<Button>(R.id.btn_anadir)
        botonAnadir.setOnClickListener {
            mostrarFormSS()
        }
    }
    fun mostrarFormSS() {
        val db = Firebase.firestore
        val ss = db.collection("sistemas_solares")
        val inflater = LayoutInflater.from(this)
        val formularioView = inflater.inflate(R.layout.form_ss, null)
        val dialogBuilder = MaterialAlertDialogBuilder(this)
            .setView(formularioView)
            .setTitle("Formulario Creación Sistema solar")
            .setPositiveButton("Crear") { _, _ ->
                val nombreSS = formularioView.findViewById<EditText>(R.id.input_n_ss).text.toString()
                val extension = formularioView.findViewById<EditText>(R.id.input_e).text.toString().toDouble()
                val radG = formularioView.findViewById<RadioGroup>(R.id.radioG)
                var estrC = ""
                if(radG.checkedRadioButtonId == R.id.rb_ea){
                    estrC = "G"
                }else if(radG.checkedRadioButtonId == R.id.rb_em){
                    estrC = "O"
                }else if(radG.checkedRadioButtonId == R.id.rb_er){
                    estrC = "M"
                }
                var arrPl = ArrayList<IPlaneta>()
                var numPl = 0
                val data = hashMapOf(
                    "nombre" to nombreSS,
                    "numero_planetas" to numPl,
                    "extension" to extension,
                    "estrella" to estrC,
                )
                ss.document(Date().time.toString()).set(data)
                arreglo.clear()
                adaptor.notifyDataSetChanged()
                Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Cancelar", null)
        dialogBuilder.create().show()
    }

}
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
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ListViewSS : AppCompatActivity() {
    val arreglo = BDDMemoria.getSistemas()
    var idItemSeleccionado = 0
    private lateinit var adaptor: ArrayAdapter<SistemaSolar>
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
        val botonAnadir = findViewById<Button>(R.id.btn_anadir)
        botonAnadir.setOnClickListener {
            mostrarFormSS()
        }
        registerForContextMenu(listView)
    }
    fun mostrarFormSS() {
        val inflater = LayoutInflater.from(this)
        val formularioView = inflater.inflate(R.layout.form_ss, null)
        val dialogBuilder = MaterialAlertDialogBuilder(this)
            .setView(formularioView)
            .setTitle("Formulario Creación Sistema solar")
            .setPositiveButton("Crear") { _, _ ->
                val nombreSS = formularioView.findViewById<EditText>(R.id.input_n_ss).text.toString()
                val extension = formularioView.findViewById<EditText>(R.id.input_e).text.toString().toDouble()
                val radG = formularioView.findViewById<RadioGroup>(R.id.radioG)
                var estrC = ' '
                if(radG.checkedRadioButtonId == R.id.rb_ea){
                    estrC = 'G'
                }else if(radG.checkedRadioButtonId == R.id.rb_em){
                    estrC = 'O'
                }else if(radG.checkedRadioButtonId == R.id.rb_er){
                    estrC = 'M'
                }
                var arrPl = ArrayList<Planeta>()
                BDDMemoria.createSistemaSolar(nombreSS,0,arrPl,extension,estrC)
                Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT).show()
                adaptor.notifyDataSetChanged()
            }
            .setNegativeButton("Cancelar", null)
        dialogBuilder.create().show()
    }
    fun mostrarFormSSA() {
        val inflater = LayoutInflater.from(this)
        val formularioView = inflater.inflate(R.layout.form_ss, null)
        val s = BDDMemoria.getSistema(idItemSeleccionado)
        val nombreSS = s?.getNombre()
        val extension = s?.getExtension().toString()
        val rB = s?.getEstrellaCentral()
        val i_n = formularioView.findViewById<EditText>(R.id.input_n_ss)
        i_n.setText(nombreSS)
        val i_e = formularioView.findViewById<EditText>(R.id.input_e)
        i_e.setText(extension)
        val rbEa = formularioView.findViewById<RadioButton>(R.id.rb_ea)
        val rbEm = formularioView.findViewById<RadioButton>(R.id.rb_em)
        val rbEr = formularioView.findViewById<RadioButton>(R.id.rb_er)
        if(rB == 'G'){
            rbEa.isChecked = true
        }else if(rB == 'O'){
            rbEm.isChecked = true
        }else if(rB == 'M'){
            rbEr.isChecked = true
        }
        val dialogBuilder = MaterialAlertDialogBuilder(this)
            .setView(formularioView)
            .setTitle("Formulario Actualización Sistema solar")
            .setPositiveButton("Actualizar") { _, _ ->

                val radG = formularioView.findViewById<RadioGroup>(R.id.radioG)
                BDDMemoria.updateNombreSS(idItemSeleccionado,i_n.text.toString())
                BDDMemoria.updateExtensionSS(idItemSeleccionado,i_e.text.toString().toDouble())
                var estrC = ' '
                if(radG.checkedRadioButtonId == R.id.rb_ea){
                    estrC = 'G'
                }else if(radG.checkedRadioButtonId == R.id.rb_em){
                    estrC = 'O'
                }else if(radG.checkedRadioButtonId == R.id.rb_er){
                    estrC = 'M'
                }
                BDDMemoria.updateEstrellaCSS(idItemSeleccionado, estrC)
                Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT).show()
                adaptor.notifyDataSetChanged()
            }
            .setNegativeButton("Cancelar", null)
        dialogBuilder.create().show()
    }
    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.mi_editar ->{
                mostrarFormSSA()
                return true
            }
            R.id.mi_eliminar ->{
                abrirDialogo()
                return true
            }
            R.id.mi_ver_pl ->{
                val intent = Intent(this, ListViewPl::class.java)
                intent.putExtra("idItem", idItemSeleccionado)
                startActivity(intent)
                return true
            }
            else -> super.onContextItemSelected(item)
        }
    }

    override fun onRestart() {
        super.onRestart()
        adaptor.notifyDataSetChanged()
    }
    fun abrirDialogo(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Desea eliminar?")
        builder.setPositiveButton("Aceptar",
            DialogInterface.OnClickListener{
                dialog, which -> BDDMemoria.deleteSistemaSolar(idItemSeleccionado)
                adaptor.notifyDataSetChanged()
            }
        )
        builder.setNegativeButton("Cancelar", null)
        val dialogo = builder.create()
        dialogo.show()
    }
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_ss, menu)
        val info = menuInfo as AdapterView.AdapterContextMenuInfo
        val id = info.position
        idItemSeleccionado = id
    }
}
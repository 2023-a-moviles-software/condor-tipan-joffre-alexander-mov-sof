package com.example.examenibcrud

import android.content.DialogInterface
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
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ListViewPl : AppCompatActivity() {
    var idItem = 0
    var arreglo:ArrayList<Planeta> = arrayListOf<Planeta>()
    var idItemSeleccionado = 0
    private lateinit var adaptor1: ArrayAdapter<Planeta>
    override fun onCreate(savedInstanceState: Bundle?) {
        idItem = intent.getIntExtra("idItem",1)
        arreglo = EBaseDeDatos.tablaPlaneta!!.mostrarPlanetasSS(idItem)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_pl)
        val listView = findViewById<ListView>(R.id.lv_pl)
        adaptor1 = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            arreglo
            )
        listView.adapter = adaptor1
        adaptor1.notifyDataSetChanged()
        val etiqueta = findViewById<TextView>(R.id.tv_ss)
        etiqueta.setText(EBaseDeDatos.tablaSistema!!.consultarSSPorID(idItem).getNombre())
        val botonAnadir = findViewById<Button>(R.id.btn_anadir_pl)
        botonAnadir.setOnClickListener {
            mostrarFormPl()
        }
        registerForContextMenu(listView)
    }
    fun mostrarFormPl() {
        val inflater = LayoutInflater.from(this)
        val formularioView = inflater.inflate(R.layout.form_pl, null)
        val dialogBuilder = MaterialAlertDialogBuilder(this)
            .setView(formularioView)
            .setTitle("Formulario Creación Planeta")
            .setPositiveButton("Crear") { _, _ ->
                val nombrePl = formularioView.findViewById<EditText>(R.id.input_n_pl).text.toString()
                val numL = formularioView.findViewById<EditText>(R.id.input_num_l).text.toString().toInt()
                val diametro = formularioView.findViewById<EditText>(R.id.input_d).text.toString().toDouble()
                val radGT = formularioView.findViewById<RadioGroup>(R.id.rg_tv)
                val radGCl = formularioView.findViewById<RadioGroup>(R.id.rg_cl)
                var tv = 0
                if(radGT.checkedRadioButtonId == R.id.rb_s){
                    tv = 1
                }else if(radGT.checkedRadioButtonId == R.id.rb_n) {
                    tv = 0
                }
                var cl = " "
                if(radGCl.checkedRadioButtonId == R.id.rb_pr){
                    cl = "T"
                }else if(radGCl.checkedRadioButtonId == R.id.rb_pg) {
                    cl = "G"
                }else if(radGCl.checkedRadioButtonId == R.id.rb_ph) {
                    cl = "H"
                }
                EBaseDeDatos.tablaPlaneta!!.crearPlaneta(idItem,nombrePl,numL,diametro,tv,cl)
                var sis = EBaseDeDatos.tablaSistema!!.consultarSSPorID(idItem)
                EBaseDeDatos.tablaSistema!!.actualizarSS(idItem,sis.getNombre(),(sis.getNumeroPlanetas() + 1),sis.getExtension(),sis.getEstrellaCentral())
                Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT).show()
                arreglo.clear()
                arreglo.addAll(EBaseDeDatos.tablaPlaneta!!.mostrarPlanetasSS(idItem))
                adaptor1.notifyDataSetChanged()
            }
            .setNegativeButton("Cancelar", null)
        dialogBuilder.create().show()
    }
    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.mi_editar_pl ->{
                mostrarFormPlA()
                return true
            }
            R.id.mi_eliminar_pl ->{
                abrirDialogo()
                return true
            }
            else -> super.onContextItemSelected(item)
        }
    }
    fun abrirDialogo(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Desea eliminar?")
        builder.setPositiveButton("Aceptar",
            DialogInterface.OnClickListener{
                    dialog, which -> EBaseDeDatos.tablaPlaneta!!.eliminarPlaneta(idItemSeleccionado)
                var sis = EBaseDeDatos.tablaSistema!!.consultarSSPorID(idItem)
                EBaseDeDatos.tablaSistema!!.actualizarSS(idItem,sis.getNombre(),sis.getNumeroPlanetas() - 1,sis.getExtension(),sis.getEstrellaCentral())
                arreglo.clear()
                arreglo.addAll(EBaseDeDatos.tablaPlaneta!!.mostrarPlanetasSS(idItem))
                adaptor1.notifyDataSetChanged()
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
        inflater.inflate(R.menu.menu_pl, menu)
        val info = menuInfo as AdapterView.AdapterContextMenuInfo
        val id = arreglo[info.position].getId()
        idItemSeleccionado = id
    }
    fun mostrarFormPlA() {
        val inflater = LayoutInflater.from(this)
        val formularioView = inflater.inflate(R.layout.form_pl, null)
        val p = EBaseDeDatos.tablaPlaneta!!.consultarPlanetaPorID(idItemSeleccionado)
        val nombrePl = p?.getNombre()
        val numL = p?.getNumeroLunas().toString()
        val diametro = p?.getDiametro().toString()
        val tvA = p?.getHabitado()
        val rB = p?.getClasificacion()
        val i_n = formularioView.findViewById<EditText>(R.id.input_n_pl)
        i_n.setText(nombrePl)
        val i_nl = formularioView.findViewById<EditText>(R.id.input_num_l)
        i_nl.setText(numL)
        val i_d = formularioView.findViewById<EditText>(R.id.input_d)
        i_d.setText(diametro)
        val rbS = formularioView.findViewById<RadioButton>(R.id.rb_s)
        val rbN = formularioView.findViewById<RadioButton>(R.id.rb_n)
        val rbPr = formularioView.findViewById<RadioButton>(R.id.rb_pr)
        val rbPg = formularioView.findViewById<RadioButton>(R.id.rb_pg)
        val rbPh = formularioView.findViewById<RadioButton>(R.id.rb_ph)
        if(tvA == 1){
            rbS.isChecked = true
        }else if(tvA == 0){
            rbN.isChecked = true
        }
        if(rB == "T"){
            rbPr.isChecked = true
        }else if(rB == "G"){
            rbPg.isChecked = true
        }else if(rB == "H"){
            rbPh.isChecked = true
        }
        val dialogBuilder = MaterialAlertDialogBuilder(this)
            .setView(formularioView)
            .setTitle("Formulario Actualización Sistema solar")
            .setPositiveButton("Actualizar") { _, _ ->
                val radGT = formularioView.findViewById<RadioGroup>(R.id.rg_tv)
                val radGCl = formularioView.findViewById<RadioGroup>(R.id.rg_cl)
                var tvN = false
                if(radGT.checkedRadioButtonId == R.id.rb_s){
                    tvN = true
                }else if(radGT.checkedRadioButtonId == R.id.rb_n) {
                    tvN = false
                }
                var cl = ""
                if(radGCl.checkedRadioButtonId == R.id.rb_pr){
                    cl = "T"
                }else if(radGCl.checkedRadioButtonId == R.id.rb_pg) {
                    cl = "G"
                }else if(radGCl.checkedRadioButtonId == R.id.rb_ph) {
                    cl = "H"
                }
                EBaseDeDatos.tablaPlaneta!!.actualizarPlaneta(idItemSeleccionado,i_n.text.toString(),i_nl.text.toString().toInt(), i_d.text.toString().toDouble(),tvN,cl)
                Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT).show()
                arreglo.clear()
                arreglo.addAll(EBaseDeDatos.tablaPlaneta!!.mostrarPlanetasSS(idItem))
                adaptor1.notifyDataSetChanged()
            }
            .setNegativeButton("Cancelar", null)
        dialogBuilder.create().show()
    }

    override fun onResume() {
        super.onResume()
        arreglo.clear()
        arreglo.addAll(EBaseDeDatos.tablaPlaneta!!.mostrarPlanetasSS(idItem))
        adaptor1.notifyDataSetChanged()
    }

    override fun onRestart() {
        super.onRestart()
        arreglo.clear()
        arreglo.addAll(EBaseDeDatos.tablaPlaneta!!.mostrarPlanetasSS(idItem))
        adaptor1.notifyDataSetChanged()
    }
}
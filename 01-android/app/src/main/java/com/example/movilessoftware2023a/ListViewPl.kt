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
import com.example.movilessoftware2023a.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.Date

class ListViewPl : AppCompatActivity() {
    var idItem = ""
    var arreglo:ArrayList<IPlaneta> = arrayListOf<IPlaneta>()
    var ss1 = obtenerSS1()
    var idItemSeleccionado = 0
    private lateinit var adaptor1: ArrayAdapter<IPlaneta>
    override fun onCreate(savedInstanceState: Bundle?) {
        idItem = intent.getStringExtra("idItem").toString()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_pl)
        obtenerPls()
        val listView = findViewById<ListView>(R.id.lv_pl)
        adaptor1 = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            arreglo
        )
        listView.adapter = adaptor1
        adaptor1.notifyDataSetChanged()
        val etiqueta = findViewById<TextView>(R.id.tv_ss)
        etiqueta.setText(intent.getStringExtra("nombreSS").toString())
        val botonAnadir = findViewById<Button>(R.id.btn_anadir_pl)
        botonAnadir.setOnClickListener {
            mostrarFormPl()
        }
        registerForContextMenu(listView)
    }

    fun obtenerSS1(): ISistemaSolar? {
        val db = Firebase.firestore
        var sS: ISistemaSolar? = null
        val ss = db.collection("sistemas_solares")
            .document(idItem)
            .get()
            .addOnSuccessListener {
                sS = ISistemaSolar(
                    it.id as String?,
                    it.data?.get("nombre") as String?,
                    it.data?.get("numero_planetas") as Int?,
                    it.data?.get("extension") as Double?,
                    it.data?.get("estrella") as String?,
                )
            }
        return sS
    }
    fun obtenerPls(){
        val db = Firebase.firestore
        val pls = db.collection("sistemas_solares")
            .document(idItem)
            .collection("planetas")
            .get()
            .addOnSuccessListener{
                for (planeta in it){
                    planeta.id
                    agregarAArreglo(planeta)
                }
            }
    }
    fun agregarAArreglo(planeta: QueryDocumentSnapshot){
        val nuevoPl = IPlaneta(
            planeta.id as String?,
            planeta.data.get("nombre") as String?,
            planeta.data.get("numero_lunas") as Int?,
            planeta.data.get("habitado") as Boolean?,
            planeta.data.get("diametro") as Double?,
            planeta.data.get("clasificacion") as String?,
        )
        arreglo.add(nuevoPl)
    }
    fun limpiarArreglo(){
        arreglo.clear()
    }
    fun mostrarFormPl() {
        val db = Firebase.firestore
        val pls = db.collection("sistemas_solares").document(idItem).collection("planetas")
        //val pls = ss1.getPlanetas()
        limpiarArreglo()
        adaptor1.notifyDataSetChanged()
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
                var tv = false
                if(radGT.checkedRadioButtonId == R.id.rb_s){
                    tv = true
                }else if(radGT.checkedRadioButtonId == R.id.rb_n) {
                    tv = false
                }
                var cl = " "
                if(radGCl.checkedRadioButtonId == R.id.rb_pr){
                    cl = "T"
                }else if(radGCl.checkedRadioButtonId == R.id.rb_pg) {
                    cl = "G"
                }else if(radGCl.checkedRadioButtonId == R.id.rb_ph) {
                    cl = "H"
                }
                val data = hashMapOf(
                    "nombre" to nombrePl,
                    "numero_lunas" to numL,
                    "habitado" to tv,
                    "diametro" to diametro,
                    "clasificacion" to cl,
                )
                pls.document(Date().time.toString()).set(data)
                ss1?.setNumeroPlanetas(ss1!!.getNumeroPlanetas()!! + 1)
                actualizarSS()
                Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT).show()
                arreglo.clear()
                obtenerPls()
                adaptor1.notifyDataSetChanged()
            }
            .setNegativeButton("Cancelar", null)
        dialogBuilder.create().show()
    }
    fun actualizarSS(){
        val db = Firebase.firestore
        val ss = db.collection("sistemas_solares")
        val data = hashMapOf(
            "nombre" to ss1?.getNombre(),
            "numero_planetas" to ss1?.getNumeroPlanetas(),
            "extension" to ss1?.getExtension(),
            "estrella" to ss1?.getEstrellaCentral(),
        )
        if(ss1?.getId() != null){
            ss.document(ss1!!.getId()!!).set(data)
        }
    }
    fun mostrarFormPlA() {
        val db = Firebase.firestore
        val pls = db.collection("sistemas_solares").document(idItem).collection("planetas")
        val p = arreglo[idItemSeleccionado]
        val inflater = LayoutInflater.from(this)
        val formularioView = inflater.inflate(R.layout.form_pl, null)
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
        if(tvA == true){
            rbS.isChecked = true
        }else if(tvA == false){
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
                val data = hashMapOf(
                    "nombre" to i_n.text.toString(),
                    "numero_lunas" to i_nl.text.toString().toInt(),
                    "habitado" to tvN,
                    "diametro" to i_d.text.toString().toDouble(),
                    "clasificacion" to cl,
                )
                if(p.getId() != null) {
                    pls.document(p.getId()!!).set(data)
                }
                Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT).show()
                arreglo.clear()
                obtenerPls()
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
                    dialog, which ->
                val db = Firebase.firestore
                val referenciaPls = db.collection("sistemas_solares").document(idItem).collection("planetas")
                arreglo[idItemSeleccionado].getId()?.let {
                    referenciaPls
                        .document(it)
                        .delete()
                        .addOnSuccessListener {  }
                        .addOnFailureListener {  }
                }
                ss1?.setNumeroPlanetas(ss1!!.getNumeroPlanetas()!! - 1)
                actualizarSS()
                arreglo.clear()
                obtenerPls()
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
        idItemSeleccionado = info.position
    }


    override fun onResume() {
        super.onResume()
        arreglo.clear()
        obtenerPls()
        adaptor1.notifyDataSetChanged()
    }

    override fun onRestart() {
        super.onRestart()
        arreglo.clear()
        obtenerPls()
        adaptor1.notifyDataSetChanged()
    }
}
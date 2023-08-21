package com.example.examenibcrud

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ESqliteHelperPl (contexto: Context?): SQLiteOpenHelper(contexto,"planeta",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val scriptSQLCrearTablaPl =
            """
                CREATE TABLE PLANETA(
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nombre VARCHAR(50),
                    numeroLunas INTEGER,
                    diametro REAL,
                    habitado INTEGER,
                    clasificacion VARCHAR(1),
                    id_ss INTEGER,
                    FOREIGN KEY (id_ss) REFERENCES SISTEMA_SOLAR(id)
                )
            """.trimIndent()
        db?.execSQL(scriptSQLCrearTablaPl)
    }
    fun crearPlaneta(idItem:Int,nombrePl:String,numL:Int,diametro:Double,tv:Int,cl:String):Boolean{
        val baseDatosEscritura = writableDatabase
        val valoresAGuardar = ContentValues()
        valoresAGuardar.put("nombre",nombrePl)
        valoresAGuardar.put("numeroLunas", numL)
        valoresAGuardar.put("diametro",diametro)
        valoresAGuardar.put("habitado", tv)
        valoresAGuardar.put("clasificacion",cl)
        valoresAGuardar.put("id_ss", idItem)
        val resultadoGuardar = baseDatosEscritura
            .insert(
                "PLANETA", // nombre tabla
                null,
                valoresAGuardar, // valores
            )
        baseDatosEscritura.close()
        return resultadoGuardar.toInt() !== -1
    }
    fun eliminarPlaneta(id:Int):Boolean{
        val conexionEscritura = writableDatabase
        // where ID = ?
        val parametrosConsultaDelete = arrayOf(id.toString())
        val resultadoEliminacion = conexionEscritura
            .delete(
                "PLANETA", // nombre tabla
                "id=?", // Consulta Where
                parametrosConsultaDelete
            )
        conexionEscritura.close()
        return resultadoEliminacion.toInt() != -1
    }
    fun actualizarPlaneta(idItem:Int,nombrePl:String,numL:Int,diametro:Double,tv:Boolean,cl:String):Boolean{
        val conexionEscritura = writableDatabase
        val valoresAActualizar = ContentValues()
        valoresAActualizar.put("nombre",nombrePl)
        valoresAActualizar.put("numeroLunas", numL)
        valoresAActualizar.put("diametro",diametro)
        valoresAActualizar.put("habitado", tv)
        valoresAActualizar.put("clasificacion",cl)
        val parametrosConsultaActualizar = arrayOf(idItem.toString())
        val resultadoActualizar = conexionEscritura
            .update(
                "PLANETA", // nombre tabla
                valoresAActualizar, // valores
            "id=?",
                parametrosConsultaActualizar
            )
        conexionEscritura.close()
        return resultadoActualizar.toInt() != -1
    }
    fun mostrarPlanetasSS(id_ss:Int):ArrayList<Planeta>{
        val baseDatosLectura = readableDatabase
        val scriptConsultaLectura ="""
            SELECT * FROM PLANETA WHERE ID_SS=?
        """.trimIndent()
        val parametrosConsultaLectura = arrayOf(id_ss.toString())
        val resultadoConsultaLectura = baseDatosLectura.rawQuery(
            scriptConsultaLectura,
            parametrosConsultaLectura
        )
        val existeSistemaSolar = resultadoConsultaLectura.moveToFirst()
        val planetas = ArrayList<Planeta>()
        if(existeSistemaSolar){
            do {
                val id = resultadoConsultaLectura.getInt(0)
                val nombrePl = resultadoConsultaLectura.getString(1)
                val numL = resultadoConsultaLectura.getInt(2)
                val diametro = resultadoConsultaLectura.getDouble(3)
                val habitado = resultadoConsultaLectura.getInt(4)
                val cl = resultadoConsultaLectura.getString(5)
                val id_ss = resultadoConsultaLectura.getInt(6)
                val planeta = Planeta(id,nombrePl,numL,habitado,diametro,cl,id_ss)
                planetas.add(planeta)
            }while (resultadoConsultaLectura.moveToNext())
        }
        resultadoConsultaLectura.close()
        baseDatosLectura.close()
        return planetas
    }
    fun consultarPlanetaPorID(id:Int):Planeta{
        val baseDatosLectura = readableDatabase
        val scriptConsultaLectura ="""
            SELECT * FROM PLANETA WHERE ID = ?
        """.trimIndent()
        val parametrosConsultaLectura = arrayOf(id.toString())
        val resultadoConsultaLectura = baseDatosLectura.rawQuery(
            scriptConsultaLectura,
            parametrosConsultaLectura,
        )
        val existePlaneta = resultadoConsultaLectura.moveToFirst()
        val planetaEncontrado = Planeta(0,"",0,1,0.0,"",0)
        val arreglo = arrayListOf<Planeta>()
        if(existePlaneta){
            do {
                val id = resultadoConsultaLectura.getInt(0) // Indice 0
                val nombrePl = resultadoConsultaLectura.getString(1)
                val numL = resultadoConsultaLectura.getInt(2)
                val diametro = resultadoConsultaLectura.getDouble(3)
                val tv = resultadoConsultaLectura.getInt(4)
                val cl = resultadoConsultaLectura.getString(5)
                val id_ss = resultadoConsultaLectura.getInt(6)
                if (id != null) {
                    planetaEncontrado.setNombre(nombrePl)
                    planetaEncontrado.setNumeroLunas(numL)
                    planetaEncontrado.setDiametro(diametro)
                    planetaEncontrado.setHabitado(tv)
                    planetaEncontrado.setClasificacion(cl)
                }
            }while (resultadoConsultaLectura.moveToNext())
        }
        resultadoConsultaLectura.close()
        baseDatosLectura.close()
        return planetaEncontrado
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}
package com.example.examenibcrud

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ESqliteHelperSS (contexto: Context?): SQLiteOpenHelper(contexto,"sistemaSolar",null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        val scriptSQLCrearTablaSS =
            """
                CREATE TABLE SISTEMA_SOLAR(
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nombre VARCHAR(50),
                    numeroPlanetas INTEGER,
                    extension NUMBER,
                    estrellaCentral CHAR
                )
            """.trimIndent()
        db?.execSQL(scriptSQLCrearTablaSS)
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
    fun mostrarSSs():ArrayList<SistemaSolar>{
        val baseDatosLectura = readableDatabase
        val scriptConsultaLectura ="""
            SELECT * FROM SISTEMA_SOLAR
        """.trimIndent()
        val resultadoConsultaLectura = baseDatosLectura.rawQuery(
            scriptConsultaLectura,
            null
        )
        val existeSistemaSolar = resultadoConsultaLectura.moveToFirst()
        val sistemasSolares = ArrayList<SistemaSolar>()
        if(existeSistemaSolar){
            do {
                val id = resultadoConsultaLectura.getInt(0)
                val nombreSS = resultadoConsultaLectura.getString(1)
                val numPl = resultadoConsultaLectura.getInt(2)
                val extension = resultadoConsultaLectura.getDouble(3)
                val ec = resultadoConsultaLectura.getString(4)
                val arr = arrayListOf<Planeta>()
                val sistemaSolarEncontrado = SistemaSolar(id,nombreSS, numPl, arr, extension, ec)
                sistemasSolares.add(sistemaSolarEncontrado)
            }while (resultadoConsultaLectura.moveToNext())
        }
        resultadoConsultaLectura.close()
        baseDatosLectura.close()
        return sistemasSolares
    }
    fun crearSistemaSolar(nombreSS:String,extension:Double,estrella:String):Boolean{
        val baseDatosEscritura = writableDatabase
        val valoresAGuardar = ContentValues()
        valoresAGuardar.put("nombre",nombreSS)
        valoresAGuardar.put("numeroPlanetas",0)
        valoresAGuardar.put("extension",extension)
        valoresAGuardar.put("estrellaCentral",estrella)
        val resultadoGuardar = baseDatosEscritura
            .insert(
                "SISTEMA_SOLAR",
                null,
                valoresAGuardar,
            )
        baseDatosEscritura.close()
        return resultadoGuardar.toInt() !== -1
    }
    fun eliminarSistema(id:Int):Boolean{
        val conexionEscritura = writableDatabase
        val parametrosConsultaDelete = arrayOf(id.toString())
        val resultadoEliminacion = conexionEscritura
            .delete(
                "SISTEMA_SOLAR",
                "id=?",
                parametrosConsultaDelete
            )
        conexionEscritura.close()
        return resultadoEliminacion.toInt() != -1
    }
    fun actualizarSS(idItem:Int,nombreSS:String,numPl:Int,extension:Double,estrella:String):Boolean{
        val conexionEscritura = writableDatabase
        val valoresAActualizar = ContentValues()
        valoresAActualizar.put("nombre",nombreSS)
        valoresAActualizar.put("numeroPlanetas",numPl)
        valoresAActualizar.put("extension",extension)
        valoresAActualizar.put("estrellaCentral",estrella)
        val parametrosConsultaActualizar = arrayOf(idItem.toString())
        val resultadoActualizar = conexionEscritura
            .update(
                "SISTEMA_SOLAR",
                valoresAActualizar,
                "id=?",
                parametrosConsultaActualizar
            )
        conexionEscritura.close()
        return resultadoActualizar.toInt() != -1
    }
    fun consultarSSPorID(id:Int):SistemaSolar{
        val baseDatosLectura = readableDatabase
        val scriptConsultaLectura ="""
            SELECT * FROM SISTEMA_SOLAR WHERE ID = ?
        """.trimIndent()
        val parametrosConsultaLectura = arrayOf(id.toString())
        val resultadoConsultaLectura = baseDatosLectura.rawQuery(
            scriptConsultaLectura,
            parametrosConsultaLectura,
        )
        val existeSistemaSolar = resultadoConsultaLectura.moveToFirst()
        val arr = arrayListOf<Planeta>()
        val sistemaSolarEncontrado = SistemaSolar(0,"",0,arr,0.0,"A")
        if(existeSistemaSolar){
            do {
                val id = resultadoConsultaLectura.getInt(0)
                val nombreSS = resultadoConsultaLectura.getString(1)
                val numPl = resultadoConsultaLectura.getInt(2)
                val extension = resultadoConsultaLectura.getDouble(3)
                val ec = resultadoConsultaLectura.getString(4)
                if (id != null) {
                    sistemaSolarEncontrado.setNombre(nombreSS)
                    sistemaSolarEncontrado.setNumeroPlanetas(numPl)
                    sistemaSolarEncontrado.setExtension(extension)
                    sistemaSolarEncontrado.setExtrellaCentral(ec)
                }
            }while (resultadoConsultaLectura.moveToNext())
        }
        resultadoConsultaLectura.close()
        baseDatosLectura.close()
        return sistemaSolarEncontrado
    }

}
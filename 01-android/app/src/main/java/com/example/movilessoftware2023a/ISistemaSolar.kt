package com.example.examenibcrud

import java.lang.Exception

class ISistemaSolar(
    private var id:String?,
    private var nombre: String?,
    private var numeroPlanetas: Int?,
    private var extension: Double?,
    private var estrellaCentral: String?
){
    init {
        this.id
        this.nombre
        this.numeroPlanetas
        this.extension
        this.estrellaCentral
    }
    fun getId():String?{
        return id
    }

    fun getNombre(): String? {
        return nombre
    }

    fun getNumeroPlanetas(): Int? {
        return numeroPlanetas
    }

    fun getExtension(): Double? {
        return extension
    }

    fun getEstrellaCentral(): String? {
        return estrellaCentral
    }

    fun setId(id:String){
        this.id = id
    }

    fun setNombre(nombre: String) {
        this.nombre = nombre
    }

    fun setNumeroPlanetas(numeroPlanetas: Int) {
        this.numeroPlanetas = numeroPlanetas
    }
    fun setExtension(extension: Double) {
        this.extension = extension
    }

    fun setExtrellaCentral(estrellaCentral: String) {
        this.estrellaCentral = estrellaCentral
    }

    override fun toString(): String {
        return "nombre: ${nombre} num.Planetas: ${numeroPlanetas} extension: ${extension} est.Central: ${estrellaCentral}"
    }
}
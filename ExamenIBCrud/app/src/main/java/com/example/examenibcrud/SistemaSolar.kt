package com.example.examenibcrud

import java.lang.Exception

class SistemaSolar(
    private var nombre: String,
    private var numeroPlanetas: Int,
    private var planetas:ArrayList<Planeta>,
    private var extension: Double,
    private var estrellaCentral: Char
){
    init {
        this.nombre
        this.numeroPlanetas
        this.planetas
        this.extension
        this.estrellaCentral
    }

    constructor(
        nombre: String,
        numeroPlanetas: Int,
        planetas: ArrayList<Planeta>,
        extension: Double?,
        estrellaCentral: Char
    ) : this(
        nombre,
        numeroPlanetas,
        planetas,
        if (extension == null) 0.0 else extension,
        estrellaCentral
    )

    fun getNombre(): String {
        return nombre
    }

    fun getNumeroPlanetas(): Int {
        return numeroPlanetas
    }

    fun getPlanetas(): ArrayList<Planeta> {
        return planetas
    }

    fun getExtension(): Double {
        return extension
    }

    fun getEstrellaCentral(): Char {
        return estrellaCentral
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

    fun setExtrellaCentral(estrellaCentral: Char) {
        this.estrellaCentral = estrellaCentral
    }
    fun getPlaneta(idPl:Int):Planeta{
        if(planetas[idPl]!=null){
            return planetas[idPl]
        }else{
            throw Exception()
        }
    }
    override fun toString(): String {
        return "nombre: ${nombre} num.Planetas: ${numeroPlanetas} extension: ${extension} est.Central: ${estrellaCentral}"
    }
}

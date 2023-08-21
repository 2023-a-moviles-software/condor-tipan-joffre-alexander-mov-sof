package com.example.examenibcrud

class Planeta(
    private var id: Int,
    private var nombre: String,
    private var numeroLunas: Int,
    private var habitado: Int,
    private var diametro: Double,
    private var clasificacion: String,
    private var id_ss: Int
) {
    init {
        this.id
        this.nombre
        this.numeroLunas
        this.habitado
        this.diametro
        this.clasificacion
        this.id_ss
    }

    fun getId():Int{
        return this.id
    }
    fun getNombre(): String {
        return nombre
    }

    fun getNumeroLunas(): Int {
        return numeroLunas
    }

    fun getHabitado(): Int {
        return habitado
    }

    fun getDiametro(): Double {
        return diametro
    }

    fun getClasificacion(): String {
        return clasificacion
    }

    fun getIdSS():Int{
        return id_ss
    }

    fun setId(id:Int){
        this.id = id
    }

    fun setNombre(nombre: String) {
        this.nombre = nombre
    }

    fun setNumeroLunas(numeroLunas: Int) {
        this.numeroLunas = numeroLunas
    }

    fun setHabitado(habitado: Int) {
        this.habitado = habitado
    }

    fun setDiametro(diametro: Double) {
        this.diametro = diametro
    }

    fun setClasificacion(clasificacion: String) {
        this.clasificacion = clasificacion
    }

    fun setIdSS(id_ss:Int){
        this.id_ss = id_ss
    }

    override fun toString(): String {
        return "Nombre: ${nombre} Num.Lunas: ${numeroLunas} Diametro: ${diametro} Tiene vida: ${if (habitado==1) "Si" else "No"} Clasificación: ${clasificacion}"
    }
}
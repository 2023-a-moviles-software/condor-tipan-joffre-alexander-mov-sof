package com.example.examenibcrud

class IPlaneta(
    private var id: String?,
    private var nombre: String?,
    private var numeroLunas: Int?,
    private var habitado: Boolean?,
    private var diametro: Double?,
    private var clasificacion: String?,
) {
    init {
        this.id
        this.nombre
        this.numeroLunas
        this.habitado
        this.diametro
        this.clasificacion
    }

    fun getId():String?{
        return this.id
    }
    fun getNombre(): String? {
        return nombre
    }

    fun getNumeroLunas(): Int? {
        return numeroLunas
    }

    fun getHabitado(): Boolean? {
        return habitado
    }

    fun getDiametro(): Double? {
        return diametro
    }

    fun getClasificacion(): String? {
        return clasificacion
    }


    fun setId(id:String){
        this.id = id
    }

    fun setNombre(nombre: String) {
        this.nombre = nombre
    }

    fun setNumeroLunas(numeroLunas: Int) {
        this.numeroLunas = numeroLunas
    }

    fun setHabitado(habitado: Boolean) {
        this.habitado = habitado
    }

    fun setDiametro(diametro: Double) {
        this.diametro = diametro
    }

    fun setClasificacion(clasificacion: String) {
        this.clasificacion = clasificacion
    }


    override fun toString(): String {
        return "Nombre: ${nombre} Num.Lunas: ${numeroLunas} Diametro: ${diametro} Tiene vida: ${if (habitado == true) "Si" else "No"} Clasificación: ${clasificacion}"
    }
}
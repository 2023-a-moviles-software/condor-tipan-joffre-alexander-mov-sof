package com.example.deber_02

class Pelicula(
    private var titulo: String,
    private var descripcion: String,
    private var imagen: String,
    private var duracion: String,
    private var genero: String
) : Contenido(titulo, descripcion, imagen) {
    init {
        this.duracion
        this.genero
    }

    fun getDuracion(): String {
        return this.duracion
    }

    fun getGenero(): String {
        return this.genero
    }

    fun setDuracion(duracion: String) {
        this.duracion = duracion
    }

    fun setGenero(genero: String) {
        this.genero = genero
    }

}
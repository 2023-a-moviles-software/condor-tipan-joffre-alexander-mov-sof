package com.example.deber_02

open class Contenido(
    private var titulo:String,
    private var descripcion:String,
    private var imagen:String
) {
    init{
        this.titulo
        this.descripcion
        this.imagen
    }
    fun getTitulo() :String{
        return this.titulo
    }
    fun getDescripcion() :String{
        return this.descripcion
    }
    fun getImagen() :String{
        return this.imagen
    }
    fun setTitulo(titulo:String){
        this.titulo = titulo
    }
    fun setDescripcion(descripcion:String){
        this.descripcion = descripcion
    }
}
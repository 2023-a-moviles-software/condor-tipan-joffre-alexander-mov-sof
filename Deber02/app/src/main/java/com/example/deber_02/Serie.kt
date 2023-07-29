package com.example.deber_02

class Serie(
    private var titulo:String,
    private var descripcion:String,
    private var imagen:String,
    private var numeroTemporadas:Int,
    private var numEpisodios:Int
) :Contenido(titulo, descripcion, imagen){
    init{
        this.numeroTemporadas
        this.numEpisodios
    }
    fun getNumeroTemporadas():Int{
        return numeroTemporadas
    }
    fun getNumeroEpisodios():Int{
        return numEpisodios
    }
}
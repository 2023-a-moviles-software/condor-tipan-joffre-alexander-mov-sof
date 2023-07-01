package com.example.movilessoftware2023a
//BBaseDatosMemoria.kt
class BBaseDatosMemoria {
    companion object{
        val arregloBEntrenador = arrayListOf<BEntrenador>()
        init {
            arregloBEntrenador
                .add(
                    BEntrenador(1,"Joffre","a@a.com")
                )
            arregloBEntrenador
                .add(
                    BEntrenador(2,"Alexander", "b@b.com")
                )
            arregloBEntrenador
                .add(
                    BEntrenador(3,"Estefany","c@c.com")
                )
        }
    }
}
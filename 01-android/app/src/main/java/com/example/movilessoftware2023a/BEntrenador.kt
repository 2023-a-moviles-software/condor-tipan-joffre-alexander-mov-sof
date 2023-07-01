package com.example.movilessoftware2023a
// BEntrenador.kt
class BEntrenador(
    var id:Int,
    var nombre: String?,
    var descripcion: String?,
){
    override fun toString(): String {
        return "${id} - ${nombre} - ${descripcion}"
    }
}
package com.example.examenibcrud

import java.lang.Exception

class BDDMemoria {
    companion object {
        private val sistemaSolarList = arrayListOf<SistemaSolar>()
        fun createSistemaSolar(
            name: String,
            numPlanetas: Int,
            planetas: ArrayList<Planeta>,
            extension: Double,
            estrellaCentral: Char
        ) {
            val sistema = SistemaSolar(name, numPlanetas, planetas, extension, estrellaCentral)
            sistemaSolarList.add(sistema)
        }

        fun createPlaneta(
            name: String,
            numLunas: Int,
            habitado: Boolean,
            diametro: Double,
            clasificacion: Char
        ): Planeta {
            val planeta = Planeta(name, numLunas, habitado, diametro, clasificacion)
            return planeta
        }

        fun deletePlaneta(ss: Int, id: Int): Boolean {
            var sis = sistemaSolarList[ss]
            if(sis != null){
                var planeta = sis.getPlanetas()[id]
                if (planeta != null) {
                    sis.getPlanetas()?.remove(planeta)
                    sis.setNumeroPlanetas(sis.getNumeroPlanetas() - 1)
                        return true
                } else {
                    return false
                }
            }else{
                return false
            }
        }

        fun getSistemas(): ArrayList<SistemaSolar> {
            var s = ArrayList<Planeta>()
            s.add(Planeta("P1",2,true,20000.0,'C'))
            s.add(Planeta("P2",3,false,200000.2,'H'))
            val s1 = SistemaSolar("Sistema 1",2,s,3000.2,'G')
            sistemaSolarList.add(s1)
            return sistemaSolarList
        }


        fun getSistema(id: Int): SistemaSolar {
            if(sistemaSolarList[id] != null) {
                return sistemaSolarList[id]
            }else{
                throw Exception()
            }
        }
        fun deleteSistemaSolar(id: Int): Boolean {
            val sis = sistemaSolarList[id]
            if(sis != null) {
                sistemaSolarList.remove(sis)
                return true
            }else{
                return false
            }
        }
        fun updateNombreSS(idSS: Int, nombre: String): Boolean {
            var sistema = sistemaSolarList[idSS]
            if (sistema != null) {
                sistema.setNombre(nombre)
                return true
            } else {
                return false
            }
        }

        fun updateExtensionSS(idSS: Int, extension: Double): Boolean {
            var sistema = sistemaSolarList[idSS]
            if (sistema != null) {
                sistema.setExtension(extension)
                return true
            } else {
                return false
            }
        }
        fun updateEstrellaCSS(idSS: Int, esC: Char): Boolean {
            var sistema = sistemaSolarList[idSS]
            if (sistema != null) {
                sistema.setExtrellaCentral(esC)
                return true
            } else {
                return false
            }
        }
        fun agregarPlaneta(idSS:Int, nombrePl:String, numPl:Int, diametro:Double, habitado:Boolean, clasificacion:Char){
            var pl = createPlaneta(nombrePl,numPl,habitado,diametro,clasificacion)
            var s = sistemaSolarList[idSS]
            s.getPlanetas().add(pl)
            s.setNumeroPlanetas(s.getNumeroPlanetas()+1)
        }
        fun updateNombrePl(numSS: Int, numPl: Int, nombre: String): Boolean {
            var planeta = sistemaSolarList.get(numSS)?.getPlanetas()?.get(numPl)
            if (planeta != null) {
                planeta.setNombre(nombre)
                return true
            } else {
                return false
            }
        }

        fun updateNumLPl(numSS: Int, numPl: Int, numL: Int): Boolean {
            var planeta = sistemaSolarList.get(numSS)?.getPlanetas()?.get(numPl)
            if (planeta != null) {
                planeta.setNumeroLunas(numL)
                return true
            } else {
                return false
            }
        }

        fun updateDiametroPl(numSS: Int, numPl: Int, diametro: Double): Boolean {
            var planeta = sistemaSolarList.get(numSS)?.getPlanetas()?.get(numPl)
            if (planeta != null) {
                planeta.setDiametro(diametro)
                return true
            } else {
                return false
            }
        }

        fun updateExistenciaVidaPl(numSS: Int, numPl: Int, habitado:Boolean): Boolean {
            var planeta = sistemaSolarList.get(numSS)?.getPlanetas()?.get(numPl)
            if (planeta != null) {
                planeta.setHabitado(habitado)
                return true
            } else {
                return false
            }
        }

        fun updateClasificacionPl(numSS: Int, numPl: Int, clasificacion: Char): Boolean {
            var planeta = sistemaSolarList.get(numSS)?.getPlanetas()?.get(numPl)
            if (planeta != null) {
                planeta.setClasificacion(clasificacion)
                return true
            } else {
                return false
            }
        }
    }
}
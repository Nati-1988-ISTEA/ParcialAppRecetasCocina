package com.example.parcialapprecetascocina

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
@Parcelize

data class Recetas(
    val id : Int,
    val nombre: String,
    val dificultad: dificultadReceta,
    val pais: paisReceta,
    val ingredientes: String,
    val receta: String,
    val porciones: Int,
    val tiempo: Int,
    val fotografia: String,

    ): Parcelable

enum class paisReceta {
    ARGENTINA, BRASIL, COLOMBIA, ECUADOR, PARAGUAY, PERU, URUGUAY, VENEZUELA, MEXICO
}

enum class dificultadReceta {
    VERYEASY, EASY, MEDIUM, DIFICULT, ISVERIDIFICUL
}

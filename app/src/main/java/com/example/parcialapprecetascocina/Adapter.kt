package com.example.parcialapprecetascocina


import android.content.Context
import android.content.DialogInterface.OnClickListener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapter(val context: Context): ListAdapter <Recetas, Adapter.ViewHolder>(DiffCallBack)
{
    lateinit var  onItemClickListener: (Recetas) -> Unit

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val name: TextView = view.findViewById(R.id.nombreReceta)
        private val dificultad: TextView = view.findViewById(R.id.dificultadReceta)
        //private val country: TextView = view.findViewById(R.id.nacionReceta)
        private val banderin : ImageView = view.findViewById(R.id.banderitaReceta)
        private val porciones : TextView = view.findViewById(R.id.porcionesReceta)
        private val tiempo : TextView = view.findViewById(R.id.tiempoReceta)
        private val foto : ImageView = view.findViewById(R.id.imagenReceta)


        fun bind(receta: Recetas) {
            // NOMBRE RECETA
            name.text = receta.nombre

            // DIFICULTAD RECETA
            val dif = when (receta.dificultad) {
                dificultadReceta.VERYEASY -> "Dificultad: ⭐"
                dificultadReceta.EASY -> "Dificultad: ⭐⭐"
                dificultadReceta.MEDIUM -> "Dificultad: ⭐⭐⭐"
                dificultadReceta.DIFICULT -> "Dificultad: ⭐⭐⭐⭐"
                else -> "Dificultad: ⭐⭐⭐⭐⭐"
            }
            dificultad.text = dif

            // PAIS Y BANCERA RECETA
            //country.text = "Pais: " + receta.pais.toString()

            val banderita = when (receta.pais) {
                paisReceta.ARGENTINA ->R.drawable.arg
                paisReceta.BRASIL ->R.drawable.brz
                paisReceta.COLOMBIA ->R.drawable.col
                paisReceta.ECUADOR ->R.drawable.ecu
                paisReceta.MEXICO ->R.drawable.mex
                paisReceta.PARAGUAY ->R.drawable.par
                paisReceta.PERU ->R.drawable.per
                paisReceta.URUGUAY ->R.drawable.uru
                else -> R.drawable.ven
            }

            banderin.setImageResource(banderita)

            // PORCIONES RECETA
            porciones.text = "Porciones: " + receta.porciones.toString() + " \uD83C\uDF7D️"

            // TIEMPO RECETA
            tiempo.text = "Tiempo Preparación: " + receta.tiempo.toString() + " \uD83D\uDD57"

            Glide.with(context).load(receta.fotografia).into(foto)

            view.setOnClickListener{
                onItemClickListener(receta) // que se complete con si mismo

            }

        }


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder
    {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int)
    {
        val receta = getItem(position)
        holder.bind(receta)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Recetas>()
    {
        override fun areItemsTheSame(oldItem: Recetas, newItem: Recetas): Boolean
        {
            return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Recetas, newItem: Recetas): Boolean
        {
            return oldItem == newItem
        }
    }

}

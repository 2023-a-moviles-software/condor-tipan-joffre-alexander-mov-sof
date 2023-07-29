package com.example.deber_02

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class FRecyclerViewAdaptadorPelicula(
    private val contexto: FRecyclerViewPelicula,
    private val lista:List<Pelicula>):RecyclerView.Adapter<FRecyclerViewAdaptadorPelicula.MyViewHolder>() {
    inner class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
        val imagen:ImageView
        init{
            imagen = view.findViewById(R.id.iv_pl)
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val intent = Intent(itemView.context, PeliculaView::class.java)
                    // Puedes pasar datos adicionales a la segunda actividad utilizando el Intent, si es necesario.
                    intent.putExtra("posicion", position)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.recycler_view_vista,
                parent,
                false
            )
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val pelicula = this.lista[position]
        Glide.with(holder.imagen.context).load(pelicula.getImagen()).into(holder.imagen)
    }
    override fun getItemCount(): Int = lista.size
}



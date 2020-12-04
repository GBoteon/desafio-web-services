package com.example.desafiowebservices.adapter

import android.annotation.SuppressLint
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiowebservices.R
import com.example.desafiowebservices.`class`.Res
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.main_item.view.*

class MainAdapter(private val hqsList: Res, private val listener: OnItemClickListener): RecyclerView.Adapter<MainAdapter.MainViewHolder>()  {
    inner class MainViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val nome: TextView = itemView.item_nome
        val poster: ImageView = itemView.item_poster
        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    override fun getItemCount() = hqsList.data.results.size

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.main_item, parent, false)
        return MainViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val itemAtual = hqsList.data.results[position]
        holder.nome.text = "#${itemAtual.issueNumber}"
        Picasso.get().load(Uri.parse("${itemAtual.thumbnail.path}.${itemAtual.thumbnail.extension}")).into(holder.poster)
    }
}
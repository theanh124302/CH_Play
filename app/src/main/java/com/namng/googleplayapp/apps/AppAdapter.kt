package com.namng.googleplayapp.apps

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.namng.googleplayapp.R

class AppAdapter(val items: ArrayList<AppModel>, val listener: ItemClickListener? = null): RecyclerView.Adapter<AppAdapter.ItemViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppAdapter.ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_apps,parent,false)
        return ItemViewHolder(itemView, listener)
    }

    override fun onBindViewHolder(holder: AppAdapter.ItemViewHolder, position: Int) {
        holder.imageThumb.setImageResource(items[position].imageThumb)
        holder.nameApp.text = items[position].name
        holder.numberStar.text = items[position].numberStar
    }

    override fun getItemCount(): Int {
        return items.size
    }

    interface ItemClickListener {
        fun ItemClick(position: Int)
    }

    class ItemViewHolder(val itemView: View, val listener: ItemClickListener?): RecyclerView.ViewHolder(itemView) {
        val imageThumb: ImageButton
        val nameApp: TextView
        val numberStar: TextView
        init{
            imageThumb = itemView.findViewById(R.id.image_app)
            nameApp = itemView.findViewById(R.id.name_app)
            numberStar = itemView.findViewById(R.id.number_star)
            itemView.setOnClickListener {
                listener?.ItemClick(adapterPosition)
            }
        }
    }
}
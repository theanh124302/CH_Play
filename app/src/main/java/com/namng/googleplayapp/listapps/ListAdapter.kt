package com.namng.googleplayapp.listapps

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.namng.googleplayapp.R

class ListAdapter(val context: Context, val items: ArrayList<ListModel>, val listener: ListAdapter.ItemClickListener? = null): RecyclerView.Adapter<ListAdapter.ItemViewHolder>()   {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_horizontal,parent,false)
        return ItemViewHolder(itemView, listener)
    }

    override fun onBindViewHolder(holder: ListAdapter.ItemViewHolder, position: Int) {
        holder.listapp.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        holder.listapp.adapter = items[position].listapp
        holder.name.text = items[position].name
    }

    override fun getItemCount(): Int {
        return items.size
    }

    interface ItemClickListener {
        fun ItemClick(position: Int)
    }

    class ItemViewHolder(val itemView: View, val listener: ItemClickListener?): RecyclerView.ViewHolder(itemView) {
        val name: TextView
        val listapp: RecyclerView
        init{
            name = itemView.findViewById(R.id.name_list_app)
            listapp = itemView.findViewById(R.id.app_recycler_view)
            itemView.setOnClickListener {
                listener?.ItemClick(adapterPosition)
            }
        }
    }
}
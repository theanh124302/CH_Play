package com.namng.googleplayapp.category

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.namng.googleplayapp.R

class CategoryAdapter(val items: ArrayList<CategoryModel>, val listener: ItemClickListener? = null): RecyclerView.Adapter<CategoryAdapter.ItemViewHolder>()  {
    @SuppressLint("ResourceType")
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryAdapter.ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.category_bar,parent,false)
        return ItemViewHolder(itemView, listener)
    }

    override fun onBindViewHolder(holder: CategoryAdapter.ItemViewHolder, position: Int) {
        holder.button.setText(items[position].name)

    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ItemViewHolder(val itemView: View, val listener: ItemClickListener?): RecyclerView.ViewHolder(itemView) {
        val button: Button
        init{
            button = itemView.findViewById(R.id.button)
            itemView.setOnClickListener {
                listener?.ItemClick(adapterPosition)
            }
        }
    }

    interface ItemClickListener {
        fun ItemClick(position: Int)
    }

}
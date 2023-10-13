package com.example.weddingplanner.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.entities.Categories
import com.example.weddingplanner.R
import com.example.weddingplanner.presentation.adapter.listener.CategoryListener

class CategoryAdapter(private val listener : CategoryListener) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>(){

    private val categoryList = mutableListOf<Categories>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)

        return CategoryViewHolder(view)
    }

    override fun getItemCount(): Int = categoryList.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val categories = categoryList[position]

        Glide.with(holder.itemView)
            .load(categories.icon)
            .into(holder.icon)

        holder.btFav.setOnClickListener {
            holder.btFav.visibility = View.GONE
            holder.deleteFav.visibility = View.VISIBLE
            listener.getCategoryListener(categories)
        }

        holder.deleteFav.setOnClickListener {
            listener.getCategoryListener(categories)
            holder.deleteFav.visibility = View.GONE
            holder.btFav.visibility = View.VISIBLE
        }

        if (categories.isCompleted){
            holder.btFav.visibility = View.GONE
            holder.deleteFav.visibility = View.VISIBLE
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItem(list : List<Categories>){
        categoryList.clear()
        categoryList.addAll(list)
        notifyDataSetChanged()
    }

    class CategoryViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val icon : ImageView = view.findViewById(R.id.ic_category)
        val btFav : ImageView = view.findViewById(R.id.ic_add_fav)
        val deleteFav : ImageView = view.findViewById(R.id.ic_delete_fav)
    }
}
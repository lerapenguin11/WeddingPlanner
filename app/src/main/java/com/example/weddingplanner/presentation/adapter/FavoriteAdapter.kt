package com.example.weddingplanner.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.entities.Favorite
import com.example.weddingplanner.R
import com.example.weddingplanner.presentation.adapter.listener.FavoriteListener

class FavoriteAdapter(private val listener : FavoriteListener) : RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>(){

    private val favoriteList = mutableListOf<Favorite>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_fav, parent, false)

        return FavoriteViewHolder(view)
    }

    override fun getItemCount(): Int = favoriteList.size

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val fav = favoriteList[position]

        Glide.with(holder.itemView)
            .load(fav.icon)
            .into(holder.icon)

        holder.btFav.setOnClickListener {
            listener.getFavoriteListener(fav)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItem(list : List<Favorite>){
        favoriteList.clear()
        favoriteList.addAll(list)
        notifyDataSetChanged()
    }

    class FavoriteViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val icon : ImageView = view.findViewById(R.id.ic_category)
        val btFav : ImageView = view.findViewById(R.id.ic_add_fav)
    }
}
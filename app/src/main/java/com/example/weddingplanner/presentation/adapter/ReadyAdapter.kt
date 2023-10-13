package com.example.weddingplanner.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entities.Ready
import com.example.domain.entities.Todo
import com.example.weddingplanner.R
import com.example.weddingplanner.presentation.adapter.listener.ReadyListener

class ReadyAdapter(private val listener : ReadyListener) : RecyclerView.Adapter<ReadyAdapter.ReadyViewHolder>() {

    private val readyList = mutableListOf<Ready>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReadyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ready, parent, false)

        return ReadyViewHolder(view)
    }

    override fun getItemCount(): Int = readyList.size

    override fun onBindViewHolder(holder: ReadyViewHolder, position: Int) {
        val ready : Ready = readyList[position]

        holder.icon.setImageResource(ready.icon)
        holder.text.text = ready.text
        holder.itemView.setOnClickListener {
            listener.getReadyListener(ready)
            holder.check.setImageResource(R.drawable.ic_check)
        }

        if (ready.isCompleted){
            holder.check.setImageResource(R.drawable.ic_check)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItem(list : List<Ready>){
        readyList.clear()
        readyList.addAll(list)
        notifyDataSetChanged()
    }

    class ReadyViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val check : ImageView = view.findViewById(R.id.ic_check_ready)
        val icon : ImageView = view.findViewById(R.id.ic_ready)
        val text : TextView = view.findViewById(R.id.tv_ready)
    }
}
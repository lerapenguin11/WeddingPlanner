package com.example.weddingplanner.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entities.Todo
import com.example.weddingplanner.R
import com.example.weddingplanner.presentation.adapter.listener.TodoListener

class TodoAdapter(private val listener : TodoListener) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>(){

    private val todoList = mutableListOf<Todo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_things_to_do, parent, false)

        return TodoViewHolder(view)
    }

    override fun getItemCount(): Int = todoList.size

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo : Todo = todoList[position]

        holder.text.text = todo.text

        holder.itemView.setOnClickListener {
            listener.getTodoListener(todo = todo)
            holder.check.visibility = View.VISIBLE
        }

        if (todo.isCompleted){
            holder.check.visibility = View.VISIBLE
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItem(list : List<Todo>){
        todoList.clear()
        todoList.addAll(list)
        notifyDataSetChanged()
    }

    class TodoViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val text : TextView = view.findViewById(R.id.tv_to_do)
        val check : ImageView = view.findViewById(R.id.ic_to_do_check)
    }
}
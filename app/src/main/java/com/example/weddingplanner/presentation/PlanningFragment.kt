package com.example.weddingplanner.presentation

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.entities.Todo
import com.example.weddingplanner.R
import com.example.weddingplanner.databinding.FragmentPlanningBinding
import com.example.weddingplanner.presentation.adapter.TodoAdapter
import com.example.weddingplanner.viewmodel.TodoViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlanningFragment : Fragment() {
    private var _binding : FragmentPlanningBinding? = null
    private val binding get() = _binding!!
    private val todoViewModel by viewModel<TodoViewModel>()
    private val todoAdapter = TodoAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPlanningBinding.inflate(inflater, container, false)

        binding.btAdd.setOnClickListener {
            showTodoDialog()
        }
        todoViewModel.getAllTodo()
        binding.rvThingsToDo.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvThingsToDo.adapter = todoAdapter

        todoViewModel.todoList.observe(viewLifecycleOwner, Observer {
            if (it.isNotEmpty()){
                binding.cvToDo.visibility = View.VISIBLE
            }
            todoAdapter.setItem(it)
        })

        return binding.root
    }

    private fun showTodoDialog() {
        val dialog = context?.let { Dialog(it) }
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCancelable(false)
        dialog?.setContentView(R.layout.item_dialog_todo)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val close : ImageButton = dialog!!.findViewById(R.id.ib_close)
        val enterText : EditText = dialog.findViewById(R.id.et_enter_todo)
        val done : ConstraintLayout = dialog.findViewById(R.id.bt_bt_done)

        dialog.show()

        done.setOnClickListener {
            val text = enterText.text.toString()
            if (text.isNotEmpty()){
                val note = Todo(text = text, isCompleted = false)
                todoViewModel.insertTodo(note)
                enterText.text.clear()
                binding.cvToDo.visibility = View.VISIBLE
                dialog.cancel()
            } else{
                Toast.makeText(requireContext(), "Enter the text", Toast.LENGTH_SHORT).show()
            }
        }

        close.setOnClickListener{dialog.cancel()}
    }
}
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
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.entities.Ready
import com.example.domain.entities.Todo
import com.example.weddingplanner.R
import com.example.weddingplanner.databinding.FragmentHomeBinding
import com.example.weddingplanner.presentation.adapter.ReadyAdapter
import com.example.weddingplanner.presentation.adapter.TodoAdapter
import com.example.weddingplanner.presentation.adapter.listener.ReadyListener
import com.example.weddingplanner.presentation.adapter.listener.TodoListener
import com.example.weddingplanner.viewmodel.ReadyViewModel
import com.example.weddingplanner.viewmodel.RegistrationViewModel
import com.example.weddingplanner.viewmodel.TodoViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(), TodoListener, ReadyListener {
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val todoViewModel by viewModel<TodoViewModel>()
    private val todoAdapter = TodoAdapter(this)
    private lateinit var list : List<Todo>
    private val readyViewModel by viewModel<ReadyViewModel>()
    private val readyAdapter = ReadyAdapter(this)
    private lateinit var viewModel: RegistrationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(RegistrationViewModel::class.java)

        binding.tvName.text = viewModel.sharedPreferences.getString("name", "null")
        binding.tvDate.text = viewModel.sharedPreferences.getString("date", "null")

        binding.btAdd.setOnClickListener {
            showTodoDialog()
        }

        readyViewModel.getAllReady()
        binding.rvReady.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvReady.adapter = readyAdapter
        readyViewModel.readyList.observe(viewLifecycleOwner, Observer {
            if (it.isEmpty()){
                readyViewModel.init()
                readyViewModel.insertReady(readyViewModel.list)
                readyAdapter.setItem(it)
            } else{
                readyAdapter.setItem(it)
            }
        })

        todoViewModel.getAllTodo()
        binding.rvThingsToDo.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvThingsToDo.adapter = todoAdapter

        todoViewModel.todoList.observe(viewLifecycleOwner, Observer {
            if (it.isNotEmpty()){
                binding.cvToDo.visibility = View.VISIBLE
            }
            todoAdapter.setItem(it)
            list = it
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

                if (list.isEmpty()){
                    val note = Todo(text = text, isCompleted = false, id = 0)
                    todoViewModel.insertTodo(note)
                } else{
                    val last = list.last()
                    var lastId : Int = last.id
                    lastId++
                    val note = Todo(text = text, isCompleted = false, id = lastId)
                    todoViewModel.insertTodo(note)
                }
                enterText.text.clear()
                binding.cvToDo.visibility = View.VISIBLE
                dialog.cancel()

            } else{
                Toast.makeText(requireContext(), "Enter the text", Toast.LENGTH_SHORT).show()
            }
        }

        close.setOnClickListener{dialog.cancel()}
    }

    override fun getTodoListener(todo: Todo) {
        todoViewModel.updateTodo(Todo(id = todo.id, text = todo.text, isCompleted = true))
    }

    override fun getReadyListener(ready: Ready) {
        readyViewModel.updateReady(Ready(id = ready.id, text = ready.text, isCompleted = true, icon = ready.icon))
    }

    override fun onResume() {
        super.onResume()
        (activity as MainActivity).showBottomNavigationView()
    }
}
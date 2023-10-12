package com.example.data.mappers

import com.example.data.entities.Note
import com.example.domain.entities.Todo

class NoteEntityMapper {

    fun toNoteEntity(todo: Todo): Note {
        return Note(
            id = todo.id,
            text = todo.text,
            isCompleted = todo.isCompleted
        )
    }

    fun toTodo(note: Note): Todo {
        return Todo(
            id = note.id,
            text = note.text,
            isCompleted = note.isCompleted
        )
    }

    /*fun toTodoString(text: String): Todo {
        return Todo(

            text = text,
            isCompleted = false
        )
    }*/
}
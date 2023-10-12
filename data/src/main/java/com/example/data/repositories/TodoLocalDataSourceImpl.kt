package com.example.data.repositories

import com.example.data.db.NoteDao
import com.example.data.entities.Note
import com.example.data.mappers.NoteEntityMapper
import com.example.domain.entities.Todo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class TodoLocalDataSourceImpl(
    private val noteDao: NoteDao,
    private val noteEntityMapper: NoteEntityMapper) : TodoLocalDataSource{

    override fun getAllNotes(): Flow<List<Todo>> {
        val noteFlow = noteDao.getAllNotes()

        return noteFlow.map { list ->
            list.map { element ->
                noteEntityMapper.toTodo(element)
            }
        }
    }

    override suspend fun getInsert(todo: Todo) {
        withContext(Dispatchers.IO){
            noteDao.insert(noteEntityMapper.toNoteEntity(todo = todo))
        }
    }

    override suspend fun getUpdate(todo: Todo) {
        withContext(Dispatchers.IO){
            noteDao.update(noteEntityMapper.toNoteEntity(todo = todo))
        }
    }
}
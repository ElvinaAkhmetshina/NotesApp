package ru.el.notesapp.database.room.repository

import androidx.lifecycle.LiveData
import ru.el.notesapp.database.DatabaseRepository
import ru.el.notesapp.database.room.dao.NoteRoomDao
import ru.el.notesapp.model.Note

class RoomRepository(private val noteRoomDao: NoteRoomDao): DatabaseRepository {
    override val readAll: LiveData<List<Note>>
        get() = noteRoomDao.getAllNotes()

    override suspend fun create(note: Note, onSuccess: () -> Unit) {
        noteRoomDao.addNote(note = note)
        onSuccess()
    }

    override suspend fun delete(note: Note, onSuccess: () -> Unit) {
        noteRoomDao.deleteNote(note=note)
        onSuccess()
    }

    override suspend fun update(note: Note, onSuccess: () -> Unit) {
        noteRoomDao.updateNote(note=note)
        onSuccess()
    }

}
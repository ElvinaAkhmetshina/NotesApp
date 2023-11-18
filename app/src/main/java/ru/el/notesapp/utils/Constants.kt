package ru.el.notesapp.utils

import ru.el.notesapp.database.DatabaseRepository
import ru.el.notesapp.navigation.NavRoute

const val TYPE_DATABASE = "type_database"
const val TYPE_ROOM = "type_room"
const val TYPE_FIREBASE = "type_firebase"

lateinit var REPOSITORY: DatabaseRepository

object Constants {
    object Keys{
        const val START = "Начать"
        const val NOTE_DATABASE = "notes_database"
        const val NOTES_TABLE = "notes_table"
        const val ADD_NEW_NOTE = "notes_table"
        const val NOTE_TITLE = "notes_table"
        const val NOTE_SUBTITLE = "notes_table"
        const val ADD_NOTE = "Добавить новую заметку"
        const val TITLE = "title"
        const val SUBTITLE = "subtitle"
        const val DATE = "date"
        const val WHAT_WILL_WE_USE = "notes_table"
        const val ROOM_DATABASE = "notes_table"
        const val FIREBASE_DATABASE = "notes_table"
        const val ID= "id"
        const val NONE= "none"
        const val UPDATE_NOTE = "Обновить заметку"
        const val EDIT_NOTE = "Отредактировать заметку"
        const val EMPTY = ""
        const val DELETE = "Удалить"
        const val NAV_BACK = "Назад"
        const val UPDATE = "Обновить"
        const val SORT_BY_PRIORITY = "by_priority"
        const val SORT_BY_DATE = "by_date"
    }

    object Screens{
        const val START_SCREEN="start_screen"
        const val MAIN_SCREEN="main_screen"
        const val ADD_SCREEN=("add_screen")
        const val NOTE_SCREEN=("note_screen")
    }
}
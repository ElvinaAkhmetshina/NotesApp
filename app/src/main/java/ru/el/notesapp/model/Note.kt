package ru.el.notesapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.el.notesapp.utils.Constants.Keys.NOTES_TABLE
import java.time.LocalDate
import java.util.Date


@Entity(tableName = NOTES_TABLE)
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int =0,
    @ColumnInfo
    val title: String,
    @ColumnInfo
    val subtitle: String,
    @ColumnInfo
    val date: Long,
    @ColumnInfo
    val priority: Int
)
package com.ibrahimpesen.notesapp.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.ibrahimpesen.notesapp.Model.Notes

@Dao
interface NotesDao {

    // Tüm notları getirir
    @Query("SELECT * FROM Notes")
    fun getNotes(): LiveData<List<Notes>>
    // Önemli düzey notları getirir
    @Query("SELECT * FROM Notes WHERE priority=3")
    fun getHighNotes(): LiveData<List<Notes>>
    // Orta düzey notları getirir
    @Query("SELECT * FROM Notes WHERE priority=2")
    fun getMediumNotes(): LiveData<List<Notes>>
    // Düşük düzey notları getirir
    @Query("SELECT * FROM Notes WHERE priority=1")
    fun getLowNotes(): LiveData<List<Notes>>
    // Not ekleme için
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNotes(notes: Notes)
    // Notu silmek için
    @Query("DELETE FROM Notes WHERE id=:id")
    fun deleteNotes(id:Int)
    // Notu güncelllemek için
    @Update
    fun updatetNotes(notes: Notes)

}
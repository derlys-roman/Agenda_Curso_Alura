package br.com.alura.agendadecadastrodealunodocursodaalura.data.dao

import androidx.room.*
import br.com.alura.agendadecadastrodealunodocursodaalura.model.People

@Dao
interface RoomDAO {
    @Query("SELECT * FROM people")
    fun getAll(): List<People>

    @Insert
    fun create(people: People)

    @Delete
    fun delete(people: People)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun update(elementoEditado: People)
}
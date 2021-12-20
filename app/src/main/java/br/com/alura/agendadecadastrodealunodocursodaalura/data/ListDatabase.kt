package br.com.alura.agendadecadastrodealunodocursodaalura.data

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.alura.agendadecadastrodealunodocursodaalura.data.dao.RoomDAO
import br.com.alura.agendadecadastrodealunodocursodaalura.model.People

@Database(entities = [People::class], version = 1, exportSchema = false)
abstract class ListDatabase : RoomDatabase() {

    abstract fun roomDao(): RoomDAO
}
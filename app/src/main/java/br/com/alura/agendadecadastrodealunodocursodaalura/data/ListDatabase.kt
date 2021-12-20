package br.com.alura.agendadecadastrodealunodocursodaalura.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.alura.agendadecadastrodealunodocursodaalura.data.dao.RoomDAO
import br.com.alura.agendadecadastrodealunodocursodaalura.model.People

@Database(entities = [People::class], version = 1, exportSchema = false)
abstract class ListDatabase : RoomDatabase() {


    abstract fun roomDao(): RoomDAO

    companion object{
        private const val DATABASE_KEY : String = "people.db"
        fun getInstance(context: Context): RoomDAO {
            return Room.databaseBuilder(context, ListDatabase::class.java, DATABASE_KEY)
                .allowMainThreadQueries()
                .build()
                .roomDao()
        }
    }
}
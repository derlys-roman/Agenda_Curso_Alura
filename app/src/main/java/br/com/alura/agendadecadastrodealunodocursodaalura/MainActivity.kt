package br.com.alura.agendadecadastrodealunodocursodaalura

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val namesListOfStudents : MutableList<String> = mutableListOf("Johnny", "Marcus", "Johanna", "Lucas")
        val viewListOfStudents : ListView = findViewById(R.id.main_activity_list_of_students)
        viewListOfStudents.adapter =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, namesListOfStudents)
    }
}
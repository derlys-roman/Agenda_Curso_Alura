package br.com.alura.agendadecadastrodealunodocursodaalura

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.agendadecadastrodealunodocursodaalura.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val namesListOfStudents : MutableList<String> = mutableListOf("Johnny", "Marcus", "Johanna", "Lucas")
        binding.mainActivityListOfStudents.adapter =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, namesListOfStudents)
    }
}
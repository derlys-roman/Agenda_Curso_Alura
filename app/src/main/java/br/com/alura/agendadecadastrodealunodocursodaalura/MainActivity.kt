package br.com.alura.agendadecadastrodealunodocursodaalura

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.agendadecadastrodealunodocursodaalura.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val namesListOfStudents : MutableList<String> = mutableListOf("Johnny", "Marcus", "Johanna", "Lucas")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        title = "Aluno"
        setContentView(binding.root)
        listAdapting()

        binding.mainActivityFloatingButton.setOnClickListener { clicnadoButton() }

    }

    private fun listAdapting(){
        binding.mainActivityListOfStudents.adapter =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, namesListOfStudents)
    }
    private fun clicnadoButton(){
        namesListOfStudents += listOf("Shepard")
        return listAdapting()
    }
}
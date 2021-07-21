package br.com.alura.agendadecadastrodealunodocursodaalura.ui.activity

import android.R
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.agendadecadastrodealunodocursodaalura.databinding.ActivityListStudentBinding

class StudentListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListStudentBinding

    private val namesListOfStudents : MutableList<String> = mutableListOf("Johnny", "Marcus", "Johanna", "Lucas")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListStudentBinding.inflate(layoutInflater)
        title = "Aluno"
        setContentView(binding.root)
        listAdapting()

        binding.activityListStudentFab.setOnClickListener { clicnadoButton() }

    }

    private fun listAdapting(){
        binding.activityListStudentsListview.adapter =
            ArrayAdapter(this, R.layout.simple_list_item_1, namesListOfStudents)
    }
    private fun clicnadoButton(){
        namesListOfStudents += listOf("Shepard")
        return listAdapting()
    }
}
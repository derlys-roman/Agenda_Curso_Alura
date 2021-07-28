package br.com.alura.agendadecadastrodealunodocursodaalura.ui.activity

import android.R
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.agendadecadastrodealunodocursodaalura.dao.StudentDAO
import br.com.alura.agendadecadastrodealunodocursodaalura.databinding.ActivityListStudentBinding

class StudentListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListStudentBinding

    private val dao = StudentDAO()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListStudentBinding.inflate(layoutInflater)
        title = "Aluno"
        setContentView(binding.root)
        binding.activityListStudentFab.setOnClickListener{buttonFab()}

    }

    override fun onResume() {
        super.onResume()
        listAdapting()
    }

    private fun listAdapting(){
        val students = dao.allStudent()
        binding.activityListStudentsListview.adapter =
            ArrayAdapter(this, R.layout.simple_list_item_1, students)
        binding.activityListStudentsListview.setOnItemClickListener {adapterView, view, position, id ->
            //Cria uma variable local (somente dentro do metodo setonitemclicklistener)com o
            // aluno clicado, para isso é adicionado o elemento da lista
            // passando como posicao o parametro da propia listener
            val selectedStudent = students[position]
        }
    }
    private fun buttonFab(){
        callRegisterActivity()
    }

    private fun callRegisterActivity() {
        startActivity(Intent(this, StudentRegisterActivity::class.java))
    }

}
package br.com.alura.agendadecadastrodealunodocursodaalura.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.agendadecadastrodealunodocursodaalura.dao.StudentDAO
import br.com.alura.agendadecadastrodealunodocursodaalura.databinding.ActivityStudentRegisterBinding
import br.com.alura.agendadecadastrodealunodocursodaalura.model.Student

class StudentRegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStudentRegisterBinding
    private val dao = StudentDAO()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.activityRegisterStudentSaveButton.setOnClickListener{ onClick() }

    }
    private fun onClick() {

        val name = binding.activityRegisterStudentName.text.toString()
        val telephone = binding.activityRegisterStudentTelephone.text.toString()
        val email = binding.activityRegisterStudentEmail.text.toString()
        val student = Student(name, telephone, email)

        dao.save(student)
        startActivity(Intent(this, StudentListActivity::class.java))

    }

}
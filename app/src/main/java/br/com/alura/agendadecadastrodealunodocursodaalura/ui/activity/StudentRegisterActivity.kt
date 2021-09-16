package br.com.alura.agendadecadastrodealunodocursodaalura.ui.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.agendadecadastrodealunodocursodaalura.R
import br.com.alura.agendadecadastrodealunodocursodaalura.dao.PeopleDAO
import br.com.alura.agendadecadastrodealunodocursodaalura.databinding.ActivityStudentRegisterBinding
import br.com.alura.agendadecadastrodealunodocursodaalura.model.People

class StudentRegisterActivity(private val dao: PeopleDAO = PeopleDAO()) : AppCompatActivity() {
    private lateinit var binding: ActivityStudentRegisterBinding
    private lateinit var campoNome: EditText
    private lateinit var campoTelefone: EditText
    private lateinit var campoEmail: EditText
    private lateinit var adicionarPessoa: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = getString(R.string.title_new_register)
        binding = ActivityStudentRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startActivityComponents()
        adicionarPessoa.setOnClickListener {
            savePeople()
        }

    }

    private fun savePeople() {

        val one = People(
            name = campoNome.text.toString(),
            telephone = campoTelefone.text.toString(),
            email = campoEmail.text.toString()
        )

        dao.create(one)
        finish()

    }

    private fun startActivityComponents() {
        campoNome = binding.activityRegisterStudentName
        campoTelefone = binding.activityRegisterStudentTelephone
        campoEmail = binding.activityRegisterStudentEmail
        adicionarPessoa = binding.activityRegisterStudentSaveButton
    }

}
package br.com.alura.agendadecadastrodealunodocursodaalura.ui.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.agendadecadastrodealunodocursodaalura.R
import br.com.alura.agendadecadastrodealunodocursodaalura.data.ListDatabase
import br.com.alura.agendadecadastrodealunodocursodaalura.data.dao.RoomDAO
import br.com.alura.agendadecadastrodealunodocursodaalura.databinding.ActivityStudentRegisterBinding
import br.com.alura.agendadecadastrodealunodocursodaalura.model.People

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStudentRegisterBinding
    private lateinit var campoNome: EditText
    private lateinit var campoTelefone: EditText
    private lateinit var campoEmail: EditText
    private lateinit var dao: RoomDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = getString(R.string.title_new_register)

        startActivityComponents()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_register_menu_salvar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        savePeople()
        return super.onOptionsItemSelected(item)
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
        this.dao = ListDatabase.getInstance(this)
        campoNome = binding.activityRegisterStudentName
        campoTelefone = binding.activityRegisterStudentTelephone
        campoEmail = binding.activityRegisterStudentEmail
    }

}
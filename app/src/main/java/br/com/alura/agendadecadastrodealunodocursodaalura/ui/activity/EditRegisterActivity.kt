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

class EditRegisterActivity : AppCompatActivity(), ConstantsActivities {

    private lateinit var binding: ActivityStudentRegisterBinding
    private lateinit var campoNome: EditText
    private lateinit var campoTelefone: EditText
    private lateinit var campoEmail: EditText
    private var elementoEditado: People = People()
    private lateinit var dao: RoomDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentRegisterBinding.inflate(layoutInflater)
        setContentView(this.binding.root)
        title = getString(R.string.title_edit)
        val peopleReceivedSerialized: People? = intent.getParcelableExtra(PEOPLE_KEY)
        elementoEditado = peopleReceivedSerialized!!
        startActivityComponents()
        fillFields()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_register_menu_salvar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        updatePeople()
        return super.onOptionsItemSelected(item)
    }

    private fun updatePeople() {
        elementoEditado.name = campoNome.text.toString()
        elementoEditado.telephone = campoTelefone.text.toString()
        elementoEditado.email = campoEmail.text.toString()
        dao.update(elementoEditado)
        finish()
    }

    private fun startActivityComponents() {
        this.dao = ListDatabase.getInstance(this)
        this.campoNome = binding.activityRegisterStudentName
        campoTelefone = binding.activityRegisterStudentTelephone
        campoEmail = binding.activityRegisterStudentEmail
    }

    private fun fillFields() {
        campoNome.setText(elementoEditado.name)
        campoEmail.setText(elementoEditado.email)
        campoTelefone.setText(elementoEditado.telephone)
    }

}
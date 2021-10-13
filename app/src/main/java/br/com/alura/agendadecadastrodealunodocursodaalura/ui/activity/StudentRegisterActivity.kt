package br.com.alura.agendadecadastrodealunodocursodaalura.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.agendadecadastrodealunodocursodaalura.R
import br.com.alura.agendadecadastrodealunodocursodaalura.dao.PeopleDAO
import br.com.alura.agendadecadastrodealunodocursodaalura.databinding.ActivityStudentRegisterBinding
import br.com.alura.agendadecadastrodealunodocursodaalura.model.People

class StudentRegisterActivity(private val dao: PeopleDAO = PeopleDAO()) : AppCompatActivity(), ConstantsActivities {
    private lateinit var binding: ActivityStudentRegisterBinding
    private lateinit var campoNome: EditText
    private lateinit var campoTelefone: EditText
    private lateinit var campoEmail: EditText
    private var elementoEditado: People = People()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startActivityComponents()
        confere()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_register_menu_salvar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        saveRegister()
        return super.onOptionsItemSelected(item)
    }

    private fun confere() {
        val peopleReceivedSerialized: Intent = intent
        if (peopleReceivedSerialized.hasExtra(PEOPLE_KEY)) {
            title = getString(R.string.title_edit)
            elementoEditado = peopleReceivedSerialized.extras?.getParcelable(PEOPLE_KEY)!!
            fillFields()
            return
        }
        title = getString(R.string.title_new_register)
    }

    private fun saveRegister(){
        if (elementoEditado.idValid()){
            updatePeople()
            dao.update(elementoEditado)
        }else{
            savePeople()
        }
        finish()
    }

    fun updatePeople(){
        elementoEditado.name = campoNome.text.toString()
        elementoEditado.telephone = campoTelefone.text.toString()
        elementoEditado.email = campoEmail.text.toString()
    }

    private fun savePeople() {
        val one = People(
            name = campoNome.text.toString(),
            telephone = campoTelefone.text.toString(),
            email = campoEmail.text.toString()
        )
        dao.create(one)
    }

    private fun startActivityComponents() {
        campoNome = binding.activityRegisterStudentName
        campoTelefone = binding.activityRegisterStudentTelephone
        campoEmail = binding.activityRegisterStudentEmail
    }

    private fun fillFields(){
        campoNome.setText(elementoEditado.name)
        campoEmail.setText(elementoEditado.email)
        campoTelefone.setText(elementoEditado.telephone)
    }
}
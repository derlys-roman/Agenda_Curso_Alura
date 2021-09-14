package br.com.alura.agendadecadastrodealunodocursodaalura.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import br.com.alura.agendadecadastrodealunodocursodaalura.dao.PeopleDAO
import br.com.alura.agendadecadastrodealunodocursodaalura.databinding.ActivityEditBinding
import br.com.alura.agendadecadastrodealunodocursodaalura.model.People

class EditActivity(private val dao: PeopleDAO = PeopleDAO()
) : AppCompatActivity(), ConstantsActivities {
    private lateinit var binding: ActivityEditBinding
    private lateinit var editaNome: EditText
    private lateinit var editaTelefone: EditText
    private lateinit var editaEmail: EditText
    private lateinit var editarAluno: Button
    private lateinit var elementoEditado: People

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = "Editando Cadastro"
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        inicializarCampos()

        val peopleReceivedSerialized: People? =
            intent.extras?.getParcelable(PEOPLE_KEY)

        elementoEditado = peopleReceivedSerialized!!


        this.editaNome.setText(elementoEditado.name)
        this.editaTelefone.setText(elementoEditado.telephone)
        this.editaEmail.setText(elementoEditado.email)

        editarAluno.setOnClickListener{
            updateStudent()
            dao.update(elementoEditado)
            finish()

        }
    }

    private fun inicializarCampos() {
        this.editaNome = binding.activityEditName
        this.editaTelefone = binding.activityEditTelephone
        this.editaEmail = binding.activityEditEmail
        this.editarAluno = binding.activityEditSaveButton
    }

    private fun updateStudent() {

        elementoEditado.name = this.editaNome.text.toString()
        elementoEditado.telephone = this.editaTelefone.text.toString()
        elementoEditado.email = this.editaEmail.text.toString()

    }


}
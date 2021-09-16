package br.com.alura.agendadecadastrodealunodocursodaalura.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.agendadecadastrodealunodocursodaalura.R
import br.com.alura.agendadecadastrodealunodocursodaalura.dao.PeopleDAO
import br.com.alura.agendadecadastrodealunodocursodaalura.databinding.ActivityListStudentBinding
import br.com.alura.agendadecadastrodealunodocursodaalura.model.People
import com.google.android.material.floatingactionbutton.FloatingActionButton


class StudentListActivity(private val dao: PeopleDAO = PeopleDAO()) : AppCompatActivity(), ConstantsActivities{

    private lateinit var binding: ActivityListStudentBinding

    private lateinit var listView: ListView

    private lateinit var addButton: FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = getString(R.string.title_registers)

        startActivityComponents()
        addButton.setOnClickListener { buttonFab() }

    }

    private fun startActivityComponents(){
        this.listView = binding.activityListStudentsListview
        this.addButton = binding.activityListStudentFab
    }

    override fun onResume() {
        super.onResume()
        listAdapting()
    }

    private fun listAdapting() {
        val allStudents = dao.read()
        listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, allStudents)

        clickItemAction()
    }

    private fun clickItemAction() {

        listView.setOnItemClickListener { adapterView, view, position, id ->

            val openEditTextField = Intent(this, EditActivity::class.java).apply {
                putExtra(PEOPLE_KEY, adapterView.getItemAtPosition(position) as People)
            }

            startActivity(openEditTextField)
        }
    }

    private fun buttonFab() {
        callRegisterActivity()
    }

    private fun callRegisterActivity() {
        startActivity(Intent(this, StudentRegisterActivity::class.java))
    }

}
package br.com.alura.agendadecadastrodealunodocursodaalura.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
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

    private lateinit var adapter: ArrayAdapter<People>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = getString(R.string.title_registers)

        startActivityComponents()
        addButton.setOnClickListener { buttonFab() }

        listAdapting()

    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.activity_student_menu_remover, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        val menuInfo: AdapterView.AdapterContextMenuInfo =
            item.menuInfo as AdapterView.AdapterContextMenuInfo

        if(item.itemId == R.id.activity_student_menu_remove){
            adapter.getItem(menuInfo.position)?.let { removeOfList(it) }
        }


        return super.onContextItemSelected(item)
    }

    override fun onResume() {
        super.onResume()
        updateList()
    }

    private fun startActivityComponents(){
        this.listView = binding.activityListStudentsListview
        this.addButton = binding.activityListStudentFab
    }

    private fun updateList() {
        adapter.clear()
        adapter.addAll(dao.read())
    }

    private fun listAdapting() {

        adapterConfig()

        clickItemAction()

        registerForContextMenu(listView)
    }

    private fun removeOfList(people: People) {
        dao.delete(people)
        adapter.remove(people)
    }

    private fun adapterConfig() {
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1)
        listView.adapter = adapter
    }

    private fun clickItemAction() {

        listView.setOnItemClickListener { adapterView, view, position, id ->

            val openEditTextField = Intent(this, StudentRegisterActivity::class.java).apply {
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
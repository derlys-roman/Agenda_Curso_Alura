package br.com.alura.agendadecadastrodealunodocursodaalura.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.agendadecadastrodealunodocursodaalura.R
import br.com.alura.agendadecadastrodealunodocursodaalura.data.ListDatabase
import br.com.alura.agendadecadastrodealunodocursodaalura.data.dao.RoomDAO
import br.com.alura.agendadecadastrodealunodocursodaalura.databinding.ActivityListStudentBinding
import br.com.alura.agendadecadastrodealunodocursodaalura.model.People
import br.com.alura.agendadecadastrodealunodocursodaalura.ui.adapter.ListAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListActivity : AppCompatActivity(), ConstantsActivities {

    private lateinit var dao: RoomDAO
    private lateinit var binding: ActivityListStudentBinding
    private lateinit var listView: ListView
    private lateinit var addButton: FloatingActionButton
    private lateinit var adapter: ListAdapter

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
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.activity_student_menu_remover, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val menuInfo: AdapterView.AdapterContextMenuInfo =
            item.menuInfo as AdapterView.AdapterContextMenuInfo
        val toRemove: People = adapter.getItem(menuInfo.position) as People
        if (item.itemId == R.id.activity_student_menu_remove) {
            confirmRemove(toRemove)
        }
        return super.onContextItemSelected(item)
    }

    private fun confirmRemove(toRemove: People) {
        AlertDialog.Builder(this)
            .setTitle(R.string.remove_item)
            .setMessage(R.string.ready_to_remove)
            .setPositiveButton(R.string.yes) { dialog, which ->
                removeOfList(toRemove)
            }
            .setNegativeButton(R.string.no, null)
            .show()
    }

    override fun onResume() {
        super.onResume()
        updateList()
    }

    private fun startActivityComponents() {
        this.dao = ListDatabase.getInstance(this)
        this.listView = binding.activityListStudentsRecyclerview
        this.addButton = binding.activityListStudentFab
    }

    private fun updateList() {
        adapter.clear()
        adapter.addAll(dao.getAll())
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
        adapter = ListAdapter(dao.getAll() as ArrayList<People>, this)
        listView.adapter = adapter
    }

    private fun clickItemAction() {
        listView.setOnItemClickListener { adapterView, view, position, id ->
            val openEditTextField = Intent(this, EditRegisterActivity::class.java)
                .apply {
                    putExtra(PEOPLE_KEY, adapterView.getItemAtPosition(position) as People)
                }
            startActivity(openEditTextField)
        }
    }

    private fun buttonFab() {
        startActivity(Intent(this, RegisterActivity::class.java))
    }
}
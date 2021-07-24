package br.com.alura.agendadecadastrodealunodocursodaalura.ui.activity

import android.R
import android.content.Intent
import android.os.Bundle
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
        listAdapting()
        binding.activityListStudentFab.setOnClickListener{operationFab()}

    }

    private fun listAdapting(){
        binding.activityListStudentsListview.adapter =
            ArrayAdapter(this, R.layout.simple_list_item_1, dao.allStudent())
    }
    private fun operationFab(){
        startActivity(Intent(this, StudentRegisterActivity::class.java))
    }

}
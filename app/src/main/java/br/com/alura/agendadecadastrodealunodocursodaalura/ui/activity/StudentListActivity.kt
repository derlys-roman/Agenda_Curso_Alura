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
        binding.activityListStudentFab.setOnClickListener{buttonFab()}

    }

    override fun onResume() {
        super.onResume()
        listAdapting()
    }

    private fun listAdapting(){
        binding.activityListStudentsListview.adapter =
            ArrayAdapter(this, R.layout.simple_list_item_1, dao.allStudent())
    }
    private fun buttonFab(){
        callRegisterActivity()
    }

    private fun callRegisterActivity() {
        startActivity(Intent(this, StudentRegisterActivity::class.java))
    }

}
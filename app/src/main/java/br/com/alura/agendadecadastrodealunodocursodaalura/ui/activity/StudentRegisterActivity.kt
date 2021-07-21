package br.com.alura.agendadecadastrodealunodocursodaalura.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import br.com.alura.agendadecadastrodealunodocursodaalura.R
import br.com.alura.agendadecadastrodealunodocursodaalura.databinding.ActivityStudentRegisterBinding

class StudentRegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStudentRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
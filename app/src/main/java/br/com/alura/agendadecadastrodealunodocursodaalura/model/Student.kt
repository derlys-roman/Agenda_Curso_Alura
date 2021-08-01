package br.com.alura.agendadecadastrodealunodocursodaalura.model

import java.io.Serializable

open class Student(var name: String, var telephone: String, var email: String) : Serializable {


    override fun toString(): String {
        return name
    }
}

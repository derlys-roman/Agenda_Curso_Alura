package br.com.alura.agendadecadastrodealunodocursodaalura.model

open class Student(var name: String, var telephone: String, var email: String){

    override fun toString(): String {
        return name
    }
}

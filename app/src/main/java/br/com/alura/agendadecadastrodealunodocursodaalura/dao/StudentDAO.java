package br.com.alura.agendadecadastrodealunodocursodaalura.dao;


import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.agendadecadastrodealunodocursodaalura.model.Student;

public class StudentDAO {

    private final static List<Student> students = new ArrayList<>();

    public void save(Student student) {

        students.add(student);

    }

    @NotNull
    public List<Student> allStudent() {
        return new ArrayList<>(students);
    }
}

package br.com.alura.agendadecadastrodealunodocursodaalura.dao

import br.com.alura.agendadecadastrodealunodocursodaalura.model.People
import java.util.*

class PeopleDAO {

    private companion object {
        private val DATA_BASE_SIMULATED: MutableList<People> = ArrayList()
        private var idCounter = 1
    }
    fun create(people: People) {
        if (people.name.isEmpty()){
            return
        }

        people.id = idCounter
        DATA_BASE_SIMULATED.add(people)
        idCounter++
    }

    fun update(people: People) {
        if (people.name.isEmpty()) {
            return
        }

        val peopleFound: People? = searchPeople(people)
        replaceObject(peopleFound, people)
    }

    private fun replaceObject(
        peopleFound: People?,
        people: People) {

        if (peopleFound != null) {
            val studentPosition: Int = DATA_BASE_SIMULATED.indexOf(element = peopleFound)
            DATA_BASE_SIMULATED[studentPosition] = people
        }
    }

    private fun searchPeople(people: People): People? {
        for (a in DATA_BASE_SIMULATED) {
            if (a.id == people.id) {
                return a
            }
        }
        return null
    }

    fun read(): List<People> {
        return ArrayList(DATA_BASE_SIMULATED)
    }

    fun delete(people: People){

        val searchPeople = searchPeople(people)

        val studentPosition = DATA_BASE_SIMULATED.indexOf(element = searchPeople)

        DATA_BASE_SIMULATED.removeAt(studentPosition)

    }

}
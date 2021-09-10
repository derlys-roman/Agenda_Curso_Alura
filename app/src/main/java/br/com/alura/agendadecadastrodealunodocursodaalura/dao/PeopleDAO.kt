package br.com.alura.agendadecadastrodealunodocursodaalura.dao

import br.com.alura.agendadecadastrodealunodocursodaalura.model.People
import java.util.*

class PeopleDAO {

    private companion object {
        private val DATA_BASE_SIMULATED: MutableList<People> = ArrayList()
        private var idCounter = 1
    }
    fun create(people: People) {
        people.id = idCounter
        DATA_BASE_SIMULATED.add(people)
        idCounter++
    }

    fun update(people: People) {
        var peopleFound: People? = null
        for (a in DATA_BASE_SIMULATED) {
            if (a.id == people.id) {
                peopleFound = a
            }
            if (peopleFound != null){
                val studentPosition: Int = DATA_BASE_SIMULATED.indexOf(peopleFound)
                DATA_BASE_SIMULATED[studentPosition] = people
            }

        }

    }

    fun read(): List<People> {
        return ArrayList(DATA_BASE_SIMULATED)
    }


}
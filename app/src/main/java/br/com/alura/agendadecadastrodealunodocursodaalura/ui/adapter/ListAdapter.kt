package br.com.alura.agendadecadastrodealunodocursodaalura.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import br.com.alura.agendadecadastrodealunodocursodaalura.R
import br.com.alura.agendadecadastrodealunodocursodaalura.model.People

class ListAdapter(private var people: ArrayList<People>, private val context: Context) :
    BaseAdapter() {

    override fun getCount(): Int = people.size

    override fun getItem(position: Int): Any = people[position]

    override fun getItemId(position: Int): Long = people[position].id.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val inflate = getInflater(parent)
        connectDataToView(inflate, position)
        return inflate

    }

    private fun connectDataToView(inflate: View, position: Int) {
        val nome: TextView = inflate.findViewById(R.id.list_student_presentation_name)
        nome.text = people[position].name
        val telephone: TextView = inflate.findViewById(R.id.list_student_presentation_phone)
        telephone.text = people[position].telephone
    }

    private fun getInflater(parent: ViewGroup?) = LayoutInflater.from(context)
        .inflate(R.layout.list_student_presentation, parent, false)

    fun clear() {
        people.clear()
        notifyDataSetChanged()
    }

    fun addAll(list: List<People>) {
        this.people.addAll(list)
        notifyDataSetChanged()
    }

    fun remove(people: People) {
        this.people.remove(people)
        notifyDataSetChanged()
    }

}
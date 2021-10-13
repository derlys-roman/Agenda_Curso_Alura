package br.com.alura.agendadecadastrodealunodocursodaalura.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class People(
    var name: String = "",
    var telephone: String = "",
    var email: String = "",
    var id: Int = 0
) : Parcelable {

    fun idValid(): Boolean {
        if (this.id < 1) {
            return false
        }
        return true
    }
    override fun toString(): String {
        return name
    }

}

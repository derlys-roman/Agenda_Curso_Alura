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


    override fun toString(): String {
        return name
    }

}

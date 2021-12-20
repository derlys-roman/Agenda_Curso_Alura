package br.com.alura.agendadecadastrodealunodocursodaalura.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class People(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String = "",
    var telephone: String = "",
    var email: String = ""
) : Parcelable {

    override fun toString(): String {
        return name
    }

}

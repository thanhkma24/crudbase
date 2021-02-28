package thanhnhu.tn.exampleroomapp.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "user_table")
data class Users (

    val firstName: String,
    val lastName: String,
    val age: Int
 ): Parcelable
{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name ="id")
    var id: Int? = null
}
package thanhnhu.tn.exampleroomapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import thanhnhu.tn.exampleroomapp.model.Users


@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(users: Users)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Users>>

    @Update
    fun update( users: Users?)
    @Delete
    fun  delete(user: Users)
}
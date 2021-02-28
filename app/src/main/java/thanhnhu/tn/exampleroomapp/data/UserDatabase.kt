package thanhnhu.tn.exampleroomapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import thanhnhu.tn.exampleroomapp.model.Users

@Database(entities = [Users::class], version = 2, exportSchema = false)
abstract class UserDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object{
        private var INSTANCE: UserDatabase? = null

        fun getDatabase(context: Context): UserDatabase{
            if (INSTANCE != null) return INSTANCE!!
            //instance is null that's mean db is not create and create new db
            synchronized(this){
                INSTANCE  = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_database"
                ).build()
                return INSTANCE!!
            }
        }
    }

}
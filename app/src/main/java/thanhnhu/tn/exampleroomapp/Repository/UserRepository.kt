package thanhnhu.tn.exampleroomapp.Repository

import android.content.Context
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import thanhnhu.tn.exampleroomapp.data.UserDatabase
import thanhnhu.tn.exampleroomapp.model.Users

class UserRepository
{
    companion object

    {
        var userDatabase: UserDatabase? = null
        var users: LiveData<Users>? =null
        var listUser: LiveData<List<Users>>? =null
        fun initialize(context: Context) : UserDatabase
        {
            return  UserDatabase.getDatabase(context)
        }
        fun insertData(context: Context, firstName:String, lastName:String, age:Int)
        {
            userDatabase = initialize(context)
            CoroutineScope(IO).launch {
                val userDetail =  Users(firstName ,lastName,age)
                userDatabase!!.userDao().addUser(userDetail)
            }


        }
        fun getAllData(context: Context) : LiveData<List<Users>>
        {
            userDatabase = initialize(context)

            listUser = userDatabase!!.userDao().readAllData()
            return listUser as LiveData<List<Users>>

        }
        fun delete(context: Context, user: Users)
        {
            userDatabase = initialize(context)
            CoroutineScope(IO).launch {
               userDatabase!!.userDao().delete(user)
            }
        }
        fun update(context: Context,user: Users)
        {
            userDatabase = initialize(context)
            CoroutineScope(IO).launch {
                userDatabase!!.userDao().update(user)
            }

        }

    }
}
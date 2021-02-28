package thanhnhu.tn.exampleroomapp.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import thanhnhu.tn.exampleroomapp.Repository.UserRepository
import thanhnhu.tn.exampleroomapp.model.Users

//class UserViewModel(application: Application): AndroidViewModel(application) {
//    private val readAllData: LiveData<List<Users>>
//    private val repository: UserRepository
//
//    init { //run first when userviewmodel is called
//        val userDao = UserDatabase.getDatabase(application).userDao()
//        repository = UserRepository(userDao)
//        readAllData = repository.readAllData
//    }
//    fun addUser(user:Users){
//        viewModelScope.launch(Dispatchers.IO) {
//            repository.addUser(user)
//        }
//    }
//
//}
class UserViewModel : ViewModel()
{
//    val liveDataUsers: LiveData<List<Users>>? = null
    var listLiveDataUsers: LiveData<List<Users>> ? =null
    fun insertData(context:Context,fisrtName:String, lastName:String,age:Int)
    {
        UserRepository.insertData(context,fisrtName,lastName,age)
    }
    fun getAllData(context: Context): LiveData<List<Users>>
    {
        listLiveDataUsers =  UserRepository.getAllData(context)
        return listLiveDataUsers as LiveData<List<Users>>
    }
    fun delete(context:Context,users: Users)
    {
        UserRepository.delete(context,users)
    }
    fun  update(context:Context, user: Users)
    {
        UserRepository.update(context,user)
    }

}
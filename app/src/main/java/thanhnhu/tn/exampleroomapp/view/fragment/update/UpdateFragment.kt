package thanhnhu.tn.exampleroomapp.view.fragment.update

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*
import thanhnhu.tn.exampleroomapp.R
import thanhnhu.tn.exampleroomapp.model.Users
import thanhnhu.tn.exampleroomapp.viewmodel.UserViewModel

class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var mUserViewModel: UserViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_update, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
//        val user:Users = Users(args.currentUser.firstName,args.currentUser.lastName,args.currentUser.age)
//        user.id = args.currentUser.id


        view.updateFirstName.setText(args.currentUser.firstName)
        view.updateLastName.setText(args.currentUser.lastName)
        view.updateAge.setText(args.currentUser.age.toString())

        view.update_btn.setOnClickListener {
//              if(view.updateFirstName.text.toString().isEmpty())
//              {
//                  var lastName = view.updateLastName.text.toString();
//                  var age = view.updateAge.text.toString();
//
//              }
            updateItem(view.context)

        }
        return view
    }
    private fun updateItem(context:Context){
        val firstName = updateFirstName.text.toString()
        val lastName = updateLastName.text.toString()
        val age = Integer.parseInt(updateAge.text.toString())

        if (inputCheck(firstName,lastName,updateAge.text)){
            //create User object
//            val updatedUser = Users(args.currentUser.id, firstName, lastName, age)
            var updatedUser = Users(firstName, lastName, age)
            updatedUser.id = args.currentUser.id
            mUserViewModel.update(context,updatedUser)
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }
    }

    private fun inputCheck(firstName : String, lastName: String, age: Editable) : Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }


}
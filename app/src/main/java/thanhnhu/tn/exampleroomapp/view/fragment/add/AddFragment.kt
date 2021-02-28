package thanhnhu.tn.exampleroomapp.view.fragment.add

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_add.view.*
import thanhnhu.tn.exampleroomapp.R
import thanhnhu.tn.exampleroomapp.viewmodel.UserViewModel


class AddFragment : Fragment() {
    private lateinit var mUserViewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.add_btn.setOnClickListener {
            insertDataToDatabase(view.context)
        }

        return view
    }

    private fun insertDataToDatabase(context: Context) {
        var firstName = requireView().add_firstname.text.toString()
        var lastName = requireView().add_lastname.text.toString()
        var age = requireView().add_age.text.toString()
      Log.d("-----age----",firstName+""+lastName+""+age)
        if (inputCheck(firstName, lastName, age)){
            //Create User Object

            //Add Data to Database
            mUserViewModel.insertData(context,firstName,lastName,Integer.valueOf(age.trim()))
            Toast.makeText(requireContext(),"Successfully added!", Toast.LENGTH_LONG).show()
            //Navigate Back
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(),"Please fill out all fields", Toast.LENGTH_LONG).show()
        }

    }
    private fun inputCheck(firstName: String, lastName: String, age: String):Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }


}
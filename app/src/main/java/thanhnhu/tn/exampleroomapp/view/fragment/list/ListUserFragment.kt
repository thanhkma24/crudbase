package thanhnhu.tn.exampleroomapp.view.fragment.list

import android.icu.lang.UCharacter
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list.view.*
import thanhnhu.tn.exampleroomapp.R
import thanhnhu.tn.exampleroomapp.view.adapter.ListAdapter
import thanhnhu.tn.exampleroomapp.viewmodel.UserViewModel

class ListUserFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        //recyclerview
        val adapter = ListAdapter()
        val recylerview = view.recyclerView
        recylerview.adapter = adapter
        recylerview.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)


        //userviewmodel
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.getAllData(view.context)?.observe(viewLifecycleOwner, Observer {

            adapter.setData(it)

        })

        view.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
        return view
    }


}
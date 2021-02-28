package thanhnhu.tn.exampleroomapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.ListFragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_user.view.*
import thanhnhu.tn.exampleroomapp.R
import thanhnhu.tn.exampleroomapp.model.Users
import thanhnhu.tn.exampleroomapp.view.fragment.list.ListUserFragment
import thanhnhu.tn.exampleroomapp.view.fragment.list.ListUserFragmentDirections
import thanhnhu.tn.exampleroomapp.viewmodel.UserViewModel

class ListAdapter : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {
    private var userList = ArrayList<Users>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false))
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.itemView.number.text = currentItem.id.toString()
        holder.itemView.f_name.text = currentItem.firstName
        holder.itemView.l_name.text = currentItem.lastName
        holder.itemView.i_age.text = currentItem.age.toString()
        holder.itemView.btn_delete.setOnClickListener {
            userList.removeAt(position)
            var viewmode = UserViewModel()
            viewmode.delete(holder.itemView.context, currentItem)
            notifyDataSetChanged()

        }
        holder.itemView.rowLayout.setOnClickListener {
            val action = ListUserFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }


    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ListViewHolder(itemList: View) : RecyclerView.ViewHolder(itemList)

    fun setData(users: List<Users>) {
        this.userList = users as ArrayList<Users>
        notifyDataSetChanged()
    }
}
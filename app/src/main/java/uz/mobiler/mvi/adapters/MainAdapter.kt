package uz.mobiler.mvi.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import uz.mobiler.mvi.R
import uz.mobiler.mvi.databinding.ItemLayoutBinding
import uz.mobiler.mvi.models.User

class MainAdapter(
    private val users: ArrayList<User>
) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(var itemLayoutBinding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(itemLayoutBinding.root) {

        fun bind(user: User) {
            itemLayoutBinding.textViewUserName.text = user.name
            itemLayoutBinding.textViewUserEmail.text = user.email
            Picasso.get()
                .load(user.avatar)
                .into(itemLayoutBinding.imageViewAvatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(
            ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(users[position])

    fun addData(list: List<User>) {
        users.addAll(list)
    }
}
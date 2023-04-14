package com.example.apidemo

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class UsersAdapter(
    private val context: Context, private var list: MutableList<UserData.UserDataItem>
) : RecyclerView.Adapter<UsersAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.item_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user = list[position]
//        holder.name?.text = user.url
        holder.info1?.text = user.title
//        holder.iamge?.setImageResource(user.url)
//        holder.iamge?.setImageURI(Uri.parse(user.thumbnailUrl.toString()))

        holder.iamge?.let {
            Glide.with(context)
                .load(user.url)
//                .thumbnail(R.drawable.ic_launcher_background)
                .error(R.color.black)
                .into(it)
        }
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var name: TextView? = null
        var info1: TextView? = null
        var info2: TextView? = null
        var iamge: ImageView? = null
        var company: TextView? = null
        var address: TextView? = null

        init {
            name = view.findViewById(R.id.txt_user_name)
            info1 = view.findViewById(R.id.txt_user_info1)
            info2 = view.findViewById(R.id.txt_user_info2)
            iamge = view.findViewById(R.id.iv_iamge)
            address = view.findViewById(R.id.txt_user_address)
        }

    }

}



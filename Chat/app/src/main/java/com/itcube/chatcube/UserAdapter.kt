package com.itcube.chatcube

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.itcube.chatcube.databinding.ActivityAuthBinding
import com.itcube.chatcube.databinding.UserCardBinding

class UserAdapter: ListAdapter<User, UserAdapter.ItemHolder>(ItemComparator()) {

    class ItemHolder(private val binding: UserCardBinding):RecyclerView.ViewHolder(binding.root)
    {
        fun bind (user:User)= with(binding){
            message.text=user.message
            userName.text=user.name
        }
        companion object {
            fun create(parent:ViewGroup):ItemHolder{
                return ItemHolder(UserCardBinding
                    .inflate(LayoutInflater.from(parent.context),parent,false))
            }
        }
    }

    class ItemComparator : DiffUtil.ItemCallback<User>(){
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem==newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

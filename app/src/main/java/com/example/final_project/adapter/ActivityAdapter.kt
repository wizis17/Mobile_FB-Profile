package com.example.final_project.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.example.final_project.R
import com.example.final_project.api.model.UserActivity
import com.example.final_project.databinding.ItemActivityGridBinding
import com.example.final_project.databinding.ItemActivityListBinding

    class ActivityAdapter(
    private var dataSet: List<UserActivity>,
    var isGridMode: Boolean = false,
    private val onClick: (UserActivity) -> Unit
) : RecyclerView.Adapter<ActivityAdapter.ActivityViewHolder>() {

    // Modern ViewHolder using ViewBinding
    inner class ActivityViewHolder(val binding: ViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun getItemViewType(position: Int) = if (isGridMode) 1 else 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = if (viewType == 1)
            ItemActivityGridBinding.inflate(inflater, parent, false)
        else
            ItemActivityListBinding.inflate(inflater, parent, false)
        return ActivityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        val item = dataSet[position]

        // This logic checks which "face" is being used
        if (holder.binding is ItemActivityListBinding) {
            holder.binding.itemTitle.text = item.title
            holder.binding.itemDate.text = item.date
            Glide.with(holder.itemView).load(item.imageUrl).into(holder.binding.itemImage)
        } else if (holder.binding is ItemActivityGridBinding) {
            holder.binding.itemTitle.text = item.title
            holder.binding.itemDate.text = item.date
            Glide.with(holder.itemView).load(item.imageUrl).into(holder.binding.itemImage)
        }

        holder.itemView.setOnClickListener { onClick(item) }
    }

    override fun getItemCount() = dataSet.size

    fun updateData(newList: List<UserActivity>) {
        dataSet = newList
        notifyDataSetChanged()
    }
}
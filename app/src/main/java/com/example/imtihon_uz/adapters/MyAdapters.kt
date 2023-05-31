package com.example.imtihon_uz.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.imtihon_uz.databinding.RvItemBinding
import com.example.imtihon_uz.models.APIDataItem

class MyAdapters(val list: List<APIDataItem> ):RecyclerView.Adapter<MyAdapters.Vh>() {

    inner class  Vh(val rvItemBinding: RvItemBinding):RecyclerView.ViewHolder(rvItemBinding.root){
        @SuppressLint("SetText18n")
        fun onBind(user: APIDataItem){
            rvItemBinding.tv1.text = user.id.toString()
            rvItemBinding.tv2.text = user.title
            rvItemBinding.diff.text = user.body
            rvItemBinding.diff2.text = user.userId.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }
}
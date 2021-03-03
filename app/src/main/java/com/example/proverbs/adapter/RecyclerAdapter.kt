package com.example.proverbs.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.proverbs.R
import com.example.proverbs.databinding.ItemViewBinding
import com.example.proverbs.model.Folder
import com.example.proverbs.model.Model


class RecyclerAdapter(var listener:OnClick): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private val itemCallback =object : DiffUtil.ItemCallback<Model>(){
        override fun areItemsTheSame(oldItem: Model, newItem: Model): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Model, newItem: Model): Boolean {
            return oldItem.uzbek == newItem.uzbek
        }
    }

    val differ = AsyncListDiffer(this,itemCallback)

    inner class ViewHolder(private val binding:ItemViewBinding): RecyclerView.ViewHolder(binding.root){
        fun onBind(proverb:Model){
            binding.root.setOnClickListener {
                listener.onItemClick(proverb)
            }
            binding.proverbText.text = proverb.uzbek
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                ItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(differ.currentList[position])
    }

    override fun getItemCount(): Int =  differ.currentList.size

}

interface OnClick{
    fun onForwardBtnClick(folder:Folder)
    fun onFolderClick(folder: Folder)
    fun onItemClick(proverb:Model)
}
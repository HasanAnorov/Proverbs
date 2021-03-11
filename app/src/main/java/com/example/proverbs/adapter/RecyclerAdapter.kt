package com.example.proverbs.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proverbs.R
import com.example.proverbs.model.Folder
import com.example.proverbs.model.Proverb


class RecyclerAdapter(var listener: OnClick,var list:List<Proverb>):RecyclerView.Adapter<RecyclerAdapter.ProverbViewHolder>() {

    inner class ProverbViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun onBind(proverb:Proverb){

            itemView.findViewById<TextView>(R.id.proverbText).text = proverb.uzbek.toString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProverbViewHolder {
        val  view = LayoutInflater.from(parent.context).inflate(R.layout.item_view,null,false)
        return  ProverbViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProverbViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

}

interface OnClick{
    fun onForwardBtnClick(folder:Folder)
    fun onFolderClick(folder: Folder)
    fun onItemClick(proverb:Proverb)
}
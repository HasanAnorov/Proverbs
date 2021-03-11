package com.example.proverbs.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proverbs.R
import com.example.proverbs.model.Folder


class FolderRecyclerAdapter(var listener: OnClick,var list:List<Folder>):RecyclerView.Adapter<FolderRecyclerAdapter.FolderViewHolder>() {

        inner class FolderViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
            fun onBind(folder:Folder){
//                binding.backgroundPhoto.setImageResource(R.drawable.adolat)
//                binding.tvProverbNumber.text = "52 ta"
//                binding.tvThemeProverb.text = "Adolat, tenglik haqidaa"
                itemView.findViewById<TextView>(R.id.tv_theme_proverb).text = folder.folder_name.toString()
                itemView.findViewById<TextView>(R.id.tv_proverb_number).text = folder.included_proverbs.toString()


                itemView.findViewById<ImageView>(R.id.forward_button).setOnClickListener {
                    listener.onForwardBtnClick(folder)
                }
                itemView.setOnClickListener {
                    listener.onFolderClick(folder)
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FolderViewHolder {
        val  view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_folders,null,false)
        return  FolderViewHolder(view)
    }

    override fun onBindViewHolder(holder: FolderViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

}
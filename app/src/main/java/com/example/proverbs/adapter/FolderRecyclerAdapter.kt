package com.example.proverbs.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.proverbs.R
import com.example.proverbs.databinding.ItemViewFoldersBinding
import com.example.proverbs.model.Folder

class FolderRecyclerAdapter(var listener: OnClick):RecyclerView.Adapter<FolderRecyclerAdapter.FolderViewHolder>() {

    private val itemCallback = object :DiffUtil.ItemCallback<Folder>(){

        override fun areItemsTheSame(oldItem: Folder, newItem: Folder): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Folder, newItem: Folder): Boolean {
            return oldItem.folder_name == newItem.folder_name
        }

    }

    val differ = AsyncListDiffer(this,itemCallback)

        inner class FolderViewHolder(val binding: ItemViewFoldersBinding):RecyclerView.ViewHolder(binding.root){
            fun onBind(folder:Folder){
//                binding.backgroundPhoto.setImageResource(R.drawable.adolat)
//                binding.tvProverbNumber.text = "52 ta"
//                binding.tvThemeProverb.text = "Adolat, tenglik haqidaa"
                binding.tvThemeProverb.text = folder.folder_name.toString()
                binding.tvProverbNumber.text = folder.included_proverbs.toString()


                binding.forwardButton.setOnClickListener {
                    listener.onForwardBtnClick(folder)
                }
                binding.root.setOnClickListener {
                    listener.onFolderClick(folder)
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FolderViewHolder {
        return  FolderViewHolder(ItemViewFoldersBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: FolderViewHolder, position: Int) {
        holder.onBind(differ.currentList[position])
    }

    override fun getItemCount(): Int = differ.currentList.size

}
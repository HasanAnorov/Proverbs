package com.example.proverbs.ui.bottom_navigation.folders

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.proverbs.adapter.FolderRecyclerAdapter
import com.example.proverbs.adapter.OnClick
import com.example.proverbs.databinding.FragmentAllFoldersBinding
import com.example.proverbs.model.Folder
import com.example.proverbs.model.Proverb
import com.example.proverbs.viewModel.FolderViewModel


class AllFoldersFragment : Fragment(),OnClick {

    private lateinit var binding: FragmentAllFoldersBinding
    private lateinit var viewModel:FolderViewModel
    private lateinit var adapter : FolderRecyclerAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAllFoldersBinding.inflate(inflater,container,false)

        adapter = FolderRecyclerAdapter(this)

        viewModel = ViewModelProvider(this)[FolderViewModel::class.java]

        viewModel.getMutableList().observe(requireActivity(),{
            adapter.differ.submitList(it)
        })

        binding.recyclerViewFolders.adapter = adapter

        return binding.root
    }

    override fun onForwardBtnClick(folder: Folder) {
        TODO("Not yet implemented")
    }

    override fun onFolderClick(folder: Folder) {
        TODO("Not yet implemented")
    }

    override fun onItemClick(proverb: Proverb) {
        TODO("Not yet implemented")
    }

}
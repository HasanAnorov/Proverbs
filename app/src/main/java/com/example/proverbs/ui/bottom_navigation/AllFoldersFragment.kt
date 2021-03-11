package com.example.proverbs.ui.bottom_navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.proverbs.adapter.FolderRecyclerAdapter
import com.example.proverbs.adapter.OnClick
import com.example.proverbs.databinding.FragmentAllFoldersBinding
import com.example.proverbs.model.Folder
import com.example.proverbs.model.Proverb
import com.example.proverbs.networking.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AllFoldersFragment : Fragment(),OnClick {

    private lateinit var binding: FragmentAllFoldersBinding
    private lateinit var adapter : FolderRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAllFoldersBinding.inflate(inflater,container,false)

        val api = RetrofitInstance.api
        api.getAllFolders().enqueue(object : Callback<List<Folder>> {
            override fun onResponse(call: Call<List<Folder>>, response: Response<List<Folder>>) {
                if (response.isSuccessful) {

                    val list = response.body() as List<Folder>

                    adapter = FolderRecyclerAdapter(this@AllFoldersFragment, list)

                    binding.recyclerViewFolders.adapter = adapter
                }
            }

            override fun onFailure(call: Call<List<Folder>>, t: Throwable) {
                Toast.makeText(requireContext(), "Something went wrong !", Toast.LENGTH_SHORT).show()
            }
        }
        )
        
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
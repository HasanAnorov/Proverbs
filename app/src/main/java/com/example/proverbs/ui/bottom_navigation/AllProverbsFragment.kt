package com.example.proverbs.ui.bottom_navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.proverbs.adapter.FolderRecyclerAdapter
import com.example.proverbs.adapter.OnClick
import com.example.proverbs.adapter.RecyclerAdapter
import com.example.proverbs.databinding.FragmentAllProverbsBinding
import com.example.proverbs.model.Folder
import com.example.proverbs.model.Model
import com.example.proverbs.model.Proverb
import com.example.proverbs.networking.RetrofitInstance
import com.example.proverbs.viewModel.FolderViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AllProverbsFragment : Fragment(),OnClick {

    private lateinit var binding :FragmentAllProverbsBinding
    private lateinit var adapter: RecyclerAdapter
    private lateinit var viewModel:FolderViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentAllProverbsBinding.inflate(inflater,container, false)

        adapter = RecyclerAdapter(this)

        viewModel = ViewModelProvider(this)[FolderViewModel::class.java]


        val api = RetrofitInstance.api
        api.getAllProverbs().enqueue(object : Callback<List<Model>> {
            override fun onResponse(call: Call<List<Model>>, response: Response<List<Model>>) {
                if (response.isSuccessful){
                    //binding.tv.text = response.body().toString()
                    val list:List<Model> = response.body() as ArrayList<Model>

                    viewModel.getMutableList().observe(requireActivity(),{
                        adapter.differ.submitList(list)
                    })

                    binding.rv.adapter = adapter

                }
            }

            override fun onFailure(call: Call<List<Model>>, t: Throwable) {
                Toast.makeText(requireContext(), "Something went wrong !", Toast.LENGTH_SHORT).show()
            }
        })

        return binding.root
    }

    override fun onForwardBtnClick(folder: Folder) {
        TODO("Not yet implemented")
    }

    override fun onFolderClick(folder: Folder) {
        TODO("Not yet implemented")
    }

    override fun onItemClick(proverb: Model) {
        TODO("Not yet implemented")
    }


}



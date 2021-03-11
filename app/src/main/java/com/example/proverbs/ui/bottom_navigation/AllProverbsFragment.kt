package com.example.proverbs.ui.bottom_navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.proverbs.adapter.OnClick
import com.example.proverbs.adapter.RecyclerAdapter
import com.example.proverbs.databinding.FragmentAllProverbsBinding
import com.example.proverbs.model.Folder
import com.example.proverbs.model.Proverb
import com.example.proverbs.networking.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AllProverbsFragment : Fragment(),OnClick {

    private lateinit var binding :FragmentAllProverbsBinding
    private lateinit var adapter: RecyclerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentAllProverbsBinding.inflate(inflater,container, false)

        val api = RetrofitInstance.api
        api.getAllProverbs().enqueue(object : Callback<List<Proverb>> {
            override fun onResponse(call: Call<List<Proverb>>, response: Response<List<Proverb>>) {
                if (response.isSuccessful){
                    //binding.tv.text = response.body().toString()
                        val list = response.body() as List<Proverb>
                    adapter = RecyclerAdapter(this@AllProverbsFragment,list)
                    binding.rv.adapter = adapter

                }
            }

            override fun onFailure(call: Call<List<Proverb>>, t: Throwable) {
                Toast.makeText(requireContext(), "Something went wrong !", Toast.LENGTH_SHORT).show()
            }
        })

        return binding.root
    }

    override fun onForwardBtnClick(folder: Folder) {
        Toast.makeText(requireContext(), "Clicked", Toast.LENGTH_SHORT).show()
    }

    override fun onFolderClick(folder: Folder) {
        Toast.makeText(requireContext(), "Clicked", Toast.LENGTH_SHORT).show()
    }

    override fun onItemClick(proverb: Proverb) {
        Toast.makeText(requireContext(), "Clicked", Toast.LENGTH_SHORT).show()
    }


}



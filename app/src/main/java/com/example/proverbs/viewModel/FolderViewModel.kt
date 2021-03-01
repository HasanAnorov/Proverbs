package com.example.proverbs.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proverbs.model.Folder
import com.example.proverbs.repository.FolderRepository

class FolderViewModel : ViewModel() {

    private val repository = FolderRepository()

            fun getMutableList(): MutableLiveData<List<Folder>> {
                return repository.getLiveData()
            }

}
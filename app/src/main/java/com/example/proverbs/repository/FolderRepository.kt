package com.example.proverbs.repository

import androidx.lifecycle.MutableLiveData
import com.example.proverbs.model.Folder
import com.google.firebase.database.*

class FolderRepository {

    private val firebaseDatabase :FirebaseDatabase = FirebaseDatabase.getInstance()
    private lateinit var firebaseReference :DatabaseReference

    private lateinit var mutableList:MutableLiveData<List<Folder>>

    private lateinit var folders : ArrayList<Folder>

    fun getLiveData():MutableLiveData<List<Folder>>{
         firebaseReference = firebaseDatabase.getReference("proverbs")

        firebaseReference.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                folders =ArrayList<Folder>()

                snapshot.children.forEach {
                    val value = it.getValue(Folder::class.java)

                    if (value!=null){
                        folders.add(value)
                    }
                }

                mutableList.value = folders

            }

            override fun onCancelled(error: DatabaseError) {
            }

        })

        return mutableList

    }

}
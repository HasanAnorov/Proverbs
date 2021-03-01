package com.example.proverbs.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.proverbs.R

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        supportActionBar?.hide()
    }
}
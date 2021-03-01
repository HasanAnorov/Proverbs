package com.example.proverbs

import android.content.Intent
import android.os.Bundle
import android.widget.BaseExpandableListAdapter
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import com.example.proverbs.adapter.FolderRecyclerAdapter
import com.example.proverbs.adapter.OnClick
import com.example.proverbs.databinding.ActivityMainBinding
import com.example.proverbs.model.Folder
import com.example.proverbs.model.Proverb
import com.example.proverbs.ui.SearchActivity
import com.example.proverbs.viewModel.FolderViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()



        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        val search = findViewById<ImageView>(R.id.btn_search)

        val customToolbar :ImageView =findViewById(R.id.btn_nav_drawer)
        val bottomNavigationView:BottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)

        search.setOnClickListener {
            val intent = Intent(this,SearchActivity::class.java)
            startActivity(intent)
        }

        customToolbar.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        appBarConfiguration = AppBarConfiguration(
                setOf(
                        R.id.nav_saqlanganlar, R.id.nav_sozlamalar, R.id.nav_daster_haqida,R.id.nav_ulashish
                ), drawerLayout
        )

        navView.setupWithNavController(navController)
        bottomNavigationView.setupWithNavController(navController)


    }

    override fun onBackPressed() {
        val layout:DrawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        if (layout.isDrawerOpen(GravityCompat.START)){
            layout.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}
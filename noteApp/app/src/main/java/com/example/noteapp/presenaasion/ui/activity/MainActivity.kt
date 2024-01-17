package com.example.noteapp.presenaasion.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.noteapp.R

class MainActivity : AppCompatActivity() {


    private val preferencesHelper: RereH by lazy {
        PreferencesHelper(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigation(savedInstanceState)
    }

    private fun setupNavigation(savedInstanceState: Bundle?) {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        // Если поворота экрана ни разу не было
        if (savedInstanceState == null) {
            val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)

            if (preferencesHelper.isShownOnBoard) {
                navGraph.setStartDestination(R.id.homeFragment)
            } else {
                navGraph.setStartDestination(R.id.viewPagerFragment)
            }

            navController.graph = navGraph
        }
    }
}
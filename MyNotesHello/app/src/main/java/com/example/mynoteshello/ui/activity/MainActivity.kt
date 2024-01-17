package com.example.mynoteshello.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.mynoteshello.R
import com.example.mynoteshello.databinding.ActivityMainBinding
import com.example.mynoteshello.ui.models.PreferencesHelper

class MainActivity : AppCompatActivity() {

    private lateinit var binidng: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binidng = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binidng.root)
        navControl()
    }

    fun navControl() {

        val preferenceHelper = PreferencesHelper(this)
        if (!preferenceHelper.isShovOnBoard) {
            val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.fcv_activity) as NavHostFragment
            val navController = navHostFragment.navController
            val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)
            navGraph.setStartDestination(R.id.viewPagerFragment)
            navController.graph = navGraph
        }
    }
}
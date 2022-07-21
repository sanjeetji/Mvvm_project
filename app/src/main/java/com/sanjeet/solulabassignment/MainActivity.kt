package com.sanjeet.solulabassignment

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.sanjeet.solulabassignment.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        (supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment).navController.apply {
            binding.bnvAppBottomNav.setupWithNavController(this)
            addOnDestinationChangedListener { _, destination, _ ->
                binding.bnvAppBottomNav.visibility = when (destination.id) {
                    R.id.homeFragment,
                    R.id.whishlishFragment,
                    R.id.scanFragment,
                    R.id.collectionFragment,
                    R.id.profileFragment,
                    -> View.VISIBLE
                    else -> View.GONE
                }
            }
        }


    }
}
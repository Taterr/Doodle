package com.example.foodbook

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.foodbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        ButtonListeners()

        // this is to hide the ation bar
        supportActionBar?.hide()

//        // used to put delay
//        Handler(Looper.getMainLooper()).postDelayed({
//            // used to start an activity
//            val intent = Intent(this, SignUpActivity::class.java)
//            startActivity(intent)
//        }, 3000) // 3 seconds
    }

    private fun ButtonListeners()
    {
        val signupbutton = findViewById<Button>(R.id.buttonToSignUpScreen)
        val signinbutton = findViewById<Button>(R.id.buttonToSignInScreen)

        signupbutton.setOnClickListener()
        {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        signinbutton.setOnClickListener()
        {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
    }
}
package com.makhalibagas.grab.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx
import com.makhalibagas.grab.R


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView = findViewById<BottomNavigationViewEx>(R.id.bottomnavigation)
        navView.enableAnimation(false)
        navView.enableShiftingMode(false)
        navView.enableItemShiftingMode(false)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.nav_home,
            R.id.nav_activity,
            R.id.nav_payment,
            R.id.nav_message,
            R.id.nav_account
        ).build()

        val navController = Navigation.findNavController(this,
            R.id.nav_host_fragment
        )
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
        NavigationUI.setupWithNavController(navView, navController)
    }
}
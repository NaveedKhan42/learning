package com.naveed.myandroidapp.view.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.naveed.myandroidapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


private const val TAG = "MainActivity"

/**
 * Single activity application, MainActivity is used as Navigation Host for multiple fragments
 */
class MainActivity : AppCompatActivity() {

    private lateinit var navigationController: NavController

     override fun onCreate(savedInstanceState: Bundle?) {
         Log.d(TAG,"onCreate() called" )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         val toolbar: Toolbar = findViewById(R.id.my_toolbar)
         setSupportActionBar(toolbar)

         //Navigation Controller Code
         navigationController = findNavController(R.id.navigationHostFragment)

         val bottomNavigation: BottomNavigationView = findViewById(R.id.bottomNavigationView)

         NavigationUI.setupActionBarWithNavController(this, navigationController)
         NavigationUI.setupWithNavController(bottomNavigation, navigationController )


         navigationController.addOnDestinationChangedListener { _, destination, _ ->
             when (destination.id) {
                 R.id.loginFragment,
                 R.id.registrationFragment,
                 R.id.popularMovieDetailFragment -> bottomNavigationView?.visibility = View.GONE
                 else -> bottomNavigationView?.visibility = View.VISIBLE
             }
         }

    }

    override fun onSupportNavigateUp() = navigationController.navigateUp()

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, navigationController)
                || super.onOptionsItemSelected(item)
    }

    //Logging Android Life Cycle Methods
    override fun onStart() {
        Log.d(TAG,"onStart() called" )
        super.onStart()
    }

    override fun onResume() {
        Log.d(TAG,"onResume() called" )
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG,"onPause() called" )
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG,"onStop() called" )
        super.onStop()
    }

    override fun onRestart() {
        Log.d(TAG,"onRestart() called" )
        super.onRestart()
    }

    override fun onDestroy() {
        Log.d(TAG,"onDestroy() called" )
        super.onDestroy()
    }

}

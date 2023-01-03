package com.hkc.bottomnvaigationdemo4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var navController: NavController
    lateinit var appBarConfiguration: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //建構 navcontroller
        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.findNavController()

        //建構appBarConfiguration
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.homeFragment , R.id.searchFragment),draw_layout
        )


        //右上菜單
        setSupportActionBar(toolbar)
        setupActionBarWithNavController(navController , appBarConfiguration)

        //底部導航
        bottom_nav.setupWithNavController(navController)
        nav_view.setupWithNavController(navController)


//        toolbar.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {


        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu,menu)
        return true

//        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.termsAndcCnditions){
            val action = NavGraphDirections.actionGlobalTermsFragment()
            navController.navigate(action)
            true
        }else{
            item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
        }


//        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)


//        return super.onOptionsItemSelected(item)
    }
}
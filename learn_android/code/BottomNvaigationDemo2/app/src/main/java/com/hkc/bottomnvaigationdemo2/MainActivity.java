package com.hkc.bottomnvaigationdemo2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        //
//        NavController navController = new NavController(this);
        //        NavHostFragment navHostFragment =
//                (NavHostFragment) supportFragmentManager.findFragmentById(R.id.nav_host_fragment);
//        NavController navController = navHostFragment.getNavController();
        //
//        NavController navController = Navigation.findNavController(this,R.id.nav_host_fragment_container);
//        AppBarConfiguration configuration = new AppBarConfiguration.Builder(navController.getGraph()).build();
//        NavigationUI.setupActionBarWithNavController(this, navController,configuration);
//        NavigationUI.setupWithNavController(bottomNavigationView, navController);






    }
}
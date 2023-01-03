package com.hkc.bottomnvaigationdemo4

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment:Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_login.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragment3ToLoginFragment()
            val navController = findNavController()
//            val navController = NavHostFragment.findNavController(this)
//            val navController = Navigation.findNavController(view)

            navController.navigate(action)
//            navController.navigate(R.id.action_homeFragment3_to_loginFragment)


        }
    }
}
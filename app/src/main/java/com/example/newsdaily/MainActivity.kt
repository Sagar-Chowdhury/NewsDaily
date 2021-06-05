package com.example.newsdaily

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val foregeinFragment = FragmentForegein()
         val techfrag = technology()
        val spr = SportsFragment()
        setCurrentFragment(homeFragment)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)


        bottomNavigationView.setOnNavigationItemSelectedListener{
            when(it.itemId)
            {
                R.id.homemenu-> setCurrentFragment(homeFragment)
                R.id.Foregeinmenu->setCurrentFragment(foregeinFragment)
                R.id.techno->setCurrentFragment(techfrag)
                R.id.sports->setCurrentFragment(spr)

            }
            true

        }








    }
    fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper,fragment)
            commit()
        }

}
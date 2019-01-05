package com.example.hmspl.yearbookapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.view.MenuItem


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        //val fragment: Fragment
        when (item.itemId) {
            R.id.menu_budget -> {
                toolbar!!.title = getString(R.string.budget)
                // fragment = Fragment()
                // loadFragment(fragment)
                return true
            }
            R.id.menu_category -> {
                toolbar!!.title = getString(R.string.category)
                //fragment = Fragment()
                // loadFragment(fragment)
                return true
            }
            R.id.menu_monthly_budget -> {
                toolbar!!.title = getString(R.string.monthly_budget)
                //  fragment = Fragment()
                // loadFragment(fragment)
                return true
            }
        }

        return false
    }

    private var toolbar: ActionBar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = supportActionBar

        // load the store fragment by default
        toolbar!!.title = getString(R.string.budget)
        //loadFragment(new StoreFragment());
    }

    fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_frame_layout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()

    }
}

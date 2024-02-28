package com.eightgroupdev.finalwp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.eightgroupdev.finalwp.R
import com.eightgroupdev.finalwp.databinding.ActivityBottomNavBarBinding
import com.eightgroupdev.finalwp.fragments.HomeFragment
import com.eightgroupdev.finalwp.fragments.MessagesFragment
import com.eightgroupdev.finalwp.fragments.NotificationFragment
import com.eightgroupdev.finalwp.fragments.ProfileFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BottomNavBar : AppCompatActivity() {

    private lateinit var binding: ActivityBottomNavBarBinding
    private lateinit var fabcart: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomNavBarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())

        fabcart = findViewById(R.id.fab_cart)
        val fabButton = binding.fabCart

        binding.bottomNav.setOnItemSelectedListener { it ->
            when (it.itemId) {

                R.id.navigation_home -> {

                    fabButton.visibility = View.VISIBLE
                    replaceFragment(HomeFragment())
                }

                R.id.navigation_messages -> {

                    fabButton.visibility = View.GONE
                    replaceFragment(MessagesFragment())
                }

                R.id.navigation_profile -> {
                    fabButton.visibility = View.GONE
                    replaceFragment(ProfileFragment())
                }
                R.id.navigation_notification -> {
                    fabButton.visibility = View.GONE
                    replaceFragment(NotificationFragment())
                }

                else -> {
                }
            }
            true
        }
        //otherFunctions
        fab_btn()
    }

    private fun replaceFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }

    fun fab_btn(){
        val fab_cart = findViewById<FloatingActionButton>(R.id.fab_cart)
        fab_cart.setOnClickListener{
            startActivity(Intent(this@BottomNavBar, CartView::class.java))

        }
    }
}